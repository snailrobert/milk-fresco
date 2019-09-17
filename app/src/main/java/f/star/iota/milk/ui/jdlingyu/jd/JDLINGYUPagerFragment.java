package f.star.iota.milk.ui.jdlingyu.jd;

import android.os.Bundle;
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


public class JDLINGYUPagerFragment extends PagerFragment {


    public static final int ALL = 1;
    public static final int COS = 2;
    public static final int HENTAI_MZITU = 3;
    public static final int SIFANG_ZIPAI = 4;
    public static final int GCTT_RBXZ = 5;


    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    public static JDLINGYUPagerFragment newInstance(int type) {
        JDLINGYUPagerFragment fragment = new JDLINGYUPagerFragment();
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
        if (type == ALL) {
            titles.add("图集");
            titles.add("特点");
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_ALL));
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_TRAIT));
        } else if (type == COS) {
            titles.add("COS");
            titles.add("COS套图");
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_COSTT));
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_COS));
        } else if (type == HENTAI_MZITU) {
            titles.add("绅士好物");
            titles.add("妹子图");
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_HENTAI));
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_MZITU));
        } else if (type == SIFANG_ZIPAI) {
            titles.add("私房");
            titles.add("自拍");
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_SIFANG));
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_ZIPAI));
        } else if (type == GCTT_RBXZ) {
            titles.add("国产套图");
            titles.add("日本写真");
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_GCTT));
            fragments.add(JDLINGYUFragment.newInstance(Net.JDLINGYU_RBXZ));
        }

        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }

    @Override
    protected void init() {
        super.init();
        mViewPager.setOffscreenPageLimit(0);
    }
}
