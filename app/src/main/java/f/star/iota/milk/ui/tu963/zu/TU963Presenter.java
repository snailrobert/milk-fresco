package f.star.iota.milk.ui.tu963.zu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class TU963Presenter extends StringPresenter<List<TU963Bean>> {

    public TU963Presenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<TU963Bean> dealResponse(String s, HashMap<String, String> headers) {
        List<TU963Bean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.w1200 > div.listMeinuT > ul > li");
        for (Element element : select) {
            TU963Bean bean = new TU963Bean();
            String preview = element.select("a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("a").attr("title");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String charset() {
        return "gb2312";
    }

}
