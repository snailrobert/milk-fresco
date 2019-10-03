package f.star.iota.milk.ui.woaimeizi.meizi;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class MeiZiPresenter extends StringPresenter<List<MeiZiBean>> {
    public MeiZiPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected List<MeiZiBean> dealResponse(String s, HashMap<String, String> headers) {
        List<MeiZiBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#content > div.content_left > p img");
        if(select == null || select.size() == 0){
            select = Jsoup.parse(s).select("#content > div.content_left > div.wp-block-image figure.aligncenter img");
        }
        for (Element element : select) {
            MeiZiBean bean = new MeiZiBean();
            String url = element.attr("src");
            if(!url.contains("http")){
                url = Net.WOAIMEIZI_BASE + url;
            }
            bean.setUrl(url);
            bean.setHeaders(headers);
            list.add(bean);
        }
        return list;
    }

}
