package f.star.iota.milk.ui.wwwmm131net.www;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

import butterknife.BindView;
import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseActivity;
import f.star.iota.milk.base.BaseViewHolder;
import f.star.iota.milk.fresco.FrescoLoader;
import f.star.iota.milk.ui.wwwmm131net.mm.MMFragment;


public class WWWMM131NETViewHolder extends BaseViewHolder<WWWMM131NETBean> {

    @BindView(R.id.simple_drawee_view_image)
    SimpleDraweeView mSimpleDraweeView;
    @BindView(R.id.text_view_tag)
    TextView mTextViewTag;
    @BindView(R.id.text_view_description)
    TextView mTextViewDescription;
    @BindView(R.id.card_view)
    CardView mCardView;

    public WWWMM131NETViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindView(final WWWMM131NETBean bean) {
        HashMap<String, String> headers = bean.getHeaders();
        headers.put("Accept", "image/webp,image/*,*/*;q=0.8");
        headers.put("Host", "img1.mmmw.net");
        // if(headers.get("Referer").endsWith("/")){
        //     // HashMap<String, String> map = new HashMap<>();
        //     // map.put("User-Agent",headers.get("User-Agent"));
        //     // map.put("Referer","https://www.mm131.net/xinggan/list_6_3.html");
        //     // map.put("Host", "img1.mmmw.net");
        //     // headers = map;
        //     headers.put("Referer","https://www.mm131.net/xinggan/list_6_3.html");
        // }
        // headers.put("Referer", "http://www.mmjpg.com/");
        FrescoLoader.load(mSimpleDraweeView, bean.getPreview(),headers);
        mCardView.setOnLongClickListener(new View.OnLongClickListener() {
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
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) mContext).addFragment(MMFragment.newInstance(bean.getUrl().replace(".html", "_")));
            }
        });
        mTextViewTag.setText(bean.getDate());
        mTextViewDescription.setText(bean.getDescription());
    }
}
