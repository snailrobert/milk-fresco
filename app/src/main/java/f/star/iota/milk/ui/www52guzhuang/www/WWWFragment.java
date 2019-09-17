package f.star.iota.milk.ui.www52guzhuang.www;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class WWWFragment extends ScrollImageFragment<WWWPresenter, WWWAdapter> {

    public static WWWFragment newInstance(String url) {
        WWWFragment fragment = new WWWFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url.replace("1-1.html", ""));
        bundle.putString("page_suffix", "-1.html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WWWPresenter getPresenter() {
        return new WWWPresenter(this);
    }

    @Override
    protected WWWAdapter getAdapter() {
        return new WWWAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
