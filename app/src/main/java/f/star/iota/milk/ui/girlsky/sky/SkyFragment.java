package f.star.iota.milk.ui.girlsky.sky;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class SkyFragment extends ScrollImageFragment<SkyPresenter, SkyAdapter> {

    public static SkyFragment newInstance(String url) {
        SkyFragment fragment = new SkyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url.replace(".html", "_"));
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected SkyPresenter getPresenter() {
        return new SkyPresenter(this);
    }

    @Override
    protected SkyAdapter getAdapter() {
        return new SkyAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
