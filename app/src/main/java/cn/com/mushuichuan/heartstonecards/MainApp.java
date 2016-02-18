package cn.com.mushuichuan.heartstonecards;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import cn.com.mushuichuan.heartstonecards.api.ApiModule;
import cn.com.mushuichuan.heartstonecards.api.NetworkModule;

/**
 * Created by Liyanshun on 2016/2/17.
 */
public class MainApp extends Application {
    private Context mContext;

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initializeInjector();
        if (BuildConfig.DEBUG) {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                            .build());
        }
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, mContext))
                .networkModule(new NetworkModule())
                .apiModule(new ApiModule())
                .build();
        mAppComponent.inject(this);
    }
}
