package f.star.iota.milk.ui.yeitu.yei;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class YeiTuFragment extends ScrollImageFragment<YeiTuPresenter, YeiTuAdapter> {


    public static YeiTuFragment newInstance(String url) {
        YeiTuFragment fragment = new YeiTuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected YeiTuPresenter getPresenter() {
        return new YeiTuPresenter(this);
    }

    @Override
    protected YeiTuAdapter getAdapter() {
        return new YeiTuAdapter();
    }
}
