package com.thedeveloperworldisyours.weather10.cities;

import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.weather10.data.RemoteDataSource;
import com.thedeveloperworldisyours.weather10.data.model.Example;
import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.thedeveloperworldisyours.weather10.data.CreateGeneric.newGeneric;
import static com.thedeveloperworldisyours.weather10.utils.Constants.APP_ID;
import static com.thedeveloperworldisyours.weather10.utils.Constants.CNT;
import static com.thedeveloperworldisyours.weather10.utils.Constants.LAT;
import static com.thedeveloperworldisyours.weather10.utils.Constants.LON;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public class CitiesPresenter implements CitiesContract.Presenter {

    @NonNull
    private CitiesContract.View mView;

    @NonNull
    private BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private CompositeSubscription mSubscriptions;

    @NonNull
    private RemoteDataSource mRemoteDataSource;

    public CitiesPresenter(@NonNull RemoteDataSource remoteDataSource, @NonNull CitiesContract.View view, @NonNull BaseSchedulerProvider provider) {
        this.mRemoteDataSource = checkNotNull(remoteDataSource, "remoteDataSource");
        this.mView = checkNotNull(view, "view cannot be null!");
        this.mSchedulerProvider = checkNotNull(provider, "schedulerProvider cannot be null");

        mSubscriptions = new CompositeSubscription();

        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        fetch();
    }

    @Override
    public void unSubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void fetch() {
        mView.setLoadingIndicator(true);
        Subscription subscription = mRemoteDataSource.getWeatherRx(LAT, LON, CNT, APP_ID)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((Example example) -> {
                            mView.setLoadingIndicator(false);
                            mView.showCities(example.getList());
                        },
                        (Throwable error) -> {
                            try {
                                mView.showError();
                            } catch (Throwable t) {
                                throw new IllegalThreadStateException();
                            }

                        },
                        () -> {
                        });

        mSubscriptions.add(subscription);
    }

    @Override
    public void onClickItem(com.thedeveloperworldisyours.weather10.data.model.List list, String noFound) {
        mView.takeGeneric(newGeneric(list, noFound));
    }
}
