package f.star.iota.milk.ui.jdlingyu.jd;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class JDLINGYUPresenter extends StringPresenter<List<JDLINGYUBean>> {

    public JDLINGYUPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("/page/1/")) {
            url = url.replace("page/1/", "");
        }
        return url;
    }

    @Override
    protected List<JDLINGYUBean> dealResponse(String s, HashMap<String, String> headers) {
        List<JDLINGYUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#main > div.grid-bor > div");
        // Elements select = Jsoup.parse(s).select("#postlist > div.pin");
        for (Element element : select) {
            JDLINGYUBean bean = new JDLINGYUBean();
            String preview = element.select("div.pos-r.cart-list > div.thumb.pos-r > div.preview.thumb-in").attr("style");
            // String preview = element.select("div.pin-coat > a > img").attr("original");
            // if (preview == null || preview.length() < 5) {
            //     preview = element.select("div.pin-coat > a > img").attr("src");
            // }
            preview = preview.substring(preview.indexOf("(")+2,preview.indexOf(")")-1);
            bean.setPreview(preview);
            String description = element.select("div.pos-r.cart-list > div.post-info > h2.entry-title > a").text();
            // String description = element.select("div.pin-coat > a > img").attr("alt");
            bean.setDescription(description);
            String url = element.select("div.pos-r.cart-list > div.post-info > h2.entry-title > a").attr("href");
            // String url = element.select("div.pin-coat > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String date = element.select("div.pos-r.cart-list > div.post-info > div.post-header > span.gray > time").attr("data-timeago");
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
