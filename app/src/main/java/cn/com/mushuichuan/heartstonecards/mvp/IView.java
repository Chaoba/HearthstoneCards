package cn.com.mushuichuan.heartstonecards.mvp;

import java.util.List;

import cn.com.mushuichuan.heartstonecards.mvp.model.BaseCard;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.mvp.model.Info;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public interface IView {
    public void onComplete();

    public void onError(String error);

    public void onUpdate(BaseCard card);

    public void onUpdate(List<Card> card);

    public void onUpdate(Info info);

    public void showProgress();

    public void hideProgress();
}
