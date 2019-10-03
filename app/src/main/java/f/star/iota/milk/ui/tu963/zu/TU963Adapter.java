package f.star.iota.milk.ui.tu963.zu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class TU963Adapter extends BaseAdapter<TU963ViewHolder, TU963Bean> {

    @Override
    public TU963ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TU963ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TU963ViewHolder) holder).bindView(mBeans.get(position));
    }
}
