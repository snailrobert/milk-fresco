package f.star.iota.milk.ui.mmcools.cools;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class MMCOOLSFragment extends ScrollImageFragment<MMCOOLSPresenter, MMCOOLSAdapter> {


    public static MMCOOLSFragment newInstance(String url) {
        MMCOOLSFragment fragment = new MMCOOLSFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MMCOOLSPresenter getPresenter() {
        return new MMCOOLSPresenter(this);
    }

    @Override
    protected MMCOOLSAdapter getAdapter() {
        return new MMCOOLSAdapter();
    }
}
