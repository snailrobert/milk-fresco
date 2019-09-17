package f.star.iota.milk.ui.zu80.zu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ZU80Adapter extends BaseAdapter<ZU80ViewHolder, ZU80Bean> {

    @Override
    public ZU80ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZU80ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ZU80ViewHolder) holder).bindView(mBeans.get(position));
    }
}
