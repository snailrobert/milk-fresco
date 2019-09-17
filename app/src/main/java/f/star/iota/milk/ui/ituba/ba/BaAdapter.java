package f.star.iota.milk.ui.ituba.ba;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class BaAdapter extends BaseAdapter<BaViewHolder, BaBean> {

    @Override
    public BaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaViewHolder) holder).bindView(mBeans);
    }
}
