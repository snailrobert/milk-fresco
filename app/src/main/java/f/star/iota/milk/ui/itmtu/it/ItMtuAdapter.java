package f.star.iota.milk.ui.itmtu.it;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ItMtuAdapter extends BaseAdapter<ItMtuViewHolder, ItMtuBean> {

    @Override
    public ItMtuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItMtuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItMtuViewHolder) holder).bindView(mBeans.get(position));
    }
}
