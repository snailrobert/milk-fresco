package f.star.iota.milk.ui.yuleba.yule;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import f.star.iota.milk.Net;
import f.star.iota.milk.R;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class YuLeBaPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("清纯美女");
        titles.add("性感美女");
        titles.add("日本美女");
        titles.add("丝袜美腿");
        titles.add("私房模特");
        titles.add("美女明星");
        titles.add("展会模特");
        titles.add("街拍美女");
        titles.add("网络美女");
        titles.add("精品套图");
        titles.add("美女模特");
        titles.add("秀人网");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_QINGCHUN));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_XINGGAN));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_RUBENMEINV));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_SIWAMEITUI));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_SIFANGMOTE));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_MEINVMINGXING));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_ZHANGHUIMOTE));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_JIEPAIMEINV));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_WANGLUOMEINV));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_JINPINTAOTU));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_MIENVMOTE));
        fragments.add(YuLeBaFragment.newInstance(Net.YULEBA_XIUREN));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }

    @Override
    protected void init() {
        super.init();
        mViewPager.setOffscreenPageLimit(0);
    }


}
