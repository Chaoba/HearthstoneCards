package cn.com.mushuichuan.heartstonecards.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Liyanshun on 2016/2/17.
 */
@Module
public class ApiModule {
    private static final String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com";

    @Provides
    @Singleton
    public IApi getCardsApi(OkHttpClient client) {

        Retrofit CardsApiAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return CardsApiAdapter.create(IApi.class);
    }
}
