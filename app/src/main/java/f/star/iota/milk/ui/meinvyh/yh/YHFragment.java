package f.star.iota.milk.ui.meinvyh.yh;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class YHFragment extends ScrollImageFragment<YHPresenter, YHAdapter> {

    public static YHFragment newInstance(String url) {
        YHFragment fragment = new YHFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url.replace("1-1.html",""));
        bundle.putString("page_suffix", "-1.html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected YHPresenter getPresenter() {
        return new YHPresenter(this);
    }

    @Override
    protected YHAdapter getAdapter() {
        return new YHAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
