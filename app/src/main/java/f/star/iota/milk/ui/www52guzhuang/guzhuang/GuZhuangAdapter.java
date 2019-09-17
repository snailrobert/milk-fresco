package f.star.iota.milk.ui.www52guzhuang.guzhuang;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class GuZhuangAdapter extends BaseAdapter<GuZhuangViewHolder, GuZhuangBean> {

    @Override
    public GuZhuangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GuZhuangViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GuZhuangViewHolder) holder).bindView(mBeans.get(position));
    }
}
