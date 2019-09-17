package f.star.iota.milk.ui.meitulu.meitu;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class MeiTuFragment extends MoreScrollImageFragment<MeiTuPresenter, MeiTuAdapter> {


    public static MeiTuFragment newInstance(String url) {
        MeiTuFragment fragment = new MeiTuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MeiTuPresenter getPresenter() {
        return new MeiTuPresenter(this);
    }

    @Override
    protected MeiTuAdapter getAdapter() {
        return new MeiTuAdapter();
    }
}
