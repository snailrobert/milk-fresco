package f.star.iota.milk.ui.pixivic;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.ScrollImageFragment;

public class PixivicFragment extends ScrollImageFragment<PixivicPresenter, PixivicAdapter> {


    public static PixivicFragment newInstance(String url) {
        PixivicFragment fragment = new PixivicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected PixivicPresenter getPresenter() {
        return new PixivicPresenter(this);
    }

    @Override
    protected PixivicAdapter getAdapter() {
        return new PixivicAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_PIXIVIC_ID;
    }
}
