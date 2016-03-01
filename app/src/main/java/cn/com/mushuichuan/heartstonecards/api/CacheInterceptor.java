package cn.com.mushuichuan.heartstonecards.api;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Liyanshun on 2016/2/19.
 */
public class CacheInterceptor implements Interceptor {
    @Inject
    public CacheInterceptor() {
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        CacheControl.Builder builder = new CacheControl.Builder().maxAge(3600, TimeUnit.SECONDS);
        Request request1 = request.newBuilder().cacheControl(builder.build()).build();
        String url = request.url().toString();
        Response response = chain.proceed(request1);
//        String body = CommonSp.getCommonString(url);
//        if (!TextUtils.isEmpty(body)) {

//            cacheResponse.body().contentLength();
//        }
        Response response1 = response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .removeHeader("expires")
                .removeHeader("Connection")
                .header("Cache-Control", "max-age=36000")
                .build();

        Response cacheResponse = response1.cacheResponse();
        return response1;
    }
}
