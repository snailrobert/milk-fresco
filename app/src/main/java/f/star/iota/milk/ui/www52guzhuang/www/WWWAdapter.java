package f.star.iota.milk.ui.www52guzhuang.www;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class WWWAdapter extends BaseAdapter<WWWViewHolder, WWWBean> {

    @Override
    public WWWViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WWWViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pure_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WWWViewHolder) holder).bindView(mBeans);
    }
}
