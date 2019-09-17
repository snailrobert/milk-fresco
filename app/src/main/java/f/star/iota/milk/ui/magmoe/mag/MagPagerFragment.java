package f.star.iota.milk.ui.magmoe.mag;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class MagPagerFragment extends PagerFragment {


    public static final int ILLUST = 1;
    public static final int COS = 2;


    public static MagPagerFragment newInstance(int type) {
        MagPagerFragment fragment = new MagPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();

        List<Fragment> fragments = new ArrayList<>();
        int type = getArguments().getInt("type");
        if (type == ILLUST) {
            titles.add("萌美图");
            titles.add("PIXIV");
            fragments.add(MagFragment.newInstance(Net.MAG_MOE_MOE));
            fragments.add(MagFragment.newInstance(Net.MAG_MOE_PIXIV));
        } else if (type == COS) {
            titles.add("萌星星");
            titles.add("Cosplay");
            titles.add("私房影像");
            fragments.add(MagFragment.newInstance(Net.MAG_MOE_STAR));
            fragments.add(MagFragment.newInstance(Net.MAG_MOE_COSPLAY));
            fragments.add(MagFragment.newInstance(Net.MAG_MOE_PRVIPH));
        } else {
            fragments.add(null);
            fragments.add(null);
            fragments.add(null);
            fragments.add(null);
        }
        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
