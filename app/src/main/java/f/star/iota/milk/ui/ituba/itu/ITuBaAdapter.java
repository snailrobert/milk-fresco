package f.star.iota.milk.ui.ituba.itu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ITuBaAdapter extends BaseAdapter<ITuBaViewHolder, ITuBaBean> {

    @Override
    public ITuBaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ITuBaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ITuBaViewHolder) holder).bindView(mBeans.get(position));
    }
}
