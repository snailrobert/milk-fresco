package f.star.iota.milk.ui.nvshens.nv;


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
import f.star.iota.milk.Menus;
import f.star.iota.milk.Net;
import f.star.iota.milk.R;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;
import f.star.iota.milk.util.ReadResourceUtil;


public class NvShenPagerFragment extends PagerFragment {


    public static final int GALLERY = 1;
    public static final int TAG =  2;


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    public static NvShenPagerFragment newInstance(int type) {
        NvShenPagerFragment fragment = new NvShenPagerFragment();
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
        if(type == GALLERY) {
            String s = ReadResourceUtil.readBufferResource(R.raw.nvshens1);
            Elements selects = Jsoup.parseBodyFragment(s).select("div.tag_div");
            for(Element div : selects){
                Elements a = div.select("ul > li > a");
                for(int i= 0;i<a.size();i++){
                    String url = Net.NVSHENS_BASE + a.get(i).select("a").attr("href");
                    String tagName = a.get(i).select("a").text();
                    titles.add(tagName);
                    fragments.add(NvShenFragment.newInstance(url));
                }
            }
        }else if(type == TAG){
            String s = ReadResourceUtil.readBufferResource(R.raw.nvshens2);
            Elements selects = Jsoup.parseBodyFragment(s).select("div.tag_div");
            for(Element div : selects){
                Elements a = div.select("ul > li > a");
                for(int i= 0;i<a.size();i++){
                    String url = Net.NVSHENS_BASE + a.get(i).select("a").attr("href");
                    String tagName = a.get(i).select("a").text();
                    titles.add(tagName);
                    fragments.add(NvShenFragment.newInstance(url));
                }
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

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_NVSHENS_TAG_ID;
    }
}
