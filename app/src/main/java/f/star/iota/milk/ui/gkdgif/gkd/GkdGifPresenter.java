package f.star.iota.milk.ui.gkdgif.gkd;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class GkdGifPresenter extends StringPresenter<List<GkdGifBean>> {

    public GkdGifPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GkdGifBean> dealResponse(String s, HashMap<String, String> headers) {
        List<GkdGifBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#post-list > ul > li");
        for (Element element : select) {
            GkdGifBean bean = new GkdGifBean();
            String preview = element.select("div.post-module-thumb > a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("div.post-module-thumb > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("div.post-info > h2 > a").text();
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
