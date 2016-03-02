package cn.com.mushuichuan.heartstonecards.ui.adapters.viewholder;

import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import cn.com.mushuichuan.heartstonecards.R;
import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

/**
 * Created by Liyanshun on 2016/3/2.
 */
@LayoutId(R.layout.detail_list_item)
public class DetailViewHolder extends ItemViewHolder<Spanned> {
    @ViewId(R.id.detail_item)
    TextView itemView;

    public DetailViewHolder(View view) {
        super(view);
    }

    @Override
    public void onSetValues(Spanned item, PositionInfo positionInfo) {
        itemView.setText(item);
    }
}
