package f.star.iota.milk.ui.wwwmm131net.mm;


import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class MMPresenter extends StringPresenter<List<MMBean>> {

    public MMPresenter(PVContract.View view) {
        super(view);
    }



    @Override
    protected List<MMBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MMBean> list = new ArrayList<>();
        MMBean bean = new MMBean();
        String url = Jsoup.parse(s).select("body > div.content > div.content-pic > a > img").first().attr("src");
        bean.setUrl(url);
        bean.setHeaders(headers);
        list.add(bean);
        return list;
    }


    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.html")) {
            url = url.replace("_1.html", ".html");
        }
        return url;
    }

}
