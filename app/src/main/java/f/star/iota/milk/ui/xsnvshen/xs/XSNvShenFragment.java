package f.star.iota.milk.ui.xsnvshen.xs;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.MoreScrollImageFragment;


public class XSNvShenFragment extends MoreScrollImageFragment<XSNvShenPresenter, XSNvShenAdapter> {


    public static XSNvShenFragment newInstance(String url) {
        XSNvShenFragment fragment = new XSNvShenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url",url+"?p=");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected XSNvShenPresenter getPresenter() {
        return new XSNvShenPresenter(this);
    }

    @Override
    protected XSNvShenAdapter getAdapter() {
        return new XSNvShenAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_XSNVSHEN_MEINV_ID;
    }
}
