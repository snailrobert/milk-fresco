package f.star.iota.milk.ui.acg17.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class ACGAdapter extends BaseAdapter<ACGViewHolder, ACGBean> {

    @Override
    public ACGViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ACGViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ACGViewHolder) holder).bindView(mBeans);
    }
}
