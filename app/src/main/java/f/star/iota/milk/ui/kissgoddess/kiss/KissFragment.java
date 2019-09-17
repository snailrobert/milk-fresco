package f.star.iota.milk.ui.kissgoddess.kiss;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class KissFragment extends ScrollImageFragment<KissPresenter, KissAdapter> {

    public static KissFragment newInstance(String url) {
        KissFragment fragment = new KissFragment();
        Bundle bundle = new Bundle();
        url = url.replace(".html", "_");
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected KissPresenter getPresenter() {
        return new KissPresenter(this);
    }

    @Override
    protected KissAdapter getAdapter() {
        return new KissAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
