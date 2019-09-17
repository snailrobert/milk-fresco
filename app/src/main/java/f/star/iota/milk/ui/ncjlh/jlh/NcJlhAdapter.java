package f.star.iota.milk.ui.ncjlh.jlh;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class NcJlhAdapter extends BaseAdapter<NcJlhViewHolder, NcJlhBean> {

    @Override
    public NcJlhViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NcJlhViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NcJlhViewHolder) holder).bindView(mBeans.get(position));
    }
}
