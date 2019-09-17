package f.star.iota.milk.ui.meitulu.lu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class LuAdapter extends BaseAdapter<LuViewHolder, LuBean> {

    @Override
    public LuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((LuViewHolder) holder).bindView(mBeans);
    }
}
