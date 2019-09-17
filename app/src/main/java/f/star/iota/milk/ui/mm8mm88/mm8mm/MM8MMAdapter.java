package f.star.iota.milk.ui.mm8mm88.mm8mm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class MM8MMAdapter extends BaseAdapter<MM8MMViewHolder, MM8MMBean> {

    @Override
    public MM8MMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MM8MMViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MM8MMViewHolder) holder).bindView(mBeans.get(position));
    }
}
