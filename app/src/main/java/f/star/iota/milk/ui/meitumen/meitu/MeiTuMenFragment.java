package f.star.iota.milk.ui.meitumen.meitu;


import android.os.Bundle;

import f.star.iota.milk.base.MoreScrollImageFragment;


public class MeiTuMenFragment extends MoreScrollImageFragment<MeiTuMenPresenter, MeiTuMenAdapter> {


    public static MeiTuMenFragment newInstance(String url) {
        MeiTuMenFragment fragment = new MeiTuMenFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url",url+"/page/");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MeiTuMenPresenter getPresenter() {
        return new MeiTuMenPresenter(this);
    }

    @Override
    protected MeiTuMenAdapter getAdapter() {
        return new MeiTuMenAdapter();
    }
}
