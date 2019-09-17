package f.star.iota.milk.ui.zu80.www;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class ZUPresenter extends StringPresenter<List<ZUBean>> {

    public ZUPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<ZUBean> dealResponse(String s, HashMap<String, String> headers) {
        List<ZUBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("article.post.type-post > div.entry > div.entry-content.clearfix > p > a > img");
        for (Element element : select) {
            ZUBean bean = new ZUBean();
            String url = element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
