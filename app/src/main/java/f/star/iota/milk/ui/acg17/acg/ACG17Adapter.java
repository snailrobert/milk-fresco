package f.star.iota.milk.ui.acg17.acg;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ACG17Adapter extends BaseAdapter<ACG17ViewHolder, ACG17Bean> {

    @Override
    public ACG17ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ACG17ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ACG17ViewHolder) holder).bindView(mBeans.get(position));
    }
}
