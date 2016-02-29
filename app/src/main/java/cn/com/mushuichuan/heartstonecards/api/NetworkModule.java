package cn.com.mushuichuan.heartstonecards.api;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.com.mushuichuan.heartstonecards.BuildConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

@Module
public class NetworkModule {
    @Provides
    @NonNull
    @Singleton
    public OkHttpClient provideOkHttpClient(MashapeKeyInterceptor mashapeKeyInterceptor) {

        OkHttpClient okHttpClient = new OkHttpClient();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? BODY : NONE);

        OkHttpClient newClient = okHttpClient.newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(mashapeKeyInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        return newClient;
    }
}
