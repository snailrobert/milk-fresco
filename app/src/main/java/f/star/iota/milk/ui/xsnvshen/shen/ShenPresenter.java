package f.star.iota.milk.ui.xsnvshen.shen;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class ShenPresenter extends StringPresenter<List<ShenBean>> {

    public ShenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ShenBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ShenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.container.mt20 > div > div.showlists.hide > ul > li");
        for (Element element : select) {
            ShenBean bean = new ShenBean();
            String url = element.select("div > img").attr("src");
            bean.setUrl("https:"+ url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
