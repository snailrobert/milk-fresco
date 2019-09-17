package f.star.iota.milk.ui.rosimm.rosi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ROSIMMAdapter extends BaseAdapter<ROSIMMViewHolder, ROSIMMBean> {

    @Override
    public ROSIMMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ROSIMMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ROSIMMViewHolder) holder).bindView(mBeans.get(position));
    }
}
