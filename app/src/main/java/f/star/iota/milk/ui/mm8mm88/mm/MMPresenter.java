package f.star.iota.milk.ui.mm8mm88.mm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class MMPresenter extends StringPresenter<List<MMBean>> {

    public MMPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MMBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MMBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#yt_boxl_mm8mm88 > div.wb_showpic_box > div.wb_showpic_main > img");
        for (Element element : select) {
            MMBean bean = new MMBean();
            String url = element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
