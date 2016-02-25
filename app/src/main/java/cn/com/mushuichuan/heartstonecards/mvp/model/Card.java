package cn.com.mushuichuan.heartstonecards.mvp.model;

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
public class Card extends BaseCard {
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
    public List<BaseCard> mechanics;
    public String menuType;
}
