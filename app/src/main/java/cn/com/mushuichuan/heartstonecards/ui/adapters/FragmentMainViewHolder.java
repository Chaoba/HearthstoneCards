package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.com.mushuichuan.heartstonecards.R;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class FragmentMainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView classNameTextView;
    private TextView nameTextView;
    private ImageView classImg;
    private RecylcerViewClickListener mListener;

    public FragmentMainViewHolder(View view, RecylcerViewClickListener listener) {
        super(view);
        mListener = listener;
        classNameTextView = (TextView) view.findViewById(R.id.class_name);
        nameTextView = (TextView) view.findViewById(R.id.name);
        classImg = (ImageView) view.findViewById(R.id.class_img);
        nameTextView.setVisibility(View.GONE);
        classImg.setVisibility(View.GONE);
        view.setOnClickListener(this);
    }


    public void bindItem(String s) {
        classNameTextView.setText(s);
    }

    @Override
    public void onClick(View v) {
        mListener.onClick(getAdapterPosition());
    }
}
