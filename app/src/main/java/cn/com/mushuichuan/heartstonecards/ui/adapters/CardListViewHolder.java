package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;

/**
 * Created by Liyanshun on 2016/2/19.
 * {
 * "cardId": "HERO_01",
 * "name": "加尔鲁什·地狱咆哮",
 * "cardSet": "Basic",
 * "menuType": "Hero",
 * "faction": "Neutral",
 * "rarity": "Free",
 * "health": 30,
 * "collectible": true,
 * "playerClass": "Warrior",
 * "img": "http://wow.zamimg.com/images/hearthstone/cards/zhcn/original/HERO_01.png",
 * "imgGold": "http://wow.zamimg.com/images/hearthstone/cards/zhcn/animated/HERO_01_premium.gif",
 * "locale": "zhCN"
 * },
 */
public class CardListViewHolder extends RecyclerView.ViewHolder {
    private TextView classNameTextView;
    private TextView nameTextView;
    private ImageView classImg;
    private final Picasso picasso;

    public CardListViewHolder(View view, Picasso picasso) {
        super(view);
        this.picasso = picasso;
        classNameTextView = (TextView) view.findViewById(R.id.class_name);
        nameTextView = (TextView) view.findViewById(R.id.name);
        classImg = (ImageView) view.findViewById(R.id.class_img);
    }


    public void bindItem(Card card) {
        classNameTextView.setText(card.playerClass);
        nameTextView.setText(card.name);
        picasso.load(card.img).fit().placeholder(R.mipmap.card_back_default).centerCrop().into(classImg);
    }
}
