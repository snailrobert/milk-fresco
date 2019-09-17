package f.star.iota.milk.ui.ituba.itu;

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


public class ITuBaPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("性感美女");
        titles.add("COSPALY");
        titles.add("尤物爆乳");
        titles.add("制服诱惑");
        titles.add("清纯美眉");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ITuBaFragment.newInstance(Net.ITUBA_XINGGAN));
        fragments.add(ITuBaFragment.newInstance(Net.ITUBA_COSPLAY));
        fragments.add(ITuBaFragment.newInstance(Net.ITUBA_YOUWU));
        fragments.add(ITuBaFragment.newInstance(Net.ITUBA_ZHIFU));
        fragments.add(ITuBaFragment.newInstance(Net.ITUBA_QINGCHUN));
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
