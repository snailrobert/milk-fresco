package f.star.iota.milk.ui.isaob.isao;


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
import f.star.iota.milk.R;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;
import f.star.iota.milk.util.ReadResourceUtil;


public class ISaoPagerFragment extends PagerFragment {


    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    @Override
    protected TitlePagerAdapter getPagerAdapter() {
        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        String s = ReadResourceUtil.readBufferResource(R.raw.isaob);
        Elements selects = Jsoup.parseBodyFragment(s).select("a");
        for(Element a : selects){
            String url = a.attr("href");
            String tagName = a.select("a").text();
            titles.add(tagName);
            fragments.add(ISaoFragment.newInstance(url));

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
        return Menus.MENU_ISAOB_ID;
    }
}
