package f.star.iota.milk.ui.jdlingyu.lingyu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class LYPresenter extends StringPresenter<List<LYBean>> {

    public LYPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected String dealUrl(String url) {
        if (url.contains(".html/1/")) {
            url = url.replace(".html/1/", ".html");
        }
        return url;
    }

    @Override
    protected List<LYBean> dealResponse(String s, HashMap<String, String> headers) {
        List<LYBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#content-innerText > p > img");
        // Elements select = Jsoup.parse(s).select("#single > div.main > div > div.post.image > div.main-body > p > a");
        for (Element element : select) {
            LYBean bean = new LYBean();
            String url = element.attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }
}
