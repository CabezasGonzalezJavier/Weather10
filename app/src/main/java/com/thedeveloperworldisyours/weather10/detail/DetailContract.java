package com.thedeveloperworldisyours.weather10.detail;

import com.thedeveloperworldisyours.weather10.data.Generic;
import com.thedeveloperworldisyours.weather10.utils.BasePresenter;
import com.thedeveloperworldisyours.weather10.utils.BaseView;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public interface DetailContract {

    interface Presenter extends BasePresenter {
        void fetch();
    }

    interface View extends BaseView<Presenter> {
        void showDetails(Generic generic);

    }
}
