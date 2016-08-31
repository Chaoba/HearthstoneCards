package cn.com.mushuichuan.heartstonecards.mvp.model;

/**
 * Created by Liyanshun on 2016/2/19.
 * {
 * "cardBackId": "0",
 * "name": "Classic",
 * "description": "The only card back you’ll ever need.",
 * "source": "startup",
 * "sourceDescription": "Default",
 * "enabled": true,
 * "img": "http://wow.zamimg.com/images/hearthstone/backs/original/Card_Back_Default.png",
 * "imgAnimated": "http://wow.zamimg.com/images/hearthstone/backs/animated/Card_Back_Default.gif",
 * "sortCategory": "1",
 * "sortOrder": "1",
 * "locale": "enUS"
 * },
 */
public class Cardback extends BaseCard {
    public String cardBackId;
    public String name;
    public String description;
    public String source;
    public String sourceDescription;
    public String enabled;
    public String imgAnimated;
    public String sortCategory;
    public String sortOrder;
}
