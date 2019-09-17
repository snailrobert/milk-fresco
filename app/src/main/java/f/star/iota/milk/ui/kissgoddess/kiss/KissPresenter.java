package f.star.iota.milk.ui.kissgoddess.kiss;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class KissPresenter extends StringPresenter<List<KissBean>> {

    public KissPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<KissBean> dealResponse(String s, HashMap<String, String> headers) {
        List<KissBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#post-3251 > div.td-gallery-content > img");
        for (Element element : select) {
            KissBean bean = new KissBean();
            String url = element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
