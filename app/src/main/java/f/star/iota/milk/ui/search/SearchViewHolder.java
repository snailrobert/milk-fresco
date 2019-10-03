package f.star.iota.milk.ui.search;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

import butterknife.BindView;
import f.star.iota.milk.Menus;
import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseActivity;
import f.star.iota.milk.base.BaseFragment;
import f.star.iota.milk.base.BaseViewHolder;
import f.star.iota.milk.fresco.FrescoLoader;
import f.star.iota.milk.ui.girlsky.girl.GirlSkyFragment;
import f.star.iota.milk.ui.gkdgif.gif.GifFragment;
import f.star.iota.milk.ui.isaob.b.BFragment;
import f.star.iota.milk.ui.itmtu.mtu.MtuFragment;
import f.star.iota.milk.ui.meitulu.meitu.MeiTuFragment;
import f.star.iota.milk.ui.meitumen.meitu.MeiTuMenFragment;
import f.star.iota.milk.ui.mzitu.tu.TuFragment;
import f.star.iota.milk.ui.pixivic.PixivicFragment;
import f.star.iota.milk.ui.tu963.www.TUFragment;
import f.star.iota.milk.ui.xsnvshen.nv.NvShenFragment;
import f.star.iota.milk.ui.xsnvshen.shen.ShenFragment;


public class SearchViewHolder extends BaseViewHolder<SearchBean> {

    @BindView(R.id.simple_drawee_view_image)
    SimpleDraweeView mSimpleDraweeView;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;
    @BindView(R.id.card_view)
    CardView mCardView;


    public SearchViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final SearchBean bean) {
        if(Menus.MENU_MZITU_ID == bean.getType()){
            HashMap<String, String> headers = bean.getHeaders();
            headers.put("Referer", "http://www.mzitu.com/");
            headers.put("Host", "i5.meizitu.net");
            FrescoLoader.load(mSimpleDraweeView, bean.getPreview(),bean.getHeaders());
        }else{
            FrescoLoader.load(mSimpleDraweeView, bean.getPreview());
        }
        mCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("从浏览器打开")
                        .setNegativeButton("嗯", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getUrl());
                            }
                        })
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                return true;
            }
        });
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) mContext).addFragment(selectSearchFragment(bean.getType(),bean.getUrl()));
            }
        });
        mTextViewDescription.setText(bean.getDescription());
    }



    private BaseFragment selectSearchFragment(int type,String url){
        BaseFragment baseFragment = null;
        switch (type) {
            case Menus.MENU_XSNVSHEN_MEINV_ID:
                if(url.contains("album")){
                    baseFragment = ShenFragment.newInstance(url);
                }else{
                    baseFragment = NvShenFragment.newInstance(url);
                }
                break;
            case Menus.MENU_MEITUMEN_MENU_ID:
                    baseFragment = MeiTuMenFragment.newInstance(url);
                break;
            case Menus.MENU_MEITULU_ID:
                baseFragment =  MeiTuFragment.newInstance(url);
                break;
            case Menus.MENU_MZITU_ID:
                baseFragment =  TuFragment.newInstance(url);
                break;
            case Menus.MENU_GIRLSKY_ID:
                baseFragment =  GirlSkyFragment.newInstance(url);
                break;
            case Menus.MENU_TU963_ID:
                baseFragment =  TUFragment.newInstance(url);
                break;
            case Menus.MENU_ITMTU_ID:
                baseFragment =  MtuFragment.newInstance(url);
                break;
            case Menus.MENU_GKDGIF_ID:
                baseFragment =  GifFragment.newInstance(url);
                break;
            case Menus.MENU_PIXIVIC_ID:
                baseFragment =  PixivicFragment.newInstance(url);
                break;
            case Menus.MENU_ISAOB_ID:
                baseFragment =  BFragment.newInstance(url);
                break;
            case Menus.MENU_NVSHENS_TAG_ID:
                baseFragment =  f.star.iota.milk.ui.nvshens.shen.ShenFragment.newInstance(url);
                break;

        }
        return  baseFragment;
    }

}
