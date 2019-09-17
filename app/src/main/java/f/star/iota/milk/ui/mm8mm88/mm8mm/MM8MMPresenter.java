package f.star.iota.milk.ui.mm8mm88.mm8mm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class MM8MMPresenter extends StringPresenter<List<MM8MMBean>> {

    public MM8MMPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MM8MMBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MM8MMBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#yt_box_mm8mm88 > div.wb_listbox > div.wb_ppic");
        for (Element element : select) {
            MM8MMBean bean = new MM8MMBean();
            String preview = element.select("dl > dd > a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("dl > dd > a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("dl > dd > a > img").attr("title");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
