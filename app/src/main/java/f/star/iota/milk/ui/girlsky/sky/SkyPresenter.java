package f.star.iota.milk.ui.girlsky.sky;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class SkyPresenter extends StringPresenter<List<SkyBean>> {
    public SkyPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<SkyBean> dealResponse(String s, HashMap<String, String> headers) {
        List<SkyBean> list = new ArrayList<>();

        Element element = Jsoup.parse(s).select("#ArticleId8 > div:nth-child(1) > a > img").first();
        SkyBean bean = new SkyBean();
        String url = element.attr("src");
        if(!url.contains("http")){
            url = "http:" + url;
        }
        bean.setUrl(url);
        bean.setHeaders(headers);
        list.add(bean);
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.html")) {
            url = url.replace("_1.html", ".html");
        }
        return super.dealUrl(url);
    }
}
