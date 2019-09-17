package f.star.iota.milk.ui.yeitu.yei;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class YeiTuAdapter extends BaseAdapter<YeiTuViewHolder, YeiTuBean> {

    @Override
    public YeiTuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YeiTuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YeiTuViewHolder) holder).bindView(mBeans.get(position));
    }
}
