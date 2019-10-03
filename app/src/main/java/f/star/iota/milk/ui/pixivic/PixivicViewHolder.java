package f.star.iota.milk.ui.pixivic;


import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rubensousa.floatingtoolbar.FloatingToolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import f.star.iota.milk.Menus;
import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseViewHolder;
import f.star.iota.milk.base.PCBean;
import f.star.iota.milk.fresco.FrescoLoader;

public class PixivicViewHolder extends BaseViewHolder<PixivicBean.ResultsBean> {

    @BindView(R.id.simple_drawee_view_image)
    SimpleDraweeView mSimpleDraweeView;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;
    @BindView(R.id.card_view)
    CardView mCardView;

    public PixivicViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final List<PixivicBean.ResultsBean> beans) {
        final PixivicBean.ResultsBean bean = beans.get(getAdapterPosition());
        FrescoLoader.load(mSimpleDraweeView, bean.getImageUrls().get(0).getLarge());
        mCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("是否下载")
                        .setNeutralButton("复制地址", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                copy(bean.getImageUrls().get(0).getLarge());
                            }
                        })
                        .setNegativeButton("浏览器打开", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getImageUrls().get(0).getLarge());
                            }
                        })
                        .setPositiveButton("下载", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                download(bean.getImageUrls().get(0).getLarge(), bean.getImageUrls().get(0).getLarge(),
                                        Menus.MENU_PIXIVIC, null);
                            }
                        })
                        .show();
                return true;
            }
        });
        mTextViewDescription.setText(bean.getDesc());
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(getProcessingCompletedBeans(beans));
            }
        });
        ((FloatingToolbar) ButterKnife.findById((Activity) mContext, R.id.floating_toolbar)).setClickListener(new FloatingToolbar.ItemClickListener() {
            @Override
            public void onItemClick(MenuItem menuItem) {
                batchDownload(getProcessingCompletedBeans(beans));
            }

            @Override
            public void onItemLongClick(MenuItem menuItem) {

            }
        });
    }

    @Override
    protected List<PCBean> getProcessingCompletedBeans(List<PixivicBean.ResultsBean> beans) {
        List<PCBean> imgs = new ArrayList<>();
        for (PixivicBean.ResultsBean bean : beans) {
            imgs.add(new PCBean(bean.getImageUrls().get(0).getLarge(), bean.getImageUrls().get(0).getLarge(), Menus.MENU_PIXIVIC,
                    "描述：" + bean.getDesc() + "\n\n" +
                            "下载地址：" +bean.getImageUrls().get(0).getLarge()));
        }
        return imgs;
    }
}
