package f.star.iota.milk.ui.bcy.ing;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class IngFragment extends IngFixedImageFragment<IngPresenter, IngAdapter> {

    public static IngFragment newInstance(List<String> imgs) {
        IngFragment fragment = new IngFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("imgs",(ArrayList<String>) imgs);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected IngPresenter getPresenter() {
        return new IngPresenter(this);
    }

    @Override
    protected IngAdapter getAdapter() {
        return new IngAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }
}
