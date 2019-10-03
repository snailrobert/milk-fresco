package f.star.iota.milk.ui.isaob.isao;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class ISaoPresenter extends StringPresenter<List<ISaoBean>> {

    public ISaoPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected List<ISaoBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ISaoBean> list = new ArrayList<>();
        if(headers.get("Referer").contains("tag")){
            Elements select = Jsoup.parse(s).select("body > div.container-fluid.my-4 > div.offset-md-1.col-md-10.col-sm-12> div.row.mt-2 > div");
            for (Element element : select) {
                ISaoBean bean = new ISaoBean();
                String preview = element.select("img").attr("src");
                bean.setPreview(preview);
                String url = element.select("div.item-title > a").attr("href");
                bean.setUrl(url);
                bean.setHeaders(headers);
                String description = element.select("img").attr("alt");
                bean.setDescription(description);
                list.add(bean);
            }
        }else{
            Elements select = Jsoup.parse(s).select("body > div.container-fluid.my-4 > div.offset-md-1.col-md-10.col-sm-12 > div.row.mt-2 > div.col-md-8.col-sm-12 > div.row > div.col-12.mt-3 > div.card > div.card-body.row > div");
            for (Element element : select) {
                ISaoBean bean = new ISaoBean();
                String preview = element.select("div.gallery > a > img").attr("src");
                bean.setPreview(preview);
                String url = element.select("div.gallery > a").attr("href");
                bean.setUrl(url);
                bean.setHeaders(headers);
                String description = element.select("div.gallery > a > h3").text();
                bean.setDescription(description);
                list.add(bean);
            }
        }

        return list;
    }

}
