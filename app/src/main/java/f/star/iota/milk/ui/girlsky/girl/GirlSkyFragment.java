package f.star.iota.milk.ui.girlsky.girl;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.ScrollImageFragment;


public class GirlSkyFragment extends ScrollImageFragment<GirlSkyPresenter, GirlSkyAdapter> {


    public static GirlSkyFragment newInstance(String url) {
        GirlSkyFragment fragment = new GirlSkyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GirlSkyPresenter getPresenter() {
        return new GirlSkyPresenter(this);
    }

    @Override
    protected GirlSkyAdapter getAdapter() {
        return new GirlSkyAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_GIRLSKY_ID;
    }
}
