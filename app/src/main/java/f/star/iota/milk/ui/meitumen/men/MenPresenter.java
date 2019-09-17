package f.star.iota.milk.ui.meitumen.men;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class MenPresenter extends StringPresenter<List<MenBean>> {

    public MenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MenBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#tplist > div.bottom-lists.l > div.minPic.l > ul > li");
        for (Element element : select) {
            MenBean bean = new MenBean();
            String url = element.select("a > img").attr("src");
            url = url.replace("-80x0","");
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
