package f.star.iota.milk.ui.tu963.zu;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.MoreScrollImageFragment;


public class TU963Fragment extends MoreScrollImageFragment<TU963Presenter, TU963Adapter> {


    public static TU963Fragment newInstance(String url) {
        TU963Fragment fragment = new TU963Fragment();
        Bundle bundle = new Bundle();
        url = url.replace("_1.html", "_");
        bundle.putString("base_url", url);
        bundle.putString("page_suffix",".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TU963Presenter getPresenter() {
        return new TU963Presenter(this);
    }

    @Override
    protected TU963Adapter getAdapter() {
        return new TU963Adapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_TU963_ID;
    }

}
