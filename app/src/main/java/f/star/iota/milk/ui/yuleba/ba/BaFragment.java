package f.star.iota.milk.ui.yuleba.ba;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class BaFragment extends ScrollImageFragment<BaPresenter, BaAdapter> {

    public static BaFragment newInstance(String url) {
        BaFragment fragment = new BaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url.replace("0.html", ""));
        bundle.putInt("initial_page", 0);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BaPresenter getPresenter() {
        return new BaPresenter(this);
    }

    @Override
    protected BaAdapter getAdapter() {
        return new BaAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
