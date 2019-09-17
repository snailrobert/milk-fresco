package f.star.iota.milk.ui.meitulu.meitu;


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


public class MeiTuPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("日韩美女");
        titles.add("港台美女");
        titles.add("国产美女");

        titles.add("女神");
        titles.add("极品");
        titles.add("嫩模");
        titles.add("网络红人");
        titles.add("风俗娘");
        titles.add("气质");
        titles.add("尤物");
        titles.add("爆乳");
        titles.add("性感");
        titles.add("诱惑");
        titles.add("美胸");
        titles.add("少妇");
        titles.add("长腿");
        titles.add("萌妹子");
        titles.add("萝莉");
        titles.add("可爱");
        titles.add("户外");
        titles.add("比基尼");
        titles.add("清纯");
        titles.add("唯美");
        titles.add("清新");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_RIHAN));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_GANGTAI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_GUOCHAN));

        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_NVSHEN));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_JIPIN));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_NENMO));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_WANGLUOHONGREN));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_FENGSUNIANG));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_QIZHI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_YOUWU));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_BAORU));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_XINGGAN));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_YOUHUO));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_MEIXIONG));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_SHAOFU));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_CHANGTUI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_MENGMEIZI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_LOLI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_KEAI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_HUWAI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_BIJINI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_QINGCHUN));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_WEIMEI));
        fragments.add(MeiTuFragment.newInstance(Net.MEITULU_QINGXIN));
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
