package f.star.iota.milk.ui.rosimm.rosi;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class ROSIMMFragment extends MoreScrollImageFragment<ROSIMMPresenter, ROSIMMAdapter> {


    public static ROSIMMFragment newInstance(String url) {
        ROSIMMFragment fragment = new ROSIMMFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ROSIMMPresenter getPresenter() {
        return new ROSIMMPresenter(this);
    }

    @Override
    protected ROSIMMAdapter getAdapter() {
        return new ROSIMMAdapter();
    }
}
