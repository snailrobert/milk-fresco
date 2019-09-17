package f.star.iota.milk.ui.kissgoddess.kiss;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class KissAdapter extends BaseAdapter<KissViewHolder, KissBean> {

    @Override
    public KissViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new KissViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((KissViewHolder) holder).bindView(mBeans);
    }
}
