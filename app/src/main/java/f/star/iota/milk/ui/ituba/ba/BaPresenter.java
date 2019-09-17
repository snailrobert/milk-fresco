package f.star.iota.milk.ui.ituba.ba;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class BaPresenter extends StringPresenter<List<BaBean>> {
    public BaPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected List<BaBean> dealResponse(String s, HashMap<String, String> headers) {
        List<BaBean> list = new ArrayList<>();
        Elements select =  Jsoup.parse(s).select("#main > article > div.entry-content > div.single-content > P img");
        for (Element element : select) {
            BaBean bean = new BaBean();
            String url = element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
