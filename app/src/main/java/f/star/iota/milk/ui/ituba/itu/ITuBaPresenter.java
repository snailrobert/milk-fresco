package f.star.iota.milk.ui.ituba.itu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ITuBaPresenter extends StringPresenter<List<ITuBaBean>> {


    public ITuBaPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected List<ITuBaBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ITuBaBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#main > article.picture");
        for (Element element : select) {
            ITuBaBean bean = new ITuBaBean();
            String preview = element.select("div.picture-box > figure.picture-img > span.load > a > img").attr("data-original");
            bean.setPreview(preview);
            String url = element.select("div.picture-box > figure.picture-img > span.load > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("div.picture-box > figure.picture-img > span.load > a > img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }

}
