package f.star.iota.milk.ui.zu80.zu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ZU80Presenter extends StringPresenter<List<ZU80Bean>> {

    public ZU80Presenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ZU80Bean> dealResponse(String s, HashMap<String, String> headers) {
        List<ZU80Bean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#wrap > div.main > div.archive-list > div.sec-panel-body > ul.image-list > li");
        for (Element element : select) {
            ZU80Bean bean = new ZU80Bean();
            String preview = element.select("div > a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("div > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("div > a").attr("title");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
