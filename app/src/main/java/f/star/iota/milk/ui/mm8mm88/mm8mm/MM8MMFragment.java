package f.star.iota.milk.ui.mm8mm88.mm8mm;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class MM8MMFragment extends MoreScrollImageFragment<MM8MMPresenter, MM8MMAdapter> {


    public static MM8MMFragment newInstance(String url) {
        MM8MMFragment fragment = new MM8MMFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url + "list-");
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MM8MMPresenter getPresenter() {
        return new MM8MMPresenter(this);
    }

    @Override
    protected MM8MMAdapter getAdapter() {
        return new MM8MMAdapter();
    }
}
