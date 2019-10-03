package f.star.iota.milk.ui.itmtu.it;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.MoreScrollImageFragment;


public class ItMtuFragment extends MoreScrollImageFragment<ItMtuPresenter, ItMtuAdapter> {


    public static ItMtuFragment newInstance(String url) {
        ItMtuFragment fragment = new ItMtuFragment();
        Bundle bundle = new Bundle();
        if(url.contains(".html")){
            url = url.replace(".html", "/");
        }
        bundle.putString("base_url", url+"page_");
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ItMtuPresenter getPresenter() {
        return new ItMtuPresenter(this);
    }

    @Override
    protected ItMtuAdapter getAdapter() {
        return new ItMtuAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_ITMTU_ID;
    }

}
