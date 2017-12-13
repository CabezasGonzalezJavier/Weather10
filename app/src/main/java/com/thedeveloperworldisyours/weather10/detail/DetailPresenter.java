package com.thedeveloperworldisyours.weather10.detail;

import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.weather10.data.Generic;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class DetailPresenter implements DetailContract.Presenter {

    @NonNull
    private DetailContract.View mView;
    private Generic mGeneric;

    public DetailPresenter(Generic mGeneric, DetailContract.View view) {
        this.mGeneric = mGeneric;
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        fetch();
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void fetch() {
        mView.showDetails(mGeneric);
    }
}

