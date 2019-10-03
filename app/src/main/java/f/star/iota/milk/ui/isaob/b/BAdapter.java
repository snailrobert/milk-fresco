package f.star.iota.milk.ui.isaob.b;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class BAdapter extends BaseAdapter<BViewHolder, BBean> {

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BViewHolder) holder).bindView(mBeans);
    }
}
