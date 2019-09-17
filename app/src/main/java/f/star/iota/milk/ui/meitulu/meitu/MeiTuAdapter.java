package f.star.iota.milk.ui.meitulu.meitu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class MeiTuAdapter extends BaseAdapter<MeiTuViewHolder, MeiTuBean> {

    @Override
    public MeiTuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiTuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MeiTuViewHolder) holder).bindView(mBeans.get(position));
    }
}
