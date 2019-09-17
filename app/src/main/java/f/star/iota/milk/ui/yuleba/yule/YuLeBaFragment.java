package f.star.iota.milk.ui.yuleba.yule;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class YuLeBaFragment extends ScrollImageFragment<YuLeBaPresenter, YuLeBaAdapter> {


    public static YuLeBaFragment newInstance(String url) {
        YuLeBaFragment fragment = new YuLeBaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putInt("initial_page",0);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected YuLeBaPresenter getPresenter() {
        return new YuLeBaPresenter(this);
    }

    @Override
    protected YuLeBaAdapter getAdapter() {
        return new YuLeBaAdapter();
    }
}
