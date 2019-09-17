package f.star.iota.milk.ui.ncjlh.jlh;


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


public class NcJlhPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        String s = ReadResourceUtil.readResource(R.raw.ncjlh);
        Elements selects = Jsoup.parseBodyFragment(s).select("div > a");
        for(Element element : selects){
            String url = Net.NCJLH_BASE + element.attr("href");
            url = url.replace(".html","-150-");
            String tagName = element.text();
            titles.add(tagName);
            fragments.add(NcJlhFragment.newInstance(url));
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
