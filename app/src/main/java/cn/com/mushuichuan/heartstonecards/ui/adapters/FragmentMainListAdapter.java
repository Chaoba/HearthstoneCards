package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.ui.adapters.viewholder.FragmentMainViewHolder;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

/**
 * Created by Liyanshun on 2016/2/22.
 */
public class FragmentMainListAdapter extends RecyclerView.Adapter<FragmentMainViewHolder> {
    private final LayoutInflater layoutInflater;
    private List<String> items = emptyList();
    private RecyclerViewClickListener mListener;

    @Inject
    public FragmentMainListAdapter(LayoutInflater layoutInflater, RecyclerViewClickListener mListener) {
        this.layoutInflater = layoutInflater;
        this.mListener = mListener;
    }

    public void setData(List<String> items) {
        this.items = unmodifiableList(items);
        notifyDataSetChanged();
    }

    @Override
    public FragmentMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FragmentMainViewHolder(layoutInflater.inflate(R.layout.fragment_list_item, parent, false), mListener);
    }

    @Override
    public void onBindViewHolder(FragmentMainViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public String getItem(int position) {
        return items.get(position);
    }
}
