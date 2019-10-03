package f.star.iota.milk.ui.threeycy.ycy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ThreeYCYAdapter extends BaseAdapter<ThreeYCYViewHolder, ThreeYCYBean> {

    @Override
    public ThreeYCYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThreeYCYViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ThreeYCYViewHolder) holder).bindView(mBeans.get(position));
    }
}
