package f.star.iota.milk.ui.acg17.a;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class ACGPresenter extends StringPresenter<List<ACGBean>> {

    public ACGPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ACGBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ACGBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#the-post > div > div.entry > p img");
        for (Element element : select) {
            ACGBean bean = new ACGBean();
            String url = element.attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }
}
