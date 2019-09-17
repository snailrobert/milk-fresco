package f.star.iota.milk.ui.acg17.a;


import android.os.Bundle;

import f.star.iota.milk.base.FixedImageFragment;


public class ACGFragment extends FixedImageFragment<ACGPresenter, ACGAdapter> {

    public static ACGFragment newInstance(String url) {
        ACGFragment fragment = new ACGFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ACGPresenter getPresenter() {
        return new ACGPresenter(this);
    }

    @Override
    protected ACGAdapter getAdapter() {
        return new ACGAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
