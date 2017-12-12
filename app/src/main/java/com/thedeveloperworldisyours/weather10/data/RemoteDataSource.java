package com.thedeveloperworldisyours.weather10.data;

import com.thedeveloperworldisyours.weather10.data.model.Example;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public class RemoteDataSource implements Service {

    private Service api;

    public RemoteDataSource(Retrofit retrofit) {


        this.api = retrofit.create(Service.class);
    }

    @Override
    public Observable<Example> getWeatherRx(String lat, String lon, String cnt, String appid) {
        return api.getWeatherRx(lat, lon, cnt, appid);
    }

}
