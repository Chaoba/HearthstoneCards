package cn.com.mushuichuan.heartstonecards.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.mushuichuan.heartstonecards.MainApp;
import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.IView;
import cn.com.mushuichuan.heartstonecards.mvp.Presenter;

public class MainActivity extends AppCompatActivity implements IView{

    @Inject
    Presenter mPresenter;

    @OnClick(R.id.text)
    void onclick() {
        mPresenter.getInfo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MainApp) getApplication()).getmAppComponent().inject(this);
        mPresenter.setmView(this);
    }
}
