package f.star.iota.milk.ui.xsnvshen.nv;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class NvShenPresenter extends StringPresenter<List<NvShenBean>> {

    public NvShenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<NvShenBean> dealResponse(String s, HashMap<String, String> headers) {
        List<NvShenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.wrapper1083 > div.boxwrap > div.boxinner-l > div.star-mod.entryAblum > div.star-mod-bd > ul > li");
        for (Element element : select) {
            NvShenBean bean = new NvShenBean();
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
