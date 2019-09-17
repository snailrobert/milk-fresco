package f.star.iota.milk.ui.wwwmm131net.www;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import f.star.iota.milk.R;
import f.star.iota.milk.base.BaseAdapter;


public class WWWMM131NETAdapter extends BaseAdapter<WWWMM131NETViewHolder, WWWMM131NETBean> {

    @Override
    public WWWMM131NETViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WWWMM131NETViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_description_with_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((WWWMM131NETViewHolder) holder).bindView(mBeans.get(position));
    }
}
