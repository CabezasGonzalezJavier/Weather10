package com.thedeveloperworldisyours.weather10.utils;

import com.thedeveloperworldisyours.weather10.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity citiesActivity);

}
