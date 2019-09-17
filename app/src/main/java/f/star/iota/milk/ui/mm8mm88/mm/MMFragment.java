package f.star.iota.milk.ui.mm8mm88.mm;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class MMFragment extends ScrollImageFragment<MMPresenter, MMAdapter> {

    public static MMFragment newInstance(String url) {
        MMFragment fragment = new MMFragment();
        Bundle bundle = new Bundle();
        url = url.replace(".html", "-");
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MMPresenter getPresenter() {
        return new MMPresenter(this);
    }

    @Override
    protected MMAdapter getAdapter() {
        return new MMAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
