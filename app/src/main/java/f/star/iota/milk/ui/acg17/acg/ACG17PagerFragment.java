package f.star.iota.milk.ui.acg17.acg;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PagerFragment;
import f.star.iota.milk.base.TitlePagerAdapter;
import f.star.iota.milk.util.MessageBar;


public class ACG17PagerFragment extends PagerFragment {

    public static final int ILLUST = 1;
    public static final int COS = 2;

    public static ACG17PagerFragment newInstance(int type) {
        ACG17PagerFragment fragment = new ACG17PagerFragment();
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
            titles.add("P站画师");
            titles.add("P站美图");
            titles.add("图包画集");
            fragments.add(ACG17Fragment.newInstance(Net.ACG17_PT));
            fragments.add(ACG17Fragment.newInstance(Net.ACG17_WP));
            fragments.add(ACG17Fragment.newInstance(Net.ACG17_TB));
        } else if (type == COS) {
            titles.add("COSPLAY");
            fragments.add(ACG17Fragment.newInstance(Net.ACG17_COS));
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
