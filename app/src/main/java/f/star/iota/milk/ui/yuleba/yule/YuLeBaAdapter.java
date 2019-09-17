package f.star.iota.milk.ui.yuleba.yule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class YuLeBaAdapter extends BaseAdapter<YuLeBaViewHolder, YuLeBaBean> {

    @Override
    public YuLeBaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YuLeBaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YuLeBaViewHolder) holder).bindView(mBeans.get(position));
    }
}
