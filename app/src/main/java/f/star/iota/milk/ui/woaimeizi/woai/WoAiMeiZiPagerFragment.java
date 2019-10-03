package f.star.iota.milk.ui.woaimeizi.woai;

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


public class WoAiMeiZiPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("全图");
        titles.add("妹子图");
        titles.add("清纯妹子");
        titles.add("二次元");
        titles.add("诱惑");
        titles.add("腿控");
        titles.add("萝莉");
        titles.add("私房");
        titles.add("cosplay");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_BASE));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_SEXY));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_PURE));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_ANIME));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_TEMPT));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_LEG));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_LOLITA));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_SIFANG));
        fragments.add(WoAiMeiZiFragment.newInstance(Net.WOAIMEIZI_COSPLAY));
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
