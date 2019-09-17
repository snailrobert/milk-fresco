package f.star.iota.milk.ui.mmcools.mm;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class MmFragment extends ScrollImageFragment<MmPresenter, MmAdapter> {

    public static MmFragment newInstance(String url) {
        MmFragment fragment = new MmFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url.replace("_1.html","_"));
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MmPresenter getPresenter() {
        return new MmPresenter(this);
    }

    @Override
    protected MmAdapter getAdapter() {
        return new MmAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
