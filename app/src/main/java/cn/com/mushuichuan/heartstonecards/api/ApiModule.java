package cn.com.mushuichuan.heartstonecards.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Singleton;

import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<Card>>() {}.getType(), new CardsDeserializer())
                .create();

        Retrofit CardsApiAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        return CardsApiAdapter.create(IApi.class);
    }
}
