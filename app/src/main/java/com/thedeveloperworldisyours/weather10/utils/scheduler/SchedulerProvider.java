package com.thedeveloperworldisyours.weather10.utils.scheduler;

import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by javierg on 20/02/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {

    // Prevent direct instantiation.
    public SchedulerProvider() {
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
