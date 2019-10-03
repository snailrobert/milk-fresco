package f.star.iota.milk.ui.woaimeizi.woai;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class WoAiMeiZiPresenter extends StringPresenter<List<WoAiMeiZiBean>> {


    public WoAiMeiZiPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<WoAiMeiZiBean> dealResponse(String s, HashMap<String, String> headers) {
        List<WoAiMeiZiBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.update_area > div.update_area_content > ul.update_area_lists.cl > li");
        for (Element element : select) {
            WoAiMeiZiBean bean = new WoAiMeiZiBean();
            String preview = element.select("a > img").attr("data-original");
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
        if (url.contains("page_1.html")) {
            url = url.replace("page_1.html", "");
        }
        return url;
    }

}
