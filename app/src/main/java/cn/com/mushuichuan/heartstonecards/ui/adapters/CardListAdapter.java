package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

/**
 * Created by Liyanshun on 2016/2/22.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListViewHolder> {
    private final Picasso picasso;
    private final LayoutInflater layoutInflater;
    private final RecylcerViewClickListener mListener;
    private List<Card> items = emptyList();

    @Inject
    public CardListAdapter(Picasso picasso, LayoutInflater layoutInflater, RecylcerViewClickListener mListener) {
        this.picasso = picasso;
        this.layoutInflater = layoutInflater;
        this.mListener = mListener;
    }

    public void setData(List<Card> items) {
        this.items = unmodifiableList(items);
        notifyDataSetChanged();
    }

    @Override
    public CardListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardListViewHolder(layoutInflater.inflate(R.layout.card_list_item, null), picasso, mListener);
    }

    @Override
    public void onBindViewHolder(CardListViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public String getCardName(int poistion) {
        Card card = items.get(poistion);
        if (card != null) {
            return card.name;
        }
        return null;
    }
}
