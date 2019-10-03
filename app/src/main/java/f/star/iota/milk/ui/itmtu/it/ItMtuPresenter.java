package f.star.iota.milk.ui.itmtu.it;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ItMtuPresenter extends StringPresenter<List<ItMtuBean>> {

    public ItMtuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ItMtuBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ItMtuBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#index_ajax_list > li");
        for (Element element : select) {
            ItMtuBean bean = new ItMtuBean();
            String preview = element.select("a > img").attr("data-original");
            bean.setPreview(preview);
            String url = element.select("a").attr("href");
            bean.setUrl(Net.ITMTU_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("a > img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }

}
