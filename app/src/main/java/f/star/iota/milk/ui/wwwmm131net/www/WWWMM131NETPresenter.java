package f.star.iota.milk.ui.wwwmm131net.www;


import com.lzy.okgo.request.GetRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class WWWMM131NETPresenter extends StringPresenter<List<WWWMM131NETBean>> {


    public WWWMM131NETPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected List<WWWMM131NETBean> dealResponse(String s, HashMap<String, String> headers) {
        List<WWWMM131NETBean> list = new ArrayList<>();
        Elements select = Jsoup.parse(s).select("body > div.main > dl.list-left.public-box > dd");
        for (Element element : select) {
            WWWMM131NETBean bean = new WWWMM131NETBean();
            String preview = element.select("a > img").attr("src");
            bean.setPreview(preview);
            String url = element.select("a").attr("href");
            bean.setUrl(url);
            bean.setHeaders(headers);
            String description = element.select("a > img").attr("alt");
            bean.setDescription(description);
            list.add(bean);
        }
        return list;
    }

    @Override
    protected String dealUrl(String url) {
        if (url.contains("_1.html")) {
            if (url.contains("list_6_1.html")) {
                url = url.replace("list_6_1.html", "");
            } else if (url.contains("list_1_1.html")) {
                url = url.replace("list_1_1.html", "");
            }else if (url.contains("list_2_1.html")) {
                url = url.replace("list_2_1.html", "");
            }
        }
        return url;
    }


    @Override
    protected void addHeaders(GetRequest<String> request) {
        String url = request.getUrl();
        if (url.contains("xinggan")) {
            request.headers("Referer", "https://www.mm131.net/xinggan/");
        } else if (url.contains("qingchun")) {
            request.headers("Referer", "https://www.mm131.net/qingchun/");
        }else if (url.contains("xiaohua")) {
            request.headers("Referer", "https://www.mm131.net/xiaohua/");
        }
        request.headers("Host", "www.mm131.net");
        request.headers("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        request.headers("Proxy-Connection", "keep-alive");
        request.headers("Upgrade-Insecure-Requests", "1");
    }

    @Override
    protected String charset() {
        return "gb2312";
    }

}
