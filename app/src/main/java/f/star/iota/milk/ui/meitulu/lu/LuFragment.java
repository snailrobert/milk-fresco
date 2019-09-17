package f.star.iota.milk.ui.meitulu.lu;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class LuFragment extends ScrollImageFragment<LuPresenter, LuAdapter> {

    public static LuFragment newInstance(String url) {
        LuFragment fragment = new LuFragment();
        Bundle bundle = new Bundle();
        url = url.replace(".html", "_");
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected LuPresenter getPresenter() {
        return new LuPresenter(this);
    }

    @Override
    protected LuAdapter getAdapter() {
        return new LuAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
