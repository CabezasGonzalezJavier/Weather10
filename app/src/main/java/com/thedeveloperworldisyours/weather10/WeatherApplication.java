package com.thedeveloperworldisyours.weather10;

import android.app.Application;

import com.thedeveloperworldisyours.weather10.utils.AppComponent;
import com.thedeveloperworldisyours.weather10.utils.AppModule;
import com.thedeveloperworldisyours.weather10.utils.DaggerAppComponent;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public class WeatherApplication  extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
