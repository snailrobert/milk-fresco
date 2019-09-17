package f.star.iota.milk.ui.ncjlh.nc;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class NcPresenter extends StringPresenter<List<NcBean>> {

    public NcPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<NcBean> dealResponse(String s, HashMap<String, String> headers) {
        List<NcBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#post-content > img");
        for (Element element : select) {
            NcBean bean = new NcBean();
            String url = Net.NCJLH_BASE + element.select("img").attr("src");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
