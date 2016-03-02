package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.com.mushuichuan.heartstonecards.R;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class FragmentMainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView nameTextView;
    private RecylcerViewClickListener mListener;

    public FragmentMainViewHolder(View view, RecylcerViewClickListener listener) {
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
