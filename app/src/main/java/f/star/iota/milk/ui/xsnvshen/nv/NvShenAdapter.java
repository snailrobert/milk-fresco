package f.star.iota.milk.ui.xsnvshen.nv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class NvShenAdapter extends BaseAdapter<NvShenViewHolder, NvShenBean> {

    @Override
    public NvShenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NvShenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NvShenViewHolder) holder).bindView(mBeans.get(position));
    }
}
