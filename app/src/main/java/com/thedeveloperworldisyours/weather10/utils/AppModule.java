package com.thedeveloperworldisyours.weather10.utils;

import com.thedeveloperworldisyours.weather10.WeatherApplication;
import com.thedeveloperworldisyours.weather10.data.RemoteDataSource;
import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;
import com.thedeveloperworldisyours.weather10.utils.scheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.thedeveloperworldisyours.weather10.utils.Constants.URL_BASE;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */
@Module
public class AppModule {

    WeatherApplication mWeatherApplication;

    public AppModule(WeatherApplication weatherApplication) {
        mWeatherApplication = weatherApplication;
    }

    @Singleton
    @Provides
    RemoteDataSource provideRemoteDataSource() {
        return new RemoteDataSource(new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build());
    }

    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }
}