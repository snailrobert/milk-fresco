package f.star.iota.milk.ui.isaob.b;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class BPresenter extends StringPresenter<List<BBean>> {

    public BPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<BBean> dealResponse(String s, HashMap<String, String> headers) {
        List<BBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#masonry > div");
        for (Element element : select) {
            BBean bean = new BBean();
            String url = element.select("img").attr("data-src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }


}
