package f.star.iota.milk.ui.meitumen.meitu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class MeiTuMenPresenter extends StringPresenter<List<MeiTuMenBean>> {

    public MeiTuMenPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<MeiTuMenBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MeiTuMenBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#load-img > div.pos__1.camWholeBox.borderTop > ul > li.min-h-imgall");
        for (Element element : select) {
            MeiTuMenBean bean = new MeiTuMenBean();
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
}
