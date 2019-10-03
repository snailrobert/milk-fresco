package f.star.iota.milk.ui.nvshens.shen;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.ScrollImageFragment;


public class ShenFragment extends ScrollImageFragment<ShenPresenter, ShenAdapter> {


    public static ShenFragment newInstance(String url) {
        ShenFragment fragment = new ShenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url",url+"?p=");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ShenPresenter getPresenter() {
        return new ShenPresenter(this);
    }

    @Override
    protected ShenAdapter getAdapter() {
        return new ShenAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_NVSHENS_TAG_ID;
    }
}
