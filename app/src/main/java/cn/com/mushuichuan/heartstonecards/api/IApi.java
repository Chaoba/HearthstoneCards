package cn.com.mushuichuan.heartstonecards.api;

import cn.com.mushuichuan.heartstonecards.mvp.Info;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by Liyanshun on 2016/2/17.
 */
public interface IApi {
    @Headers({
            "X-Mashape-Key:U4y8yvgRDUmshqUkNb1LJxmsRCBap1WWG0wjsnUj07GxYfsKUI",
            "Accept: application/json"
    })
    @GET("info")
    Observable<Info> getInfo();
}
