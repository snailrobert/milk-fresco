package f.star.iota.milk.ui.meinvyh.yh;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class YHAdapter extends BaseAdapter<YHViewHolder, YHBean> {

    @Override
    public YHViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YHViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YHViewHolder) holder).bindView(mBeans);
    }
}
