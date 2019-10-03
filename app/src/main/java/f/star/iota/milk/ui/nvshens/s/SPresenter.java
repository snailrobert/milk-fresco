package f.star.iota.milk.ui.nvshens.s;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class SPresenter extends StringPresenter<List<SBean>> {

    public SPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<SBean> dealResponse(String s, HashMap<String, String> headers) {
        List<SBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#hgallery > img");
        for (Element element : select) {
            SBean bean = new SBean();
            String url = element.attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
