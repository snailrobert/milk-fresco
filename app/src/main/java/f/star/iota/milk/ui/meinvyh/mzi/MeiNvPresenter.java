package f.star.iota.milk.ui.meinvyh.mzi;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class MeiNvPresenter extends StringPresenter<List<MeiNvBean>> {


    public MeiNvPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MeiNvBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MeiNvBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#index-pic > div.group");
        for (Element element : select) {
            MeiNvBean bean = new MeiNvBean();
            String preview = element.select("div > a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("div > a").attr("href");
            bean.setUrl(Net.MEINVYH_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("div > a > img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
