package f.star.iota.milk.ui.isaob.isao;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.MoreScrollImageFragment;


public class ISaoFragment extends MoreScrollImageFragment<ISaoPresenter, ISaoAdapter> {


    public static ISaoFragment newInstance(String url) {
        ISaoFragment fragment = new ISaoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url+"/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ISaoPresenter getPresenter() {
        return new ISaoPresenter(this);
    }

    @Override
    protected ISaoAdapter getAdapter() {
        return new ISaoAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_ISAOB_ID;
    }

}
