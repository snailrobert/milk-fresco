package f.star.iota.milk.ui.woaimeizi.woai;


import android.os.Bundle;

import f.star.iota.milk.base.ScrollImageFragment;


public class WoAiMeiZiFragment extends ScrollImageFragment<WoAiMeiZiPresenter, WoAiMeiZiAdapter> {


    public static WoAiMeiZiFragment newInstance(String url) {
        WoAiMeiZiFragment fragment = new WoAiMeiZiFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url +"/page_");
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WoAiMeiZiPresenter getPresenter() {
        return new WoAiMeiZiPresenter(this);
    }

    @Override
    protected WoAiMeiZiAdapter getAdapter() {
        return new WoAiMeiZiAdapter();
    }
}
