package f.star.iota.milk.ui.acg17.acg;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class ACG17Fragment extends ScrollImageFragment<ACG17Presenter, ACG17Adapter> {


    public static ACG17Fragment newInstance(String url) {
        ACG17Fragment fragment = new ACG17Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", "/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ACG17Presenter getPresenter() {
        return new ACG17Presenter(this);
    }

    @Override
    protected ACG17Adapter getAdapter() {
        return new ACG17Adapter();
    }
}
