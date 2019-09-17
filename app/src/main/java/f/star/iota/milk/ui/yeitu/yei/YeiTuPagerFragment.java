package f.star.iota.milk.ui.yeitu.yei;

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


public class YeiTuPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("性感美女");
        titles.add("丝袜美腿");
        titles.add("唯美写真");
        titles.add("性感车模");
        titles.add("网络美女");
        titles.add("体育美女");
        titles.add("人体艺术");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_XINGGAN));
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_SIWAMEITUI));
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_WEIMEI));
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_CHEMO));
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_WANGLUOMEINV));
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_TIYUMEINV));
        fragments.add(YeiTuFragment.newInstance(Net.YEITU_RENTIYISHU));
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
