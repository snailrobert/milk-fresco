package f.star.iota.milk.ui.mmjpg.jpg;


import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class JpgPresenter extends StringPresenter<List<JpgBean>> {
    public JpgPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<JpgBean> dealResponse(String s, HashMap<String, String> headers) {
        List<JpgBean> list = new ArrayList<>();
        String url = Jsoup.parse(s).select("#content > img").attr("src");
        JpgBean bean = new JpgBean();
        bean.setHeaders(headers);
        bean.setUrl(url);
        list.add(bean);
        return list;
    }

}
