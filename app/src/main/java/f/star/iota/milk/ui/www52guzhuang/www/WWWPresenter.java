package f.star.iota.milk.ui.www52guzhuang.www;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import f.star.iota.milk.Net;
import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;


public class WWWPresenter extends StringPresenter<List<WWWBean>> {
    public WWWPresenter(PVContract.View view) {
        super(view);
    }


    @Override
    protected List<WWWBean> dealResponse(String s, HashMap<String, String> headers) {
        List<WWWBean> list = new ArrayList<>();
        Elements eList = Jsoup.parse(s).select("div#postlist > div");
        for (int i=0;i<eList.size()-1;i++) {
            Elements links = null;
            if(i==0){
                if(links ==null || links.size() ==0){
                    links = eList.get(i).select("div#jiathis_share_CODE_HTML4 > div.t_fsz >table > tbody > tr:nth-child(1) >td.t_f >ignore_js_op");
                }
                if(links ==null || links.size() ==0){
                    links = eList.get(i).select("#jiathis_share_CODE_HTML4 > div.t_fsz >table > tr:nth-child(1) >td.t_f >div:nth-last-of-type(1) > font > font > font > ignore_js_op");
                }
                if(links ==null || links.size() ==0){
                    links = eList.get(i).select("#jiathis_share_CODE_HTML4 > div.t_fsz >table > tr:nth-child(1) >td.t_f > ignore_js_op");
                }
                if(links ==null || links.size() ==0){
                    links = eList.get(i).select("table.plhin > tbody > tr:nth-child(1) > td.plc > div.pct > div.pcb > div.t_fsz > table > tbody > tr:nth-child(1) > td.t_f > div > ignore_js_op");
                }
            }else {
                if(links ==null || links.size() ==0){
                    links = eList.get(i).select("table.plhin > tbody > tr:nth-child(1) > td.plc > div.pct > div.pcb > div.t_fsz > table > tbody > tr:nth-child(1) >td.t_f > ignore_js_op");
                }
                if(links ==null || links.size() ==0){
                    links = eList.get(i).select("table.plhin > tbody > tr:nth-child(1) > td.plc > div.pct > div.pcb > div.t_fsz > table > tbody > tr:nth-child(1) > td.t_f > div > ignore_js_op");
                }

            }
            for(Element e:links){
                WWWBean bean = new WWWBean();
                Element link = e.select("img").first();
                String url = link.attr("zoomfile");
                bean.setUrl(Net.WWW52GUZHUANG_BASE + url);
                bean.setHeaders(headers);
                list.add(bean);
            }
        }
        return list;
    }

}
