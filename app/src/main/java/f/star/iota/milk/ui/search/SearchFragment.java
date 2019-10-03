package f.star.iota.milk.ui.search;


import android.os.Bundle;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import f.star.iota.milk.Menus;
import f.star.iota.milk.R;
import f.star.iota.milk.base.ScrollImageFragment;

public class SearchFragment extends ScrollImageFragment<SearchPresenter, SearchAdapter> {


    public static SearchFragment newInstance(int type, String param, String title) {
        SearchFragment fragment = new SearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("type",type);

        switch (type) {
            case Menus.MENU_XSNVSHEN_MEINV_ID:
                try {
                    bundle.putString("base_url", "https://www.xsnvshen.com/search?w="  + URLEncoder.encode(param.trim(),"UTF-8")+"&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_MEITUMEN_MENU_ID:
                try {
                    bundle.putString("base_url", "https://www.meitumen.com/page/");
                    bundle.putString("page_suffix","?s=" +URLEncoder.encode(param.trim(),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_MEITULU_ID:
                try {
                    bundle.putString("base_url", "https://www.meitulu.com/search/"+URLEncoder.encode(param.trim(),"UTF-8")+"?");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_MZITU_ID:
                try {
                    bundle.putString("base_url", "https://www.mzitu.com/search/"+URLEncoder.encode(param.trim(),"UTF-8")+"/page/");
                    bundle.putString("page_suffix","/");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_GIRLSKY_ID:
                try {
                    bundle.putString("base_url", "http://www.girlsky.cn/index.php?m=search&c=index&a=init&typeid=1&q="+URLEncoder.encode(param.trim(),"UTF-8")+"&page=");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_TU963_ID:
                try {
                    bundle.putString("base_url", "https://www.tu963.net/plus/search.php?keyword="+URLEncoder.encode(param.trim(),"gb2312")+"&pagesize=30&page=");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_ITMTU_ID:
                try {
                    bundle.putString("base_url", "http://www.itmtu.com/page/");
                    bundle.putString("page_suffix","/?s=" +URLEncoder.encode(param.trim(),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_GKDGIF_ID:
                try {
                    bundle.putString("base_url", "https://gkdgif.com/page/");
                    bundle.putString("page_suffix","/?s=" +URLEncoder.encode(param.trim(),"UTF-8")+"&type=all");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_PIXIVIC_ID:
                try {
                    bundle.putString("base_url","https://search.api.pixivic.com/illustrations?keyword="+URLEncoder.encode(param.trim(),"UTF-8")+"&page=");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_ISAOB_ID:
                try {
                    bundle.putString("base_url","http://www.isaob.com/tag/"+URLEncoder.encode(param.trim(),"UTF-8")+"/");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case Menus.MENU_NVSHENS_TAG_ID:
                try {
                    bundle.putString("base_url","https://www.nvshens.net/girl/search.aspx?name="+URLEncoder.encode(param.trim(),"UTF-8")+"&P=");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void init() {
        Bundle arguments = getArguments();
        setTitle(arguments.getString("title", getString(R.string.app_name)));
        super.init();
    }


    @Override
    protected SearchPresenter getPresenter() {
        Bundle arguments = getArguments();
        int type = arguments.getInt("type");
        return new SearchPresenter(this,type);
    }

    @Override
    protected SearchAdapter getAdapter() {
        return new SearchAdapter();
    }

    @Override
    protected boolean isHideFab() {
        return false;
    }

}
