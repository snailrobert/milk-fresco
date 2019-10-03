package f.star.iota.milk.ui.threeycy.ycy;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ThreeYCYPresenter extends StringPresenter<List<ThreeYCYBean>> {


    public ThreeYCYPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ThreeYCYBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ThreeYCYBean> list = new ArrayList<>();
        Elements select = Jsoup.parseBodyFragment(s).select("body > div.pageWide.center > div.postList > div.postItem");
        for (Element element : select) {
            ThreeYCYBean bean = new ThreeYCYBean();
            String preview = element.select("div.postThumb.floatLeft > a > img").attr("src");
            bean.setPreview(Net.THREEYCY_BASE + preview);
            String url = element.select("div.postThumb.floatLeft > a").attr("href");
            bean.setUrl(Net.THREEYCY_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("h3 > a").text();
            bean.setDescription(description);
            String date = element.select("div.postSubtitle").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }

}
