package com.thedeveloperworldisyours.weather10.cities;

import com.thedeveloperworldisyours.weather10.data.Generic;
import com.thedeveloperworldisyours.weather10.utils.BasePresenter;
import com.thedeveloperworldisyours.weather10.utils.BaseView;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public interface CitiesContract {

    interface Presenter extends BasePresenter {
        void fetch();
        void onClickItem(com.thedeveloperworldisyours.weather10.data.model.List list, String noFound);
    }

    interface View extends BaseView<Presenter> {
        void showCities(List<com.thedeveloperworldisyours.weather10.data.model.List> listElements);

        void showError();

        void setLoadingIndicator(boolean active);

        void takeGeneric(Generic generic);

    }
}
