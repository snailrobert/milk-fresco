package f.star.iota.milk.ui.meinvyh.yh;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class YHPresenter extends StringPresenter<List<YHBean>> {

    public YHPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<YHBean> dealResponse(String s, HashMap<String, String> headers) {
        List<YHBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#thread-pic > ul.adw > li");
        for (Element element : select) {
            YHBean bean = new YHBean();
            String url = element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}