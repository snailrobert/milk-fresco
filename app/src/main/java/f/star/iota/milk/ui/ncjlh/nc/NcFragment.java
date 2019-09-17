package f.star.iota.milk.ui.ncjlh.nc;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class NcFragment extends ScrollImageFragment<NcPresenter, NcAdapter> {

    public static NcFragment newInstance(String url) {
        NcFragment fragment = new NcFragment();
        Bundle bundle = new Bundle();
        url = url.replace("1.html", "");
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected NcPresenter getPresenter() {
        return new NcPresenter(this);
    }

    @Override
    protected NcAdapter getAdapter() {
        return new NcAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
