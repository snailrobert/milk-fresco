package f.star.iota.milk.ui.meinvyh.mzi;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class MeiNvFragment extends ScrollImageFragment<MeiNvPresenter, MeiNvAdapter> {


    public static MeiNvFragment newInstance(String url) {
        MeiNvFragment fragment = new MeiNvFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MeiNvPresenter getPresenter() {
        return new MeiNvPresenter(this);
    }

    @Override
    protected MeiNvAdapter getAdapter() {
        return new MeiNvAdapter();
    }

}
