package cn.com.mushuichuan.heartstonecards.mvp;

import java.util.List;

import javax.inject.Inject;

import cn.com.mushuichuan.heartstonecards.api.IApi;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.mvp.model.CardBack;
import cn.com.mushuichuan.heartstonecards.mvp.model.Info;
import cn.com.mushuichuan.heartstonecards.util.CLogger;
import cn.com.mushuichuan.heartstonecards.util.Util;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class Presenter {
    private IView mView;
    private Info mInfo;
    @Inject
    IApi mIApi;

    @Inject
    public Presenter() {
    }

    public void setmView(IView mView) {
        this.mView = mView;
    }

    public void getInfo() {
        Observable<Info> observable = mIApi.getInfo();
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<Info>() {
                    @Override
                    public void onNext(Info info) {
                        mInfo = info;
                    }
                });
    }

    public void getAllCards() {
        Observable<List<Card>> observable = mIApi.getAllCards(getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardBacks() {
        Observable<List<CardBack>> observable = mIApi.getCardsBacks(getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<CardBack>>() {
                    @Override
                    public void onNext(List<CardBack> cards) {

                    }
                });
    }

    public void searchCard(String name) {
        Observable<List<Card>> observable = mIApi.searchCards(name, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardSet(String set) {
        Observable<List<Card>> observable = mIApi.getCardSet(set, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardByClass(String classes) {
        Observable<List<Card>> observable = mIApi.getCardsByClass(classes, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardByFaction(String faction) {
        Observable<List<Card>> observable = mIApi.getCardByFaction(faction, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardByQuality(String quality) {
        Observable<List<Card>> observable = mIApi.getCardByQuality(quality, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardByRace(String Race) {
        Observable<List<Card>> observable = mIApi.getCardByRace(Race, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getCardByType(String type) {
        Observable<List<Card>> observable = mIApi.getCardByType(type, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {

                    }
                });
    }

    public void getSingleCard(String name) {
        Observable<Card> observable = mIApi.getSingleCard(name, getLocal());
        observable.subscribeOn(Schedulers.io())
                .subscribe(new SelfDefineSubscriber<Card>() {
                    @Override
                    public void onNext(Card cards) {

                    }
                });
    }

    private String getLocal() {
        if (mInfo != null && mInfo.locales != null) {
            String local = Util.getCurrentLauguage();
            for (String s : mInfo.locales) {
                if (s.contains(local)) {
                    return s;
                }
            }
        }

        return "enUS";
    }

    class SelfDefineSubscriber<T> extends Subscriber<T> {
        @Override
        public void onCompleted() {
            mView.onComplete();
        }

        @Override
        public void onError(Throwable e) {
            CLogger.e(e);
            mView.onError(e.getMessage());
        }

        @Override
        public void onNext(T t) {

        }
    }

}
