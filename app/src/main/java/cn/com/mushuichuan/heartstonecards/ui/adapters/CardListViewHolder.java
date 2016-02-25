package cn.com.mushuichuan.heartstonecards.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
    private TextView nameTextView, mRace, mFaction, mRarity, mMenutype;
    private ImageView classImg;
    private final Picasso picasso;

    public CardListViewHolder(View view, Picasso picasso) {
        super(view);
        this.picasso = picasso;
        mMenutype = (TextView) view.findViewById(R.id.menuType);
        nameTextView = (TextView) view.findViewById(R.id.name);
        mRace = (TextView) view.findViewById(R.id.race);
        mFaction = (TextView) view.findViewById(R.id.faction);
        mRarity = (TextView) view.findViewById(R.id.rarity);
        classImg = (ImageView) view.findViewById(R.id.card_img);
    }


    public void bindItem(Card card) {
        if (!TextUtils.isEmpty(card.menuType)) {
            mMenutype.setText(card.menuType);
        }
        if (!TextUtils.isEmpty(card.name)) {
            nameTextView.setText(card.name);
        }
        if (!TextUtils.isEmpty(card.faction)) {
            mFaction.setText(card.faction);
        }
        if (!TextUtils.isEmpty(card.race)) {
            mRace.setText(card.race);
        }
        if (!TextUtils.isEmpty(card.rarity)) {
            mRarity.setText(card.rarity);
        }
        picasso.load(card.img).fit().placeholder(R.mipmap.card_back_default).centerInside().into(classImg);
    }
}
