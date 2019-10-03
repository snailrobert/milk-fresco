package f.star.iota.milk.ui.meinvyh.mzi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class MeiNvAdapter extends BaseAdapter<MeiNvViewHolder, MeiNvBean> {

    @Override
    public MeiNvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiNvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MeiNvViewHolder) holder).bindView(mBeans.get(position));
    }
}
