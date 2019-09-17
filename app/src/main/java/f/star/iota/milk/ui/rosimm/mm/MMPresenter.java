package f.star.iota.milk.ui.rosimm.mm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class MMPresenter extends StringPresenter<List<MMBean>> {

    public MMPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MMBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MMBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > section.container > div.content-wrap > div.content > article.article-content >img");
        if(select.size() ==0){
            select = Jsoup.parse(s).select("body > section.container > div.content-wrap > div.content > article.article-content > div");
        }
        for (Element element : select) {
            MMBean bean = new MMBean();
            String url = element.select("img").attr("src");
            if(headers.get("Referer").contains(Net.ROSIMM_BASE_ROSI6)){
                url = Net.ROSIMM_BASE_ROSI6 + url;
            }else if(headers.get("Referer").contains(Net.ROSIMM_BASE_ROSIMMS)){
                url = Net.ROSIMM_BASE_ROSIMMS + url;
            } else if(headers.get("Referer").contains(Net.ROSIMM_BASE_ROSIMM8)){
                url = Net.ROSIMM_BASE_ROSIMM8 + url;
            }
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.html")) {
            url = url.replace("_1.html", ".html");
        }
        return url;
    }
}
