package f.star.iota.milk.ui.rosimm.rosi;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class ROSIMMPagerFragment extends PagerFragment {


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("ROSIMM写真");
        titles.add("DISI第四印象");
        titles.add("ROSIMM小莉写真");
        titles.add("ROSI写真口罩系列");
        titles.add("ROSI情趣");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ROSIMMFragment.newInstance(Net.ROSIMM));
        fragments.add(ROSIMMFragment.newInstance(Net.ROSIMM_DISI));
        fragments.add(ROSIMMFragment.newInstance(Net.ROSIMM_XIAOLI));
        fragments.add(ROSIMMFFragment.newInstance(Net.ROSIMM_KZ));
        fragments.add(ROSIMMFFragment.newInstance(Net.ROSIMM_SEXY));
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }
}
