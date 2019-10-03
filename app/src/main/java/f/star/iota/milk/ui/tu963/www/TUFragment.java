package f.star.iota.milk.ui.tu963.www;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class TUFragment extends ScrollImageFragment<TUPresenter, TUAdapter> {

    public static TUFragment newInstance(String url) {
        TUFragment fragment = new TUFragment();
        Bundle bundle = new Bundle();
        url = url.replace(".html", "_");
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TUPresenter getPresenter() {
        return new TUPresenter(this);
    }

    @Override
    protected TUAdapter getAdapter() {
        return new TUAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
