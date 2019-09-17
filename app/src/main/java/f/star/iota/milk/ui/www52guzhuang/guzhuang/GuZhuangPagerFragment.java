package f.star.iota.milk.ui.www52guzhuang.guzhuang;

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


public class GuZhuangPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        titles.add("古装美女");
        titles.add("汉服美女");
        titles.add("清纯系");
        titles.add("COSPLAY");
        titles.add("婚纱美女");
        titles.add("儿童美女");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GuZhuangFragment.newInstance(Net.WWW52GUZHUANG_GZMV));
        fragments.add(GuZhuangFragment.newInstance(Net.WWW52GUZHUANG_HFMV));
        fragments.add(GuZhuangFragment.newInstance(Net.WWW52GUZHUANG_QCMV));
        fragments.add(GuZhuangFragment.newInstance(Net.WWW52GUZHUANG_COSPLAY));
        fragments.add(GuZhuangFragment.newInstance(Net.WWW52GUZHUANG_HSMV));
        fragments.add(GuZhuangFragment.newInstance(Net.WWW52GUZHUANG_ETMV));
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
