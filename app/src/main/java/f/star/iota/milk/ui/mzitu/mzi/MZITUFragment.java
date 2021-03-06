package f.star.iota.milk.ui.mzitu.mzi;


import android.os.Bundle;

import f.star.iota.milk.Menus;
import f.star.iota.milk.base.ScrollImageFragment;


public class MZITUFragment extends ScrollImageFragment<MZITUPresenter, MZITUAdapter> {


    public static MZITUFragment newInstance(String url) {
        MZITUFragment fragment = new MZITUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MZITUPresenter getPresenter() {
        return new MZITUPresenter(this);
    }

    @Override
    protected MZITUAdapter getAdapter() {
        return new MZITUAdapter();
    }

    @Override
    public int getFragmentMenuID() {
        return Menus.MENU_MZITU_ID;
    }
}
