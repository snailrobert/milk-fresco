package f.star.iota.milk.ui.meitumen.men;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class MenFragment extends ScrollImageFragment<MenPresenter, MenAdapter> {

    public static MenFragment newInstance(String url) {
        MenFragment fragment = new MenFragment();
        Bundle bundle = new Bundle();;
        bundle.putString("base_url", url+"#!p=");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MenPresenter getPresenter() {
        return new MenPresenter(this);
    }

    @Override
    protected MenAdapter getAdapter() {
        return new MenAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
