package cn.com.mushuichuan.heartstonecards.ui.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.ui.adapters.RecyclerViewClickListener;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class FragmentMainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView nameTextView;
    private RecyclerViewClickListener mListener;

    public FragmentMainViewHolder(View view, RecyclerViewClickListener listener) {
        super(view);
        mListener = listener;
        nameTextView = (TextView) view.findViewById(R.id.name);
        view.setOnClickListener(this);
    }


    public void bindItem(String s) {
        nameTextView.setText(s);
    }

    @Override
    public void onClick(View v) {
        mListener.onClick(v, getAdapterPosition());
    }
}
