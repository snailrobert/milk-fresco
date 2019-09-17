package f.star.iota.milk.ui.mmcools.cools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class MMCOOLSAdapter extends BaseAdapter<MMCOOLSViewHolder, MMCOOLSZiBean> {

    @Override
    public MMCOOLSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MMCOOLSViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MMCOOLSViewHolder) holder).bindView(mBeans.get(position));
    }
}
