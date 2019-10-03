package f.star.iota.milk.ui.gkdgif.gif;


import android.os.Bundle;

import f.star.iota.milk.base.FixedImageFragment;


public class GifFragment extends FixedImageFragment<GifPresenter, GifAdapter> {

    public static GifFragment newInstance(String url) {
        GifFragment fragment = new GifFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GifPresenter getPresenter() {
        return new GifPresenter(this);
    }

    @Override
    protected GifAdapter getAdapter() {
        return new GifAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
