package com.thedeveloperworldisyours.weather10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thedeveloperworldisyours.weather10.data.RemoteDataSource;
import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    RemoteDataSource mRemoteDataSource;

    @Inject
    BaseSchedulerProvider mSchedulerProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDagger();
    }

    private void initializeDagger() {
        WeatherApplication app = (WeatherApplication) getApplication();
        app.getAppComponent().inject(this);
    }
}
