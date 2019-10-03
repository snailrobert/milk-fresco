package f.star.iota.milk.ui.threeycy.three;


import android.os.Bundle;

import f.star.iota.milk.base.FixedImageFragment;


public class ThreeFragment extends FixedImageFragment<ThreePresenter, ThreeAdapter> {

    public static ThreeFragment newInstance(String url) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ThreePresenter getPresenter() {
        return new ThreePresenter(this);
    }

    @Override
    protected ThreeAdapter getAdapter() {
        return new ThreeAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
