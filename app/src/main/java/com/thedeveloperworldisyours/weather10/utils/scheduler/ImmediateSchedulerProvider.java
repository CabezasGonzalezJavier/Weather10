package com.thedeveloperworldisyours.weather10.utils.scheduler;

import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;

import rx.Scheduler;
import rx.schedulers.Schedulers;


/**
 * Created by javierg on 20/02/2017.
 */

public class ImmediateSchedulerProvider implements BaseSchedulerProvider {

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.immediate();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.immediate();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return Schedulers.immediate();
    }
}
