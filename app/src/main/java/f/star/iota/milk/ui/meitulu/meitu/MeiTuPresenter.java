package f.star.iota.milk.ui.meitulu.meitu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class MeiTuPresenter extends StringPresenter<List<MeiTuBean>> {

    public MeiTuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MeiTuBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MeiTuBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.main > div.boxs > ul > li");
        for (Element element : select) {
            MeiTuBean bean = new MeiTuBean();
            String preview = element.select("a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("a > img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("1.html")) {
            url = url.replace("1.html", "");
        }
        return url;
    }
}
