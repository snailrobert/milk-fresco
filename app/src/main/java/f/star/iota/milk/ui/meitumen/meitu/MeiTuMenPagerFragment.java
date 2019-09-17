package f.star.iota.milk.ui.meitumen.meitu;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import f.star.iota.milk.Net;
import f.star.iota.milk.R;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;
import f.star.iota.milk.util.ReadResourceUtil;


public class MeiTuMenPagerFragment extends PagerFragment {


    public static final int MENU = 1;
    public static final int TAG =  2;


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    public static MeiTuMenPagerFragment newInstance(int type) {
        MeiTuMenPagerFragment fragment = new MeiTuMenPagerFragment();
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
        if(type == MENU) {
            titles.add("性感美女");
            titles.add("清新唯美");
            titles.add("动态图库");
            fragments.add(MeiTuMenFragment.newInstance(Net.MEITUMEN_MEINV));
            fragments.add(MeiTuMenFragment.newInstance(Net.MEITUMEN_WEIMEI));
            fragments.add(MeiTuMenFragment.newInstance(Net.MEITUMEN_GIF));
        }else if(type == TAG){
            String s = ReadResourceUtil.readResource(R.raw.meitumen);
            Elements selects = Jsoup.parseBodyFragment(s).select("div > ul > a");
            for(Element element : selects){
                    String url = element.select("a").attr("href");
                    String tagName = element.select("a").text();
                    titles.add(tagName);
                    fragments.add(MeiTuMenFragment.newInstance(url));
            }
        }
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
