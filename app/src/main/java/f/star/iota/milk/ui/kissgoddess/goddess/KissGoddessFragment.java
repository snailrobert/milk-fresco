package f.star.iota.milk.ui.kissgoddess.goddess;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class KissGoddessFragment extends MoreScrollImageFragment<KissGoddessPresenter, KissGoddessAdapter> {


    public static KissGoddessFragment newInstance(String url) {
        KissGoddessFragment fragment = new KissGoddessFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected KissGoddessPresenter getPresenter() {
        return new KissGoddessPresenter(this);
    }

    @Override
    protected KissGoddessAdapter getAdapter() {
        return new KissGoddessAdapter();
    }
}
