package f.star.iota.milk.ui.gkdgif.gkd;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import f.star.iota.milk.Menus;
import f.star.iota.milk.Net;
import f.star.iota.milk.R;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;


public class GkdGifPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("三次元图");
        titles.add("少女映画");
        titles.add("团子少女");
        titles.add("梦丝女神");
        titles.add("妖精视觉");
        titles.add("其她");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GkdGifFragment.newInstance(Net.GKDGIF_SCYT));
        fragments.add(GkdGifFragment.newInstance(Net.GKDGIF_SNYH));
        fragments.add(GkdGifFragment.newInstance(Net.GKDGIF_TZSN));
        fragments.add(GkdGifFragment.newInstance(Net.GKDGIF_MSNS));
        fragments.add(GkdGifFragment.newInstance(Net.GKDGIF_YJSJ));
        fragments.add(GkdGifFragment.newInstance(Net.GKDGIF_qt));
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

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_GKDGIF_ID;
    }
}
