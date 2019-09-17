package f.star.iota.milk.ui.rosimm.rosi;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class ROSIMMFFragment extends MoreScrollImageFragment<ROSIMMPPresenter, ROSIMMAdapter> {


    public static ROSIMMFFragment newInstance(String url) {
        ROSIMMFFragment fragment = new ROSIMMFFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ROSIMMPPresenter getPresenter() {
        return new ROSIMMPPresenter(this);
    }

    @Override
    protected ROSIMMAdapter getAdapter() {
        return new ROSIMMAdapter();
    }
}
