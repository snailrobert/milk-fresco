package f.star.iota.milk.ui.xiuren.ren;


import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import f.star.iota.milk.Contracts;
import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseViewHolder;
import f.star.iota.milk.base.ShowImageBean;

public class RenViewHolder extends BaseViewHolder<RenBean> {

    @BindView(R.id.simple_drawee_view_image)
    SimpleDraweeView mSimpleDraweeView;

    public RenViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final List<RenBean> beans) {
        final RenBean bean = beans.get(getAdapterPosition());
        if (bean.getUrl() != null) {
            Uri uri = Uri.parse(bean.getUrl());
            if (uri != null) {
                mSimpleDraweeView.setImageURI(uri);
            }
        }
        mSimpleDraweeView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("是否下载")
                        .setNeutralButton("复制地址", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                copy(bean.getUrl());
                            }
                        })
                        .setNegativeButton("浏览器打开", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getUrl());
                            }
                        })
                        .setPositiveButton("下载", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                download(bean.getUrl(), bean.getUrl(),
                                        Contracts.Menu.MENU_XIUREN, null);
                            }
                        })
                        .show();
                return true;
            }
        });
        mSimpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ShowImageBean> imgs = new ArrayList<>();
                for (RenBean bean : beans) {
                    imgs.add(new ShowImageBean(bean.getUrl(), bean.getUrl(), Contracts.Menu.MENU_XIUREN,
                            "下载地址：" + bean.getUrl()));
                }
                show(imgs);
            }
        });
    }
}