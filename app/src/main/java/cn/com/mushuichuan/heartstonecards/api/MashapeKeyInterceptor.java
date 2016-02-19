package cn.com.mushuichuan.heartstonecards.api;


import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class MashapeKeyInterceptor implements Interceptor {
    @Inject
    public MashapeKeyInterceptor() {
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        Request newRequest = builder.addHeader("X-Mashape-Key", "U4y8yvgRDUmshqUkNb1LJxmsRCBap1WWG0wjsnUj07GxYfsKUI")
                .addHeader("Accept", "application/json")
                .build();
        return chain.proceed(newRequest);
    }
}
