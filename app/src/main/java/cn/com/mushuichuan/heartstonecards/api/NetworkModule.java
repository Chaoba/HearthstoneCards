package cn.com.mushuichuan.heartstonecards.api;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.com.mushuichuan.heartstonecards.BuildConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class NetworkModule {
    @Provides
    @NonNull
    @Singleton
    public OkHttpClient provideOkHttpClient() {

        OkHttpClient okHttpClient = new OkHttpClient();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient newClient = okHttpClient.newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        return newClient;
    }
}
