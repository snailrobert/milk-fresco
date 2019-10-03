package f.star.iota.milk.ui.itmtu.mtu;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class MtuFragment extends ScrollImageFragment<MtuPresenter, MtuAdapter> {

    public static MtuFragment newInstance(String url) {
        MtuFragment fragment = new MtuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MtuPresenter getPresenter() {
        return new MtuPresenter(this);
    }

    @Override
    protected MtuAdapter getAdapter() {
        return new MtuAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
