package f.star.iota.milk.ui.bcy.ranking;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import f.star.iota.milk.base.PVContract;
import f.star.iota.milk.base.StringPresenter;

public class BCYRankingPresenter extends StringPresenter<List<BCYRankingBean>> {


    public BCYRankingPresenter(PVContract.View view) {
        super(view);
    }

    @Override
    protected List<BCYRankingBean> dealResponse(String s, HashMap<String, String> headers) {

        Map map = new Gson().fromJson(s,Map.class);
        List<BCYRankingBean> list = mapToBean(map);

        return list;
    }

    protected List<BCYRankingBean> mapToBean(Map map){
        List<BCYRankingBean> list = new ArrayList<BCYRankingBean>();
        Map data = (Map)map.get("data");
        List<Map> topListItemInfo = (List<Map>) data.get("top_list_item_info");
        if (topListItemInfo == null || topListItemInfo.size()== 0 ){
            return  list;
        }
        for(Map item : topListItemInfo){
            BCYRankingBean bcyRankingBean = new BCYRankingBean();
            Map itemDetail = (Map) item.get("item_detail");
            Map topListDetail = (Map) item.get("top_list_detail");

            bcyRankingBean.setAuthor((String) itemDetail.get("uname"));
            bcyRankingBean.setAvatar((String) itemDetail.get("avatar"));
            bcyRankingBean.setPreview((String) itemDetail.get("cover"));
            bcyRankingBean.setDescription((String) itemDetail.get("plain"));
            bcyRankingBean.setRank(String.valueOf(topListDetail.get("rank")));

            List<Map> imageList = (List<Map>) itemDetail.get("image_list");
            List<String> imgs = new ArrayList<String>();
            for(Map img : imageList){
                imgs.add((String) img.get("path"));
            }
            bcyRankingBean.setImgs(imgs);
            list.add(bcyRankingBean);
        }

        return  list;

    }
}
