package f.star.iota.milk.ui.xsnvshen.xs;


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


public class XSNvShenPagerFragment extends PagerFragment {


    public static final int MEINV = 1;
    public static final int NVSHEN =  2;
    public static final int HDTU =  3;


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    public static XSNvShenPagerFragment newInstance(int type) {
        XSNvShenPagerFragment fragment = new XSNvShenPagerFragment();
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
        if(type == MEINV) {
            String s = ReadResourceUtil.readResource(R.raw.xsnvshen1);
            Elements selects = Jsoup.parseBodyFragment(s).select("div > div.sort-item-box");
            for(Element div : selects){
                Elements a = div.select("div > a");
                for(int i= 0;i<a.size();i++){
                    String url = Net.XSNVSHEN_BASE + a.get(i).select("a").attr("href");
                    String tagName = a.get(i).select("a").attr("title");
                    titles.add(tagName);
                    fragments.add(XSNvShenFragment.newInstance(url));
                }
            }
        }else if(type == NVSHEN){
            String s = ReadResourceUtil.readResource(R.raw.xsnvshen2);
            Elements selects = Jsoup.parseBodyFragment(s).select("div > div.sort-item-box");
            for(Element div : selects){
                Elements a = div.select("div > a");
                for(int i= 0;i<a.size();i++){
                    String url = Net.XSNVSHEN_BASE + a.get(i).select("a").attr("href");
                    String tagName = a.get(i).select("a").attr("title");
                    titles.add(tagName);
                    fragments.add(XSNvShenFragment.newInstance(url));
                }
            }
        }else if(type == HDTU){
            String s = ReadResourceUtil.readBufferResource(R.raw.xsnvshen3);
            Elements selects = Jsoup.parseBodyFragment(s).select("a");
            for(Element element : selects){
                String url = Net.XSNVSHEN_BASE + element.attr("href");
                String tagName = element.select("span").text();
                titles.add(tagName);
                fragments.add(XSNvShenFragment.newInstance(url));
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
