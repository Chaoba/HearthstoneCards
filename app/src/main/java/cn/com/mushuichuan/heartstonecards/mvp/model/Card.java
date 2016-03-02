package cn.com.mushuichuan.heartstonecards.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Liyanshun on 2016/2/18.
 * example:{
 * "cardId": "NEW1_023",
 * "name": "Faerie Dragon",
 * "cardSet": "Classic",
 * "menuType": "Minion",
 * "rarity": "Common",
 * "cost": 2,
 * "attack": 3,
 * "health": 2,
 * "text": "Can't be targeted by spells or Hero Powers.",
 * "flavor": "Adorable.  Immune to Magic.  Doesn't pee on the rug.  The perfect pet!",
 * "artist": "Samwise",
 * "collectible": true,
 * "race": "Dragon",
 * "img": "http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_023.png",
 * "imgGold": "http://wow.zamimg.com/images/hearthstone/cards/enus/animated/NEW1_023_premium.gif",
 * "locale": "enUS"
 * },
 */
public class Card extends BaseCard implements Parcelable{
    public String cardSet;
    public String faction;
    public String rarity;
    public String type;
    public String health;
    public String imgGold;
    public String collectible;
    public String playerClass;
    public String cost;
    public String attack;
    public String text;
    public String flavor;
    public String artist;
    public String race;
    public String howToGet;
    public String howToGetGold;
    public List<BaseCard> mechanics;
    public String menuType;

    protected Card(Parcel in) {
        cardId = in.readString();
        name = in.readString();
        img = in.readString();
        locale = in.readString();
        cardSet = in.readString();
        faction = in.readString();
        rarity = in.readString();
        type = in.readString();
        health = in.readString();
        imgGold = in.readString();
        collectible = in.readString();
        playerClass = in.readString();
        cost = in.readString();
        attack = in.readString();
        text = in.readString();
        flavor = in.readString();
        artist = in.readString();
        race = in.readString();
        howToGet = in.readString();
        howToGetGold = in.readString();
        menuType = in.readString();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cardId);
        dest.writeString(name);
        dest.writeString(img);
        dest.writeString(locale);
        dest.writeString(cardSet);
        dest.writeString(faction);
        dest.writeString(rarity);
        dest.writeString(type);
        dest.writeString(health);
        dest.writeString(imgGold);
        dest.writeString(collectible);
        dest.writeString(playerClass);
        dest.writeString(cost);
        dest.writeString(attack);
        dest.writeString(text);
        dest.writeString(flavor);
        dest.writeString(artist);
        dest.writeString(race);
        dest.writeString(howToGet);
        dest.writeString(howToGetGold);
        dest.writeString(menuType);
    }
}
