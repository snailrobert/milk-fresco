package f.star.iota.milk.ui.meitumen.men;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class MenAdapter extends BaseAdapter<MenViewHolder, MenBean> {

    @Override
    public MenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MenViewHolder) holder).bindView(mBeans);
    }
}
