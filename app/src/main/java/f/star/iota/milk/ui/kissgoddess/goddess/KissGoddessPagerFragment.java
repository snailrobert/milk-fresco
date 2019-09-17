package f.star.iota.milk.ui.kissgoddess.goddess;


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


public class KissGoddessPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        String s = ReadResourceUtil.readResource(R.raw.goddess);
        Elements selects = Jsoup.parseBodyFragment(s).select("div > ul");
        for(Element ul : selects){
            Elements li = ul.select("li");
            for(int i= 0;i<li.size();i++){
                String url = Net.GODDESS_BASE + li.get(i).select("a").attr("href");
                String tagName = li.get(i).select("a").text();
                titles.add(tagName);
                fragments.add(KissGoddessFragment.newInstance(url));
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
