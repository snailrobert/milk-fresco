package f.star.iota.milk.ui.meitulu.lu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class LuPresenter extends StringPresenter<List<LuBean>> {

    public LuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<LuBean> dealResponse(String s, HashMap<String, String> headers) {
        List<LuBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.content > center > img");
        for (Element element : select) {
            LuBean bean = new LuBean();
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
