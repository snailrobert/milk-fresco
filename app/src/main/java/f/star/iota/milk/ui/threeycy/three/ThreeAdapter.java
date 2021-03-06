package f.star.iota.milk.ui.threeycy.three;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ThreeAdapter extends BaseAdapter<ThreeViewHolder, ThreeBean> {

    @Override
    public ThreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThreeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ThreeViewHolder) holder).bindView(mBeans);
    }
}
