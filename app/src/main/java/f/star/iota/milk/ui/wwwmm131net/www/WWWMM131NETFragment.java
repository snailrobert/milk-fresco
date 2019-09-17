package f.star.iota.milk.ui.wwwmm131net.www;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class WWWMM131NETFragment extends ScrollImageFragment<WWWMM131NETPresenter, WWWMM131NETAdapter> {


    public static WWWMM131NETFragment newInstance(String url) {
        WWWMM131NETFragment fragment = new WWWMM131NETFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WWWMM131NETPresenter getPresenter() {
        return new WWWMM131NETPresenter(this);
    }

    @Override
    protected WWWMM131NETAdapter getAdapter() {
        return new WWWMM131NETAdapter();
    }
}
