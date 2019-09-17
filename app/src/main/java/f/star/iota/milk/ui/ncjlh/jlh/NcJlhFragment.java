package f.star.iota.milk.ui.ncjlh.jlh;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class NcJlhFragment extends MoreScrollImageFragment<NcJlhPresenter, NcJlhAdapter> {


    public static NcJlhFragment newInstance(String url) {
        NcJlhFragment fragment = new NcJlhFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected NcJlhPresenter getPresenter() {
        return new NcJlhPresenter(this);
    }

    @Override
    protected NcJlhAdapter getAdapter() {
        return new NcJlhAdapter();
    }
}
