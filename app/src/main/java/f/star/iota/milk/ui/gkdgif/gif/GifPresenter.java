package f.star.iota.milk.ui.gkdgif.gif;


import com.lzy.okgo.OkGo;
import com.lzy.okgo.adapter.Call;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class GifPresenter extends StringPresenter<List<GifBean>> {

    public GifPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<GifBean> dealResponse(String s, HashMap<String, String> headers) {
        List<GifBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("#primary-home > article.single-article > div.entry-content > p img");
        if (select != null){
            for (Element element : select) {
                GifBean bean = new GifBean();
                String url = element.select("img").attr("src");
                bean.setUrl(url);
                bean.setHeaders(headers);
                list.add(bean);
            }
        }
        String referer = headers.get("Referer");
        String id = referer.substring(referer.lastIndexOf("/")+1,referer.lastIndexOf(".html"));
        try {
            Call<String> call = OkGo.<String>post("https://gkdgif.com/wp-json/b2/v1/getHiddenContent")
                    .params("id", id)
                    .converter(new StringConvert())
                    .adapt();
            Response<String> response = call.execute();
            s = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        select = Jsoup.parseBodyFragment(s).select("p img");
        if (select != null){
            for (Element element : select) {
                GifBean bean = new GifBean();
                String url = element.select("img").attr("src");
                bean.setUrl(url.replace("\\","").replace("\"",""));
                bean.setHeaders(headers);
                list.add(bean);
            }
        }
        return list;
    }

}
