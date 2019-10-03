package f.star.iota.milk.ui.nvshens.nv;


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
        Elements select = Jsoup.parse(s).select("#listdiv > ul > li");
        if(headers.get("Referer").contains("gallery")){
            for (Element element : select) {
                NvShenBean bean = new NvShenBean();
                String preview = element.select("div.galleryli_div > a > img").attr("data-original");
                bean.setPreview(preview);
                String url = element.select("div.galleryli_title > a").attr("href");
                bean.setUrl(Net.NVSHENS_BASE + url);
                bean.setHeaders(headers);
                String description = element.select("div.galleryli_title > a").text();
                bean.setDescription(description);
                list.add(bean);
            }
        }else {
            for (Element element : select) {
                NvShenBean bean = new NvShenBean();
                String preview = element.select("div > a > img").attr("data-original");
                bean.setPreview(preview);
                String url = element.select("div > a").attr("href");
                bean.setUrl(Net.NVSHENS_BASE + url);
                bean.setHeaders(headers);
                String description = element.select("div > ul > li:nth-child(1) > strong > a").text() +" "+ element.select("div > ul > li:nth-child(2)").text();
                bean.setDescription(description);
                list.add(bean);
            }
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("1.html")) {
            url = url.replace("1.html", "");
        }
        return url;
    }
}
