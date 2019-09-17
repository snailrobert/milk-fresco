package f.star.iota.milk.ui.bilibili;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;
import f.star.iota.milk.util.MessageBar;


public class BilibiliPagerFragment extends PagerFragment {

    public static final int ILLUST = 1;
    public static final int COS = 2;

    public static BilibiliPagerFragment newInstance(int type) {
        BilibiliPagerFragment fragment = new BilibiliPagerFragment();
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
        if (type == ILLUST) {
            titles.add("最热");
            titles.add("最新");
            fragments.add(BilibiliFragment.newInstance(Net.BILIBILI_HOT_ILLUST));
            fragments.add(BilibiliFragment.newInstance(Net.BILIBILI_NEW_ILLUST));
        } else if (type == COS) {
            titles.add("COS最热");
            titles.add("COS最新");
            titles.add("私服最热");
            titles.add("私服最新");
            fragments.add(BilibiliFragment.newInstance(Net.BILIBILI_HOT_COSPLAY));
            fragments.add(BilibiliFragment.newInstance(Net.BILIBILI_NEW_COSPLAY));
            fragments.add(BilibiliFragment.newInstance(Net.BILIBILI_HOT_COSSIFU));
            fragments.add(BilibiliFragment.newInstance(Net.BILIBILI_NEW_COSSIFU));
        } else {
            MessageBar.create(mContext, "获取数据错误，请稍候重试");
        }

        return new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
    }

    @Override
    protected int setTabMode() {
        return TabLayout.MODE_FIXED;
    }
}
