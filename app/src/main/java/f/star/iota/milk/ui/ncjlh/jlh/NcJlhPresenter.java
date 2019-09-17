package f.star.iota.milk.ui.ncjlh.jlh;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class NcJlhPresenter extends StringPresenter<List<NcJlhBean>> {

    public NcJlhPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<NcJlhBean> dealResponse(String s, HashMap<String, String> headers) {
        List<NcJlhBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#body > div > ul.post_list > li");
        for (Element element : select) {
            NcJlhBean bean = new NcJlhBean();
            String preview = element.select("div.main > a > img").attr("src");
            bean.setPreview(Net.NCJLH_BASE + preview);
            String url = element.select("div.main > a").attr("href");
            bean.setUrl(Net.NCJLH_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("div.main > a").attr("title");
            bean.setDescription(description);
            String date = element.select("div.main > a > div.status_bar > span.item.date").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
