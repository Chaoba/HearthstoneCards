package cn.com.mushuichuan.heartstonecards.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.mushuichuan.heartstonecards.MainApp;
import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.api.IApi;
import cn.com.mushuichuan.heartstonecards.mvp.Info;
import cn.com.mushuichuan.heartstonecards.util.CLogger;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    IApi mIApi;

    @OnClick(R.id.text)
    void onclick() {
        CLogger.i("onclick");
        Observable<Info> info = mIApi.getInfo();
        info.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Info>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        CLogger.e(e);
                    }

                    @Override
                    public void onNext(Info info) {
                        CLogger.i(info.patch);
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MainApp) getApplication()).getmAppComponent().inject(this);

    }
}
