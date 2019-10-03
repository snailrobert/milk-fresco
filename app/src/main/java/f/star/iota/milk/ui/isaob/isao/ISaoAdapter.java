package f.star.iota.milk.ui.isaob.isao;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ISaoAdapter extends BaseAdapter<ISaoViewHolder, ISaoBean> {

    @Override
    public ISaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ISaoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ISaoViewHolder) holder).bindView(mBeans.get(position));
    }
}
