package f.star.iota.milk.ui.yuleba.yule;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class YuLeBaPresenter extends StringPresenter<List<YuLeBaBean>> {


    public YuLeBaPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<YuLeBaBean> dealResponse(String s, HashMap<String, String> headers) {
        List<YuLeBaBean> list = new ArrayList<>();
        Elements selects = Jsoup.parse(s).select("body > div.main > div.left > div.b_img > ul");
        for (Element element : selects) {
            Elements elements = element.select("li");
            for(Element ele : elements){
                YuLeBaBean bean = new YuLeBaBean();
                String preview = ele.select("a > img").attr("src");
                bean.setPreview(preview);
                String url = ele.select("a").attr("href");
                bean.setUrl(Net.YULEBA_BASE + url);
                bean.setHeaders(headers);
                String description = ele.select("h3 > a").text();
                bean.setDescription(description);
                list.add(bean);
            }
        }
        return list;
    }

}
