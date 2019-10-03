package f.star.iota.milk.ui.threeycy.ycy;


import android.os.Bundle;


public class ThreeYCYFragment extends ThreeYCYScrollImageFragment<ThreeYCYPresenter, ThreeYCYAdapter> {


    public static ThreeYCYFragment newInstance(String url) {
        ThreeYCYFragment fragment = new ThreeYCYFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ThreeYCYPresenter getPresenter() {
        return new ThreeYCYPresenter(this);
    }

    @Override
    protected ThreeYCYAdapter getAdapter() {
        return new ThreeYCYAdapter();
    }
}
