package f.star.iota.milk.ui.lingyu.ling;


import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseActivity;
import f.star.iota.milk.base.BaseViewHolder;
import f.star.iota.milk.ui.lingyu.yu.YuFragment;


public class LingYuViewHolder extends BaseViewHolder<LingYuBean> {

    @BindView(R.id.simple_drawee_view_image)
    SimpleDraweeView mSimpleDraweeView;
    @BindView(R.id.text_view_tag)
    TextView mTextViewTag;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;

    public LingYuViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final LingYuBean bean) {
        if (bean.getUrl() != null) {
            Uri uri = Uri.parse(bean.getPreview());
            if (uri != null) {
                mSimpleDraweeView.setImageURI(uri);
            }
        }
        mSimpleDraweeView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("从浏览器打开")
                        .setNegativeButton("嗯", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                open(bean.getUrl());
                            }
                        })
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                return true;
            }
        });
        mSimpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) mContext).addFragment(YuFragment.newInstance(bean.getUrl()));
            }
        });
        mTextViewTag.setText(bean.getDate());
        mTextViewDescription.setText(bean.getDescription());
    }
}