package f.star.iota.milk.ui.bcy.ranking;


import android.os.Bundle;

import java.util.Date;

import f.star.iota.milk.util.DateUtils;


public class BCYRankingFragment extends BCYScrollImageFragment<BCYRankingPresenter, BCYRankingAdapter> {

    public static BCYRankingFragment newInstance(String url){
        BCYRankingFragment fragment = new BCYRankingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("base_url", url);
        bundle.putString("page_suffix","&date="+ DateUtils.dateFormat(new Date(), DateUtils.DATE_PATTERN_YYYYMMDD));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BCYRankingPresenter getPresenter() {
        return new BCYRankingPresenter(this);
    }

    @Override
    protected BCYRankingAdapter getAdapter() {
        return new BCYRankingAdapter();
    }

}
