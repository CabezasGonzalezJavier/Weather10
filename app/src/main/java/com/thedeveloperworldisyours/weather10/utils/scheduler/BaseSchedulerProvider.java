package com.thedeveloperworldisyours.weather10.utils.scheduler;

import android.support.annotation.NonNull;

import rx.Scheduler;


/**
 * Created by javierg on 20/02/2017.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
