package f.star.iota.milk.ui.zu80.www;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class ZUFragment extends ScrollImageFragment<ZUPresenter, ZUAdapter> {

    public static ZUFragment newInstance(String url) {
        ZUFragment fragment = new ZUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url+"/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ZUPresenter getPresenter() {
        return new ZUPresenter(this);
    }

    @Override
    protected ZUAdapter getAdapter() {
        return new ZUAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
