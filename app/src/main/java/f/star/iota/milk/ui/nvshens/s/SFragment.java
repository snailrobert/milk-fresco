package f.star.iota.milk.ui.nvshens.s;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.ScrollImageFragment;


public class SFragment extends ScrollImageFragment<SPresenter, SAdapter> {

    public static SFragment newInstance(String url) {
        SFragment fragment = new SFragment();
        Bundle bundle = new Bundle();;
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected SPresenter getPresenter() {
        return new SPresenter(this);
    }

    @Override
    protected SAdapter getAdapter() {
        return new SAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_NVSHENS_TAG_ID;
    }
}
