package f.star.iota.milk.ui.www52guzhuang.guzhuang;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class GuZhuangPresenter extends StringPresenter<List<GuZhuangBean>> {


    public GuZhuangPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GuZhuangBean> dealResponse(String s, HashMap<String, String> headers) {
        List<GuZhuangBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("div#threadlist > div.sk-box > div.bd > div.sk-vlist > div.v");
        for (Element element : select) {
            GuZhuangBean bean = new GuZhuangBean();
            String preview = element.select("div.v-thumb > img").attr("src");
            bean.setPreview(Net.WWW52GUZHUANG_BASE + preview);
            String url = element.select("div.v-link > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("div.v-link > a").attr("title");
            bean.setDescription(description);
            String date = element.select("div.v-thumb > div.v-thumb-tagrb > span.v-time").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }
}
