package f.star.iota.milk.ui.www52guzhuang.guzhuang;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class GuZhuangFragment extends MoreScrollImageFragment<GuZhuangPresenter, GuZhuangAdapter> {


    public static GuZhuangFragment newInstance(String url) {
        GuZhuangFragment fragment = new GuZhuangFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix", ".html");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected GuZhuangPresenter getPresenter() {
        return new GuZhuangPresenter(this);
    }

    @Override
    protected GuZhuangAdapter getAdapter() {
        return new GuZhuangAdapter();
    }
}
