package f.star.iota.milk.ui.menu;


import java.util.ArrayList;
import java.util.List;

import f.star.iota.milk.Menus;
import f.star.iota.milk.Net;
import f.star.iota.milk.base.BaseActivity;
import f.star.iota.milk.base.BaseFragment;
import f.star.iota.milk.config.OtherConfig;
import f.star.iota.milk.ui.acg17.acg.ACG17PagerFragment;
import f.star.iota.milk.ui.bcy.ranking.BCYRankingPagerFragment;
import f.star.iota.milk.ui.bilibili.BilibiliPagerFragment;
import f.star.iota.milk.ui.chinagirlol.china.ChinaGirlOLPagerFragment;
import f.star.iota.milk.ui.cosplayla.cosplay.CosplayLaFragment;
import f.star.iota.milk.ui.gamersky.gamer.GamerSkyFragment;
import f.star.iota.milk.ui.gank.GankFragment;
import f.star.iota.milk.ui.girlatlas.girl.GirlAtlasPagerFragment;
import f.star.iota.milk.ui.girlsky.girl.GirlSkyPagerFragment;
import f.star.iota.milk.ui.gravuregirlz.gravure.GravureGirlZFragment;
import f.star.iota.milk.ui.ituba.itu.ITuBaPagerFragment;
import f.star.iota.milk.ui.jdlingyu.jd.JDLINGYUPagerFragment;
import f.star.iota.milk.ui.kissgoddess.goddess.KissGoddessPagerFragment;
import f.star.iota.milk.ui.magmoe.mag.MagPagerFragment;
import f.star.iota.milk.ui.meitulu.meitu.MeiTuPagerFragment;
import f.star.iota.milk.ui.meitumen.meitu.MeiTuMenPagerFragment;
import f.star.iota.milk.ui.mm8mm88.mm8mm.MM8MMPagerFragment;
import f.star.iota.milk.ui.mmcools.cools.MMCOOLSFragment;
import f.star.iota.milk.ui.mmjpg.mm.MmjpgPagerFragment;
import f.star.iota.milk.ui.mmonly.mm.MMONLYFragment;
import f.star.iota.milk.ui.moe005tv.moe.MOE005TVPagerFragment;
import f.star.iota.milk.ui.mzitu.mzi.MZITUFragment;
import f.star.iota.milk.ui.ncjlh.jlh.NcJlhPagerFragment;
import f.star.iota.milk.ui.rosimm.rosi.ROSIMMPagerFragment;
import f.star.iota.milk.ui.umei.u.UMEIFragment;
import f.star.iota.milk.ui.www005tv.www.WWW005TVFragment;
import f.star.iota.milk.ui.www52guzhuang.guzhuang.GuZhuangPagerFragment;
import f.star.iota.milk.ui.wwwmm131net.www.WWWMM131NETPagerFragment;
import f.star.iota.milk.ui.xiuren.xiu.XiuRenFragment;
import f.star.iota.milk.ui.xsnvshen.xs.XSNvShenPagerFragment;
import f.star.iota.milk.ui.yeitu.yei.YeiTuPagerFragment;
import f.star.iota.milk.ui.yuleba.yule.YuLeBaPagerFragment;
import f.star.iota.milk.ui.zu80.zu.ZU80PagerFragment;

public class MenuMeiziFragment extends MenuFragment {
    @Override
    protected void handleOnMenuItemOnClick(MenuBean menu) {
        BaseActivity activity = (BaseActivity) mContext;
        BaseFragment currentFragment = null;
        switch (menu.getId()) {
            case Menus.MENU_ACG17_COS_ID:
                currentFragment = ACG17PagerFragment.newInstance(ACG17PagerFragment.COS);
                activity.setTitle(Menus.MENU_ACG17);
                break;
            case Menus.MENU_BCY_COS_RANKING_ID:
                currentFragment = BCYRankingPagerFragment.newInstance(BCYRankingPagerFragment.COS);
                activity.setTitle(Menus.MENU_BCY_RANKING);
                break;

            case Menus.MENU_MAG_MOE_COS_STAR_ID:
                currentFragment = MagPagerFragment.newInstance(MagPagerFragment.COS);
                activity.setTitle(Menus.MENU_MAG_MOE);
                break;
            case Menus.MENU_WWW_005_TV_COS_ID:
                currentFragment = WWW005TVFragment.newInstance(Net.WWW_005_TV_COS);
                activity.setTitle(Menus.MENU_WWW_005_TV);
                break;
            case Menus.MENU_COSPLAY_LA_ID:
                currentFragment = CosplayLaFragment.newInstance(Net.COSPLAY_LA);
                activity.setTitle(Menus.MENU_COSPLAY_LA);
                break;
            case Menus.MENU_MOE005TV_COS_ID:
                currentFragment = MOE005TVPagerFragment.newInstance(MOE005TVPagerFragment.COS);
                activity.setTitle(Menus.MENU_MOE005TV);
                break;
            case Menus.MENU_ACG_GAMERSKY_COS_ID:
                currentFragment = GamerSkyFragment.newInstance(Net.GAMERSKY_COS);
                activity.setTitle(Menus.MENU_ACG_GAMERSKY);
                break;
            case Menus.MENU_GANK_ID:
                currentFragment = GankFragment.newInstance(Net.GANK);
                activity.setTitle(Menus.MENU_GANK);
                break;
            case Menus.MENU_MEITULU_ID:
                currentFragment = new MeiTuPagerFragment();
                activity.setTitle(Menus.MENU_MEITULU);
                break;
            case Menus.MENU_JDLINGYU_ALL_ID:
                currentFragment = JDLINGYUPagerFragment.newInstance(JDLINGYUPagerFragment.ALL);
                activity.setTitle(Menus.MENU_JDLINGYU);
                break;
            case Menus.MENU_JDLINGYU_COS_ID:
                currentFragment = JDLINGYUPagerFragment.newInstance(JDLINGYUPagerFragment.COS);
                activity.setTitle(Menus.MENU_JDLINGYU);
                break;
            case Menus.MENU_JDLINGYU_HENTAI_MZITU_ID:
                currentFragment = JDLINGYUPagerFragment.newInstance(JDLINGYUPagerFragment.HENTAI_MZITU);
                activity.setTitle(Menus.MENU_JDLINGYU);
                break;
            case Menus.MENU_JDLINGYU_SIFANG_ZIPAI_ID:
                currentFragment = JDLINGYUPagerFragment.newInstance(JDLINGYUPagerFragment.SIFANG_ZIPAI);
                activity.setTitle(Menus.MENU_JDLINGYU);
                break;
            case Menus.MENU_JDLINGYU_GCTT_RBXZ_ID:
                currentFragment = JDLINGYUPagerFragment.newInstance(JDLINGYUPagerFragment.GCTT_RBXZ);
                activity.setTitle(Menus.MENU_JDLINGYU);
                break;
            case Menus.MENU_MEITUMEN_MENU_ID:
                currentFragment = MeiTuMenPagerFragment.newInstance(MeiTuMenPagerFragment.MENU);
                activity.setTitle(Menus.MENU_MEITUMEN);
                break;
            case Menus.MENU_MEITUMEN_TAG_ID:
                currentFragment = MeiTuMenPagerFragment.newInstance(MeiTuMenPagerFragment.TAG);
                activity.setTitle(Menus.MENU_MEITUMEN);
                break;
            case Menus.MENU_52GUZHUANG_ID:
                currentFragment = new GuZhuangPagerFragment();
                activity.setTitle(Menus.MENU_52GUZHUANG);
                break;
            case Menus.MENU_BILIBILI_COS_ID:
                currentFragment = BilibiliPagerFragment.newInstance(BilibiliPagerFragment.COS);
                activity.setTitle(Menus.MENU_BILIBILI);
                break;
            case Menus.MENU_MZITU_ID:
                currentFragment = MZITUFragment.newInstance(Net.MZITU);
                activity.setTitle(Menus.MENU_MZITU);
                break;
            case Menus.MENU_MMONLY_ID:
                currentFragment = MMONLYFragment.newInstance(Net.MMONLY);
                activity.setTitle(Menus.MENU_MMONLY);
                break;
            case Menus.MENU_ROSIMM_ID:
                currentFragment = new ROSIMMPagerFragment();
                activity.setTitle(Menus.MENU_ROSIMM);
                break;
            case Menus.MENU_MM131_ID:
                currentFragment = new WWWMM131NETPagerFragment();
                activity.setTitle(Menus.MENU_MM131);
                break;
            case Menus.MENU_XIUREN_ID:
                currentFragment = XiuRenFragment.newInstance(Net.XIUREN);
                activity.setTitle(Menus.MENU_XIUREN);
                break;
            case Menus.MENU_CHINAGIRLOL_ID:
                currentFragment = new ChinaGirlOLPagerFragment();
                activity.setTitle(Menus.MENU_CHINAGIRLOL);
                break;
            case Menus.MENU_GIRLSKY_ID:
                currentFragment = new GirlSkyPagerFragment();
                activity.setTitle(Menus.MENU_GIRLSKY);
                break;
            case Menus.MENU_MMCOOLS_ID:
                currentFragment = MMCOOLSFragment.newInstance(Net.MMCOOLS_GOOD);
                activity.setTitle(Menus.MENU_MMCOOLS);
                break;
            case Menus.MENU_YEITU_ID:
                currentFragment = new YeiTuPagerFragment();
                activity.setTitle(Menus.MENU_YEITU);
                break;
            case Menus.MENU_GODDESS_ID:
                currentFragment = new KissGoddessPagerFragment();
                activity.setTitle(Menus.MENU_GODDESS);
                break;
            case Menus.MENU_UMEI_ID:
                currentFragment = UMEIFragment.newInstance(Net.UMEI);
                activity.setTitle(Menus.MENU_UMEI);
                break;
            case Menus.MENU_GRAVUREGIRLZ_ID:
                currentFragment = GravureGirlZFragment.newInstance(Net.GRAVUREGIRLZ);
                activity.setTitle(Menus.MENU_GRAVUREGIRLZ);
                break;
            case Menus.MENU_MMJPG_ID:
                currentFragment = new MmjpgPagerFragment();
                activity.setTitle(Menus.MENU_MMJPG);
                break;
            case Menus.MENU_GIRL_ATLAS_ID:
                currentFragment = new GirlAtlasPagerFragment();
                activity.setTitle(Menus.MENU_GIRL_ATLAS);
                break;
            case Menus.MENU_ITUBA_ID:
                currentFragment = new ITuBaPagerFragment();
                activity.setTitle(Menus.MENU_ITUBA);
                break;
            case Menus.MENU_YULEBA_ID:
                currentFragment = new YuLeBaPagerFragment();
                activity.setTitle(Menus.MENU_YULEBA);
                break;
            case Menus.MENU_NCJLH_ID:
                currentFragment = new NcJlhPagerFragment();
                activity.setTitle(Menus.MENU_NCJLH);
                break;

            case Menus.MENU_XSNVSHEN_MEINV_ID:
                currentFragment = XSNvShenPagerFragment.newInstance(XSNvShenPagerFragment.MEINV);
                activity.setTitle(Menus.MENU_XSNVSHEN);
                break;
            case Menus.MENU_XSNVSHEN_NVSHEN_ID:
                currentFragment = XSNvShenPagerFragment.newInstance(XSNvShenPagerFragment.NVSHEN);
                activity.setTitle(Menus.MENU_XSNVSHEN);
                break;
            case Menus.MENU_XSNVSHEN_HDTU_ID:
                currentFragment = XSNvShenPagerFragment.newInstance(XSNvShenPagerFragment.HDTU);
                activity.setTitle(Menus.MENU_XSNVSHEN);
                break;
            case Menus.MENU_MM8MM88_ID:
                currentFragment = new MM8MMPagerFragment();
                activity.setTitle(Menus.MENU_MM8MM88);
                break;
            case Menus.MENU_80ZU_ID:
                currentFragment = new ZU80PagerFragment();
                activity.setTitle(Menus.MENU_80ZU);
                break;
        }
        activity.removeFragmentContainerChildrenViews();
        activity.showFragment(currentFragment);
    }

    @Override
    protected List<MenuBean> getMenuList() {
        List<MenuBean> menu = new ArrayList<>();
        menu.add(new MenuBean(Menus.MENU_MAG_MOE_COS_STAR_ID, Menus.MENU_MAG_MOE,
                Net.MAG_MOE_BASE, "http://mag.moe/wp-content/themes/magmoe/img/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_WWW_005_TV_COS_ID, Menus.MENU_WWW_005_TV,
                Net.WWW_005_TV_BASE, "http://www.005.tv/templets/muban/style/images/bannerbg.jpg", null));
        menu.add(new MenuBean(Menus.MENU_COSPLAY_LA_ID, Menus.MENU_COSPLAY_LA,
                Net.COSPLAY_LA_BASE, "http://cosplay.la/content/images/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_ACG17_COS_ID, Menus.MENU_ACG17,
                Net.ACG17_BASE, "https://i.loli.net/2018/10/02/5bb31fba269b8.png", null));
        menu.add(new MenuBean(Menus.MENU_BCY_COS_RANKING_ID, Menus.MENU_BCY_RANKING,
                Net.BCY_BASE, "https://pubin.bcyimg.com/Image/sub-nav/logo-home-9e8a0985d6.png", null));
        menu.add(new MenuBean(Menus.MENU_MOE005TV_COS_ID, Menus.MENU_MOE005TV,
                Net.MOE005TV_BASE, "http://www.005.tv/templets/muban/moe_style/image/moe_logo.png", null));
        menu.add(new MenuBean(Menus.MENU_ACG_GAMERSKY_COS_ID, Menus.MENU_ACG_GAMERSKY,
                Net.GAMERSKY_BASE, "http://image.gamersky.com/webimg13/acg/new/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_52GUZHUANG_ID, Menus.MENU_52GUZHUANG,
                Net.WWW52GUZHUANG_BASE, "http://www.52guzhuang.com/template/54zz_lens_140908/deancss/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_BILIBILI_COS_ID, Menus.MENU_BILIBILI,
                Net.BILIBILI_BASE, "http://static.hdslb.com/drawyoo/wallpaper/images/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_GANK_ID, Menus.MENU_GANK,
                Net.GANK_BASE, "https://ws1.sinaimg.cn/large/610dc034ly1fiiiyfcjdoj20u00u0ju0.jpg", null));
        menu.add(new MenuBean(Menus.MENU_MEITULU_ID, Menus.MENU_MEITULU,
                Net.MEITULU_BASE, "https://mtl.ttsqgs.com/css/logo.jpg", null));
        menu.add(new MenuBean(Menus.MENU_JDLINGYU_ALL_ID, Menus.MENU_JDLINGYU,
                Net.JDLINGYU_BASE, "http://www.jdlingyu.mobi/wp-content/uploads/2017/01/2017-01-07_20-57-14.png", null));
        menu.add(new MenuBean(Menus.MENU_JDLINGYU_COS_ID, Menus.MENU_JDLINGYU,
                Net.JDLINGYU_BASE, "http://www.jdlingyu.mobi/wp-content/uploads/2017/01/2017-01-07_20-57-14.png", null));
        menu.add(new MenuBean(Menus.MENU_JDLINGYU_HENTAI_MZITU_ID, Menus.MENU_JDLINGYU,
                Net.JDLINGYU_BASE, "http://www.jdlingyu.mobi/wp-content/uploads/2017/01/2017-01-07_20-57-14.png", null));
        menu.add(new MenuBean(Menus.MENU_JDLINGYU_SIFANG_ZIPAI_ID, Menus.MENU_JDLINGYU,
                Net.JDLINGYU_BASE, "http://www.jdlingyu.mobi/wp-content/uploads/2017/01/2017-01-07_20-57-14.png", null));
        menu.add(new MenuBean(Menus.MENU_JDLINGYU_GCTT_RBXZ_ID, Menus.MENU_JDLINGYU,
                Net.JDLINGYU_BASE, "http://www.jdlingyu.mobi/wp-content/uploads/2017/01/2017-01-07_20-57-14.png", null));
        menu.add(new MenuBean(Menus.MENU_MEITUMEN_MENU_ID, Menus.MENU_MEITUMEN,
                Net.MEITUMEN_BASE, "https://f.meitumen.com/wp-content/uploads/2019/07/71a19774130be40.png", null));
        menu.add(new MenuBean(Menus.MENU_MEITUMEN_TAG_ID, Menus.MENU_MEITUMEN,
                Net.MEITUMEN_BASE, "https://f.meitumen.com/wp-content/uploads/2019/07/71a19774130be40.png", null));
        menu.add(new MenuBean(Menus.MENU_MZITU_ID, Menus.MENU_MZITU,
                Net.MZITU_BASE, "https://ws1.sinaimg.cn/large/610dc034gy1fi678xgq1ij20pa0vlgo4.jpg", null));
        menu.add(new MenuBean(Menus.MENU_MMONLY_ID, Menus.MENU_MMONLY,
                Net.MMONLY_BASE, "http://www.mmonly.cc/skins/images/mmonly1.png", null));
        menu.add(new MenuBean(Menus.MENU_ROSIMM_ID, Menus.MENU_ROSIMM,
                Net.ROSIMM_BASE, "http://www.rosi6.cc/tob/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_MM131_ID, Menus.MENU_MM131,
                Net.WWWMM131NET_BASE, "https://img.yeitu.com/2017/0701/20170701045011585.jpg", null));
        menu.add(new MenuBean(Menus.MENU_CHINAGIRLOL_ID, Menus.MENU_CHINAGIRLOL,
                Net.CHINAGIRLOL_BASE, "http://www.chinagirlol.cc/template/bbf_cg/src/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_GIRLSKY_ID, Menus.MENU_GIRLSKY,
                Net.GIRLSKY_BASE, "http://www.girlsky.cn/statics/v1/images/logo4.png", null));
        menu.add(new MenuBean(Menus.MENU_MMCOOLS_ID, Menus.MENU_MMCOOLS,
                Net.MMCOOLS_BASE, "https://ws1.sinaimg.cn/large/610dc034ly1fitcjyruajj20u011h412.jpg", null));
        menu.add(new MenuBean(Menus.MENU_YEITU_ID, Menus.MENU_YEITU,
                Net.YEITU_BASE, "https://www.yeitu.com/statics/images/yeitu/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_GIRL_ATLAS_ID, Menus.MENU_GIRL_ATLAS,
                Net.GIRL_ATLAS_BASE, "http://static.meinvjpg.com/static/img/logo@2x.png", null));
        menu.add(new MenuBean(Menus.MENU_UMEI_ID, Menus.MENU_UMEI,
                Net.UMEI, "http://www.umei.cc/images/logo4.png", null));
        menu.add(new MenuBean(Menus.MENU_XSNVSHEN_MEINV_ID, Menus.MENU_XSNVSHEN,
                Net.XSNVSHEN_BASE, "https://res.xsnvshen.com/images/logo_girl.png", null));
        menu.add(new MenuBean(Menus.MENU_XSNVSHEN_NVSHEN_ID, Menus.MENU_XSNVSHEN,
                Net.XSNVSHEN_BASE, "https://res.xsnvshen.com/images/logo_girl.png", null));
        menu.add(new MenuBean(Menus.MENU_XSNVSHEN_HDTU_ID, Menus.MENU_XSNVSHEN,
                Net.XSNVSHEN_BASE, "https://res.xsnvshen.com/images/logo_girl.png", null));
        menu.add(new MenuBean(Menus.MENU_NCJLH_ID, Menus.MENU_NCJLH,
                Net.NCJLH_BASE, "http://www.ncjlh.com/templets/default/images/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_MM8MM88_ID, Menus.MENU_MM8MM88,
                Net.MM8MM88_BASE, "http://www.mm8mm88.com/static/sites/private/logos/mm8mm88.com.png?20180131", null));
        menu.add(new MenuBean(Menus.MENU_80ZU_ID, Menus.MENU_80ZU,
                Net.ZU80_BASE, "http://www.80zu.com/wp-content/uploads/2019/03/logo-1.png", null));
        menu.add(new MenuBean(Menus.MENU_MMJPG_ID, Menus.MENU_MMJPG,
                Net.MMJPG_BASE, "http://img.mmjpg.com/2015/295/1.jpg", null));
        menu.add(new MenuBean(Menus.MENU_ITUBA_ID, Menus.MENU_ITUBA,
                Net.ITUBA_BASE, "http://www.zdt8.com/style/logo/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_YULEBA_ID, Menus.MENU_YULEBA,
                Net.YULEBA_BASE, "http://www.zdt8.com/style/logo/logo.png", null));
        menu.add(new MenuBean(Menus.MENU_GODDESS_ID, Menus.MENU_GODDESS,
                Net.GODDESS_BASE, "https://tw.kissgoddess.com/images/Goddness_logo-300x111.png", null));
        if (!OtherConfig.getR(aContext)) {
            menu.add(new MenuBean(Menus.MENU_XIUREN_ID, Menus.MENU_XIUREN,
                    Net.XIUREN_BASE, "http://www.xiuren.org/logo.png", null));
            menu.add(new MenuBean(Menus.MENU_GRAVUREGIRLZ_ID, Menus.MENU_GRAVUREGIRLZ,
                    Net.GRAVUREGIRLZ_BASE, "https://i0.wp.com/www.gravuregirlz.com/wp-content/uploads/2015/10/145422/gg.png", null));
        }
        return menu;
    }
}
