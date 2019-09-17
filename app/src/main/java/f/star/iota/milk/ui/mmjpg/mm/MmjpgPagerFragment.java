package f.star.iota.milk.ui.mmjpg.mm;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class MmjpgPagerFragment extends PagerFragment {


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("明星名人");
        titles.add("唯美清纯");
        titles.add("活力运动");
        titles.add("靓丽模特");
        titles.add("比基尼");
        titles.add("美腿丝袜");
        titles.add("性感妖娆");
        titles.add("制服诱惑");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_MXMR));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_WHQC));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_HLYD));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_NLMT));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_BJN));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_MTCW));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_XGRY));
        fragments.add(MmjpgFragment.newInstance(Net.MMJPG_ZFXH));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }
}
