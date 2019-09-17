package f.star.iota.milk.ui.wwwmm131net.www;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class WWWMM131NETPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("性感美女");
        titles.add("清纯美眉");
        titles.add("美女校花");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(WWWMM131NETFragment.newInstance(Net.WWWMM131NET_XG));
        fragments.add(WWWMM131NETFragment.newInstance(Net.WWWMM131NET_GC));
        fragments.add(WWWMM131NETFragment.newInstance(Net.WWWMM131NET_XH));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
