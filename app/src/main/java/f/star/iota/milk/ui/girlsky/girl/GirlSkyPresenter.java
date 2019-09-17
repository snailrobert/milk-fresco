package f.star.iota.milk.ui.girlsky.girl;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class GirlSkyPresenter extends StringPresenter<List<GirlSkyBean>> {


    public GirlSkyPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GirlSkyBean> dealResponse(String s, HashMap<String, String> headers) {
        List<GirlSkyBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.wrap > div.TypeList > ul > li");
        for (Element element : select) {
            GirlSkyBean bean = new GirlSkyBean();
            String preview = element.select("a.TypeBigPics > img").attr("data-original");
            if(!preview.contains("http")){
                preview = "http:" + preview;
            }
            bean.setPreview(preview);
            String url = element.select("a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("a > span").text();
            bean.setDescription(description);
            String date = element.select("div.TypePicInfos > div.txtInfo > strong.IcoTime").text();
            bean.setDate(date);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.html")) {
            url = url.substring(0, url.lastIndexOf("/"));
            // url = url.replace("index_1.html", "");
        }
        return url;
    }
}
