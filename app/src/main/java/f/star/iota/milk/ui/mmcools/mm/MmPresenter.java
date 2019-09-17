package f.star.iota.milk.ui.mmcools.mm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class MmPresenter extends StringPresenter<List<MmBean>> {
    public MmPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MmBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MmBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#content > a > img");
        for (Element element : select) {
            MmBean bean = new MmBean();
            String url = element.attr("src");
            bean.setUrl(Net.MMCOOLS_BASE + url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }
}
