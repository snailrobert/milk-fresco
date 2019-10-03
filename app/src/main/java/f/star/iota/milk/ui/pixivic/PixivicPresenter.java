package f.star.iota.milk.ui.pixivic;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class PixivicPresenter extends StringPresenter<List<PixivicBean.ResultsBean>> {

    public PixivicPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<PixivicBean.ResultsBean> dealResponse(String s, HashMap<String, String> headers) {
        return new Gson().fromJson(s, PixivicBean.class).getResults();
    }
}
