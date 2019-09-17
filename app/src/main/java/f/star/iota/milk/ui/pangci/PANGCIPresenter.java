package f.star.iota.milk.ui.pangci;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class PANGCIPresenter extends StringPresenter<List<PANGCIBean>> {

    public PANGCIPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<PANGCIBean> dealResponse(String s, HashMap<String, String> headers) {
        List<PANGCIBean> list = new ArrayList<>();
        Elements eles = Jsoup.parse(s).select("div.width > div.item");
        for (Element e : eles) {
            PANGCIBean bean = new PANGCIBean();
            String preview = e.select("div.item > div.line > div.p > a > img").attr("src");
            bean.setPreview(preview);
            String url = preview.replace("thumb_300_0_", "");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = e.select("div.item > div.line > div.p > a > Strong").text();
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
