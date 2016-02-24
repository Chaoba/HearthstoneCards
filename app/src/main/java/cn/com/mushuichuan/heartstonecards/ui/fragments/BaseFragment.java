package cn.com.mushuichuan.heartstonecards.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import cn.com.mushuichuan.heartstonecards.MainApp;
import cn.com.mushuichuan.heartstonecards.mvp.IView;
import cn.com.mushuichuan.heartstonecards.mvp.Presenter;
import cn.com.mushuichuan.heartstonecards.mvp.model.BaseCard;
import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.mvp.model.Info;
import cn.com.mushuichuan.heartstonecards.util.CLogger;

/**
 * Created by Liyanshun on 2016/2/23.
 */
public class BaseFragment extends Fragment implements IView {
    public static final String MENU_KEY = "MENU_KEY";
    public static final String ARGU_KEY = "ARGU_KEY";
    public static final int KEY_CLASSES = 0;
    public static final int KEY_SETS = 1;
    public static final int KEY_TYPES = 2;
    public static final int KEY_FACTIONS = 3;
    public static final int KEY_QUALITIES = 4;
    public static final int KEY_RACES = 5;
    protected int menuType = KEY_CLASSES;
    protected String argu;

    @Inject
    protected Presenter mPresenter;
    @Inject
    protected Picasso picasso;
    protected ProgressBar mProgressBar;
    protected RecyclerView mMainRecycler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApp) getActivity().getApplication()).getmAppComponent().inject(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            menuType = arguments.getInt(MENU_KEY);
            argu = arguments.getString(ARGU_KEY);
            CLogger.i("menutype:" + menuType);
            CLogger.i("argu:" + argu);
        }
        mPresenter.setmView(this);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onUpdate(BaseCard card) {

    }

    @Override
    public void onUpdate(List<Card> card) {

    }

    @Override
    public void onUpdate(Info info) {

    }


    @Override
    public void showProgress() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }
}
