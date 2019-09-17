package f.star.iota.milk.ui.ituba.itu;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class ITuBaFragment extends ScrollImageFragment<ITuBaPresenter, ITuBaAdapter> {


    public static ITuBaFragment newInstance(String url) {
        ITuBaFragment fragment = new ITuBaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ITuBaPresenter getPresenter() {
        return new ITuBaPresenter(this);
    }

    @Override
    protected ITuBaAdapter getAdapter() {
        return new ITuBaAdapter();
    }
}
