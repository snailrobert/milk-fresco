package f.star.iota.milk.ui.nvshens.shen;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ShenPresenter extends StringPresenter<List<ShenBean>> {

    public ShenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ShenBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ShenBean> list = new ArrayList<>();
        Elements select = null;
        if(headers.get("Referer").contains("album")){
            select = Jsoup.parse(s).select("#photo_list > ul.photo_ul > li");
        }else{
            select = Jsoup.parse(s).select("#post > div.entry_box > div.box_entry > div.post_entry > ul.photo_ul > li");
        }
        for (Element element : select) {
            ShenBean bean = new ShenBean();
            String preview = element.select("div.igalleryli_div > a > img").attr("data-original");
            if (preview == "") {
                preview = element.select("div.igalleryli_div > a > img").attr("src");
            }
            bean.setPreview(preview);
            String url = element.select("div.igalleryli_title > a").attr("href");
            bean.setUrl(Net.NVSHENS_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("div.igalleryli_title > a").text();
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("?p=2")) {
            url = url.replace("?p=2", "album/");
        }
        return url;
    }
}
