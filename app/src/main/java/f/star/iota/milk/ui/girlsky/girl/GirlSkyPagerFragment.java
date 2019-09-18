package f.star.iota.milk.ui.girlsky.girl;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Menus;
import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class GirlSkyPagerFragment extends PagerFragment {

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("美女图片");
        titles.add("性感美女");
        titles.add("丝袜美女");
        titles.add("外国美女");
        titles.add("街拍美女");
        titles.add("自拍美女");
        titles.add("美女写真");
        titles.add("古装美女");
        titles.add("人体艺术");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_MNTP));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_XGMN));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_SWMN));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_WGMN));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_JPMN));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_ZPMN));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_MNXZ));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_GZMN));
        fragments.add(GirlSkyFragment.newInstance(Net.GIRLSKY_RTYS));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_GIRLSKY_ID;
    }
}
