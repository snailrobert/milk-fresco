package f.star.iota.milk.ui.yeitu.yei;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class YeiTuPresenter extends StringPresenter<List<YeiTuBean>> {


    public YeiTuPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<YeiTuBean> dealResponse(String s, HashMap<String, String> headers) {
        List<YeiTuBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.w.row > div.wf > ul > li.image-box");
        for (Element element : select) {
            YeiTuBean bean = new YeiTuBean();
            String preview = element.select("a > img").attr("data-echo");
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
