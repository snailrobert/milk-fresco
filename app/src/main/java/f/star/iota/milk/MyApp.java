package f.star.iota.milk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okserver.OkDownload;
import com.nightfarmer.themer.Themer;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;

import java.util.concurrent.TimeUnit;

import f.star.iota.milk.config.OtherConfig;
import f.star.iota.milk.config.ThemeConfig;
import f.star.iota.milk.fresco.MyOkHttpNetworkFetcher;
import f.star.iota.milk.ui.main.MainActivity;
import f.star.iota.milk.util.FileUtils;
import okhttp3.OkHttpClient;


public class MyApp extends Application {
    private static final String FRESCO_BASE_CACHE_DIR = "fresco_main_cache";
    private static final String FRESCO_SMALL_IMAGE_CACHE_DIR = "fresco_small_image_cache";
    private static final long MAX_DISK_CACHE_SIZE = Long.MAX_VALUE;
    private static final long MAX_DISK_CACHE_LOW_SIZE = 300 * ByteConstants.MB;
    private static final long MAX_DISK_CACHE_VERY_LOW_SIZE = 100 * ByteConstants.MB;
    @SuppressLint("StaticFieldLeak")
    public static Context mContext;

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new DeliveryHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                layout.setEnableAutoLoadmore(true);
                return new ClassicsFooter(context);
            }
        });
    }

    private final long[] mIntervalException = new long[2];

    private static OkHttpClient makeOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
//        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
//        loggingInterceptor.setColorLevel(Level.INFO);
//        builder.addInterceptor(loggingInterceptor);
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(mContext)));
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
        return builder.build();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Fresco.getImagePipeline().clearMemoryCaches();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level >= ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Fresco.getImagePipeline().clearMemoryCaches();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Themer.INSTANCE.init(this, ThemeConfig.getTheme(mContext));
//        LeakCanary.install(this);
        addCount();
        initOkGo();
        initFresco();
        Crash.setExceptionHandler(new Crash.ExceptionHandler() {
            @Override
            public void handleException(final Thread thread, final Throwable throwable) {
                System.arraycopy(mIntervalException, 1, mIntervalException, 0, mIntervalException.length - 1);
                mIntervalException[mIntervalException.length - 1] = SystemClock.uptimeMillis();
                if (SystemClock.uptimeMillis() - mIntervalException[0] <= 1000) {
                    return;
                }
                if (throwable != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                FileUtils.saveCrashLog(thread, throwable);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(mContext, "很抱歉,程序出现异常,正在收集日志,若长时间无响应，请强制退出", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(mContext, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                            Looper.loop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private void initFresco() {
        MemoryTrimmableRegistry memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        memoryTrimmableRegistry.registerMemoryTrimmable(new MemoryTrimmable() {
            @Override
            public void trim(MemoryTrimType trimType) {
                final double suggestedTrimRatio = trimType.getSuggestedTrimRatio();
                if (MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio() == suggestedTrimRatio
                        || MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.getSuggestedTrimRatio() == suggestedTrimRatio
                        || MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.getSuggestedTrimRatio() == suggestedTrimRatio) {
                    Fresco.getImagePipeline().clearMemoryCaches();
                }
            }
        });
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(mContext)
                .setBaseDirectoryPath(FileUtils.getDiskCacheDir(mContext))
                .setBaseDirectoryName(FRESCO_BASE_CACHE_DIR)
                .setMaxCacheSize(MAX_DISK_CACHE_SIZE)
                .setMaxCacheSizeOnLowDiskSpace(MAX_DISK_CACHE_LOW_SIZE)
                .setMaxCacheSizeOnVeryLowDiskSpace(MAX_DISK_CACHE_VERY_LOW_SIZE)
                .setDiskTrimmableRegistry(NoOpDiskTrimmableRegistry.getInstance())
                .build();
        DiskCacheConfig diskSmallCacheConfig = DiskCacheConfig.newBuilder(mContext)
                .setBaseDirectoryPath(FileUtils.getDiskCacheDir(mContext))
                .setBaseDirectoryName(FRESCO_SMALL_IMAGE_CACHE_DIR)
                .setMaxCacheSize(MAX_DISK_CACHE_SIZE)
                .setMaxCacheSizeOnLowDiskSpace(MAX_DISK_CACHE_LOW_SIZE)
                .setMaxCacheSizeOnVeryLowDiskSpace(MAX_DISK_CACHE_VERY_LOW_SIZE)
                .setDiskTrimmableRegistry(NoOpDiskTrimmableRegistry.getInstance())
                .build();
        Supplier<MemoryCacheParams> bitmapMemoryCacheParamsSupplier = new Supplier<MemoryCacheParams>() {
            @Override
            public MemoryCacheParams get() {
                return new MemoryCacheParams(
                        getMaxCacheSize(),
                        getMaxCacheSize() / 4,
                        getMaxCacheSize(),
                        Integer.MAX_VALUE,
                        Integer.MAX_VALUE);
            }
        };
//        ProgressiveJpegConfig progressiveJpegConfig = new ProgressiveJpegConfig() {
//            @Override
//            public int getNextScanNumberToDecode(int scanNumber) {
//                return scanNumber + 2;
//            }
//
//            public QualityInfo getQualityInfo(int scanNumber) {
//                boolean isGoodEnough = (scanNumber >= 5);
//                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
//            }
//        };
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig
                .newBuilder(mContext)
                .setDownsampleEnabled(true)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .setResizeAndRotateEnabledForNetwork(true)
                .setMainDiskCacheConfig(diskCacheConfig)
                .setSmallImageDiskCacheConfig(diskSmallCacheConfig)
                .setBitmapMemoryCacheParamsSupplier(bitmapMemoryCacheParamsSupplier)
                .setMemoryTrimmableRegistry(memoryTrimmableRegistry)
//                .setProgressiveJpegConfig(progressiveJpegConfig)
                .setNetworkFetcher(new MyOkHttpNetworkFetcher(makeOkHttpClient()))
                .build();
        Fresco.initialize(mContext, imagePipelineConfig);
    }

    private void addCount() {
        long openCount = OtherConfig.getOpenCount(this);
        openCount++;
        OtherConfig.saveOpenCount(this, openCount);
    }

    private void initOkGo() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("User-Agent", Net.USER_AGENT);
        OkGo.getInstance().init(this)
                .setOkHttpClient(makeOkHttpClient())
                .setCacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setRetryCount(3)
                .addCommonHeaders(headers);
        OkDownload.getInstance().getThreadPool().setCorePoolSize(OtherConfig.getDownloadCountConfig(this));
    }

    private int getMaxCacheSize() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        final int maxMemory = Math.min(activityManager.getMemoryClass() * ByteConstants.MB, Integer.MAX_VALUE);
        if (maxMemory < 32 * ByteConstants.MB) {
            return 4 * ByteConstants.MB;
        } else if (maxMemory < 64 * ByteConstants.MB) {
            return 8 * ByteConstants.MB;
        } else {
            return maxMemory / 8;
        }
    }
}
