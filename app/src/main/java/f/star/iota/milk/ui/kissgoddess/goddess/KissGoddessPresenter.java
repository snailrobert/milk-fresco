package f.star.iota.milk.ui.kissgoddess.goddess;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class KissGoddessPresenter extends StringPresenter<List<KissGoddessBean>> {

    public KissGoddessPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<KissGoddessBean> dealResponse(String s, HashMap<String, String> headers) {
        List<KissGoddessBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#post-3251 > div.td-post-header > div.td_block_inner > div.td-related-row > div.td-related-gallery");
        for (Element element : select) {
            KissGoddessBean bean = new KissGoddessBean();
            String preview = element.select("div.td-module-image > div.td-module-thumb > a > img").attr("data-original");
            bean.setPreview(preview);
            String url = element.select("div.td-module-image > div.td-module-thumb > a").attr("href");
            bean.setUrl(Net.GODDESS_BASE + url);
            bean.setHeaders(headers);
            String description = element.select("div.td-module-image > div.td-module-thumb > a").attr("title");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }
}
