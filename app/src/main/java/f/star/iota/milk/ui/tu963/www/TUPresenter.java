package f.star.iota.milk.ui.tu963.www;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class TUPresenter extends StringPresenter<List<TUBean>> {

    public TUPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<TUBean> dealResponse(String s, HashMap<String, String> headers) {
        List<TUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.content > img");
        for (Element element : select) {
            TUBean bean = new TUBean();
            String url = element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.html")) {
            url = url.replace("_1.html", ".html");
        }
        return url;
    }

}
