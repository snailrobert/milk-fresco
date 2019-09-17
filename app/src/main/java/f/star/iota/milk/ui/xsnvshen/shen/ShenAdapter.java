package f.star.iota.milk.ui.xsnvshen.shen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ShenAdapter extends BaseAdapter<ShenViewHolder, ShenBean> {

    @Override
    public ShenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ShenViewHolder) holder).bindView(mBeans);
    }
}
