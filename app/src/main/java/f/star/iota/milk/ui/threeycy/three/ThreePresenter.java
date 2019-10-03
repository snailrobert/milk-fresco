package f.star.iota.milk.ui.threeycy.three;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class ThreePresenter extends StringPresenter<List<ThreeBean>> {
    public ThreePresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ThreeBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ThreeBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.pageWide.center > div.postMain > div.postBody > img");
        for (Element element : select) {
            ThreeBean bean = new ThreeBean();
            String url = element.attr("data-src");
            if(url == ""){
                url = element.attr("src");
            }
            bean.setUrl(Net.THREEYCY_BASE + url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }
}
