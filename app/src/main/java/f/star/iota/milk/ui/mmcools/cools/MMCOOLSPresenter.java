package f.star.iota.milk.ui.mmcools.cools;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class MMCOOLSPresenter extends StringPresenter<List<MMCOOLSZiBean>> {


    public MMCOOLSPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MMCOOLSZiBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MMCOOLSZiBean> list = new ArrayList<>();
        Elements select = Jsoup.parseBodyFragment(s).select("li");
        for (Element element : select) {
            MMCOOLSZiBean bean = new MMCOOLSZiBean();
            String preview = element.select("a > img").attr("src");
            bean.setPreview(Net.MMCOOLS_BASE + preview);
            String url = element.select("a").attr("href");
            bean.setUrl(Net.MMCOOLS_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("a > img").attr("alt");
            bean.setDescription(description);
            String date = element.select("span:nth-child(3)").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }

}
