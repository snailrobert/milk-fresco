package f.star.iota.milk.ui.itmtu.mtu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class MtuAdapter extends BaseAdapter<MtuViewHolder, MtuBean> {

    @Override
    public MtuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MtuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MtuViewHolder) holder).bindView(mBeans);
    }
}
