package f.star.iota.milk.ui.xsnvshen.xs;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class XSNvShenPresenter extends StringPresenter<List<XSNvShenBean>> {

    public XSNvShenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<XSNvShenBean> dealResponse(String s, HashMap<String, String> headers) {
        List<XSNvShenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#load-img > ul > li");
        for (Element element : select) {
            XSNvShenBean bean = new XSNvShenBean();
            String preview = element.select("a > img").attr("src");
            bean.setPreview("https:" + preview);
            String url = element.select("a").attr("href");
            bean.setUrl(Net.XSNVSHEN_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("a").attr("title");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
