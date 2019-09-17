package f.star.iota.milk.ui.zu80.zu;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class ZU80Fragment extends MoreScrollImageFragment<ZU80Presenter, ZU80Adapter> {


    public static ZU80Fragment newInstance(String url) {
        ZU80Fragment fragment = new ZU80Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url + "/page/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ZU80Presenter getPresenter() {
        return new ZU80Presenter(this);
    }

    @Override
    protected ZU80Adapter getAdapter() {
        return new ZU80Adapter();
    }
}
