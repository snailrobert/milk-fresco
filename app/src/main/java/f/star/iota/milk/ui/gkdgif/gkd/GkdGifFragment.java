package f.star.iota.milk.ui.gkdgif.gkd;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.MoreScrollImageFragment;


public class GkdGifFragment extends MoreScrollImageFragment<GkdGifPresenter, GkdGifAdapter> {


    public static GkdGifFragment newInstance(String url) {
        GkdGifFragment fragment = new GkdGifFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url + "/page/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GkdGifPresenter getPresenter() {
        return new GkdGifPresenter(this);
    }

    @Override
    protected GkdGifAdapter getAdapter() {
        return new GkdGifAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_GKDGIF_ID;
    }
}
