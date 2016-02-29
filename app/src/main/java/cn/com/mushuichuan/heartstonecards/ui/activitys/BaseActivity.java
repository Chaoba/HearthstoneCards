package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class BaseActivity extends AppCompatActivity implements IView {
    @Inject
    protected Presenter mPresenter;
    @Inject
    protected Picasso picasso;
    @Inject
    Context mContext;
    protected ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApp) getApplication()).getmAppComponent().inject(this);
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
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
