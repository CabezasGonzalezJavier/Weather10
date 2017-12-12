package com.thedeveloperworldisyours.weather10.data;

import com.thedeveloperworldisyours.weather10.data.model.Example;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public interface Service {
    @GET("find/")
        Observable<Example> getWeatherRx(@Query("lat") String lat, @Query("lon") String lon, @Query("cnt") String cnt, @Query("appid") String appid);
}
