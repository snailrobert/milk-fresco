package f.star.iota.milk.ui.gkdgif.gkd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class GkdGifAdapter extends BaseAdapter<GkdGifViewHolder, GkdGifBean> {

    @Override
    public GkdGifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GkdGifViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GkdGifViewHolder) holder).bindView(mBeans.get(position));
    }
}
