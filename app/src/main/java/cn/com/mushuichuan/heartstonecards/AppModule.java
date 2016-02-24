package cn.com.mushuichuan.heartstonecards;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Liyanshun on 2016/2/17.
 */
@Module
public class AppModule {
    private final MainApp mainApp;
    private final Context mContext;

    public AppModule(MainApp mainApp, Context mContext) {
        this.mainApp = mainApp;
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    public MainApp getMainApp() {
        return mainApp;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public Picasso providePicasso(Context context) {
        return new Picasso.Builder(context)
                .downloader(new OkHttpDownloader(new OkHttpClient()))
                .loggingEnabled(BuildConfig.DEBUG)
                .build();
    }
}
