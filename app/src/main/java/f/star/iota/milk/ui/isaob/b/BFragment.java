package f.star.iota.milk.ui.isaob.b;


import android.os.Bundle;

import f.star.iota.milk.base.FixedImageFragment;


public class BFragment extends FixedImageFragment<BPresenter, BAdapter> {

    public static BFragment newInstance(String url) {
        BFragment fragment = new BFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BPresenter getPresenter() {
        return new BPresenter(this);
    }

    @Override
    protected BAdapter getAdapter() {
        return new BAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
