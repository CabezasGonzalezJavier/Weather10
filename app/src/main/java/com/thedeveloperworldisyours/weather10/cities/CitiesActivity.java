package com.thedeveloperworldisyours.weather10.cities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thedeveloperworldisyours.weather10.R;
import com.thedeveloperworldisyours.weather10.WeatherApplication;
import com.thedeveloperworldisyours.weather10.data.Generic;
import com.thedeveloperworldisyours.weather10.data.RemoteDataSource;
import com.thedeveloperworldisyours.weather10.detail.DetailActivity;
import com.thedeveloperworldisyours.weather10.utils.InteractionListener;
import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

import static com.thedeveloperworldisyours.weather10.utils.Constants.SERIALIZABLE_GENERIC;
import static com.thedeveloperworldisyours.weather10.utils.Utils.addFragmentToActivity;

public class CitiesActivity extends AppCompatActivity implements InteractionListener {

    @Inject
    RemoteDataSource mRemoteDataSource;

    @Inject
    BaseSchedulerProvider mSchedulerProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities_activity);
        initializeDagger();
        initFragment();
    }

    private void initializeDagger() {
        WeatherApplication app = (WeatherApplication) getApplication();
        app.getAppComponent().inject(this);
    }

    private void initFragment () {
        CitiesFragment citiesFragment = (CitiesFragment) getSupportFragmentManager().
                findFragmentById(R.id.cities_activity_contentFrame);

        if (citiesFragment == null) {
            citiesFragment = citiesFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(),
                    citiesFragment, R.id.cities_activity_contentFrame);
        }

        new CitiesPresenter(mRemoteDataSource, citiesFragment, mSchedulerProvider);

    }

    @Override
    public void onFragmentInteraction(Generic generic) {
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SERIALIZABLE_GENERIC, generic);
        intent.putExtras(mBundle);
        startActivity(intent);
    }
}
