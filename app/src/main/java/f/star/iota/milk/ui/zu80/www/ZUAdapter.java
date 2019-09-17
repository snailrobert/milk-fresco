package f.star.iota.milk.ui.zu80.www;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ZUAdapter extends BaseAdapter<ZUViewHolder, ZUBean> {

    @Override
    public ZUViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZUViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ZUViewHolder) holder).bindView(mBeans);
    }
}
