package f.star.iota.milk.ui.acg17.acg;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ACG17Presenter extends StringPresenter<List<ACG17Bean>> {

    public ACG17Presenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ACG17Bean> dealResponse(String s, HashMap<String, String> headers) {
        List<ACG17Bean> list = new ArrayList<>();

        Elements select = Jsoup.parse(s).select("#main-content > div.content > div.post-listing.archive-box > article.item-list");
        for (Element element : select) {
            ACG17Bean bean = new ACG17Bean();
            String preview = element.select("div.post-thumbnail > a > img").attr("style");
            preview = preview.substring(preview.indexOf("(")+1,preview.indexOf(")"));
            bean.setPreview(preview);
            String url = element.select("div.post-thumbnail > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("h2 > a").text();
            bean.setDescription(description);
            String date = element.select("p > span.tie-date").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
