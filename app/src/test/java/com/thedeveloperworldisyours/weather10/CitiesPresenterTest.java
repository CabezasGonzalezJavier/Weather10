package com.thedeveloperworldisyours.weather10;

import com.thedeveloperworldisyours.weather10.cities.CitiesContract;
import com.thedeveloperworldisyours.weather10.cities.CitiesPresenter;
import com.thedeveloperworldisyours.weather10.data.Generic;
import com.thedeveloperworldisyours.weather10.data.RemoteDataSource;
import com.thedeveloperworldisyours.weather10.data.model.Example;
import com.thedeveloperworldisyours.weather10.data.model.Main;
import com.thedeveloperworldisyours.weather10.data.model.Weather;
import com.thedeveloperworldisyours.weather10.data.model.Wind;
import com.thedeveloperworldisyours.weather10.utils.scheduler.BaseSchedulerProvider;
import com.thedeveloperworldisyours.weather10.utils.scheduler.ImmediateSchedulerProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import rx.Observable;

import static com.thedeveloperworldisyours.weather10.utils.Constants.APP_ID;
import static com.thedeveloperworldisyours.weather10.utils.Constants.CNT;
import static com.thedeveloperworldisyours.weather10.utils.Constants.LAT;
import static com.thedeveloperworldisyours.weather10.utils.Constants.LON;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */
public class CitiesPresenterTest {

    @Mock
    private CitiesContract.View mView;

    @Mock
    private BaseSchedulerProvider mSchedulerProvider;

    @Mock
    private RemoteDataSource mRemoteDataSource;

    CitiesPresenter mPresenter;
    Example mResult;

    @Before
    public void setup() {

        com.thedeveloperworldisyours.weather10.data.model.List listExample = new com.thedeveloperworldisyours.weather10.data.model.List(11, "London");
        java.util.List<com.thedeveloperworldisyours.weather10.data.model.List> listElements = new ArrayList<>();
        listElements.add(listExample);

        mResult = new Example("accurate", "200", 10, listElements);


        MockitoAnnotations.initMocks(this);
        mSchedulerProvider = new ImmediateSchedulerProvider();
        mPresenter = new CitiesPresenter(mRemoteDataSource, mView, mSchedulerProvider);
    }

    @Test
    public void fetchData() {
        when(mRemoteDataSource.getWeatherRx(LAT, LON, CNT, APP_ID))
                .thenReturn(rx.Observable.just(mResult));

        mPresenter.fetch();

        InOrder inOrder = Mockito.inOrder(mView);
        inOrder.verify(mView).setLoadingIndicator(true);
        inOrder.verify(mView).setLoadingIndicator(false);
        inOrder.verify(mView).showCities(mResult.getList());
    }

    @Test
    public void fetchError() {

        when(mRemoteDataSource.getWeatherRx(LAT, LON, CNT, APP_ID))
                .thenReturn(Observable.error(new Throwable("An error has occurred!")));
        mPresenter.fetch();

        InOrder inOrder = Mockito.inOrder(mView);
        inOrder.verify(mView).setLoadingIndicator(true);
        inOrder.verify(mView).showError();
    }

    @Test
    public void onClickItem() {
        Weather weather = new Weather("Clear", "clear");
        java.util.List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);
        Main main = new Main(1.1, 1, 1, 1.1, 1.1);
        Wind wind = new Wind(1, 1);
        com.thedeveloperworldisyours.weather10.data.model.List listItem = new com.thedeveloperworldisyours.weather10.data.model.List("London", main, wind, weatherList);
        mPresenter.onClickItem(listItem, "");

        verify(mView).takeGeneric(any(Generic.class));
    }

    @Test
    public void onClickItem_NullWind() {
        Weather weather = new Weather("Clear", "clear");
        java.util.List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);
        Main main = new Main(1.1, 1, 1, 1.1, 1.1);
        Wind wind = new Wind(null, null);
        com.thedeveloperworldisyours.weather10.data.model.List listItem = new com.thedeveloperworldisyours.weather10.data.model.List("London", main, wind, weatherList);
        mPresenter.onClickItem(listItem, "");

        verify(mView).takeGeneric(any(Generic.class));
    }

    @Test
    public void onClickItem_NullMainAndWind() {
        Weather weather = new Weather("Clear", "clear");
        java.util.List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);
        Main main = new Main(null, null, null, null, null);
        Wind wind = new Wind(null, null);
        com.thedeveloperworldisyours.weather10.data.model.List listItem = new com.thedeveloperworldisyours.weather10.data.model.List("London", main, wind, weatherList);
        mPresenter.onClickItem(listItem, "");

        verify(mView).takeGeneric(any(Generic.class));
    }

    @Test
    public void onClickItem_NullMainWindAndWeather() {
        Weather weather = new Weather(null, null);
        java.util.List<Weather> weatherList = new ArrayList<>();
        weatherList.add(weather);
        Main main = new Main(null, null, null, null, null);
        Wind wind = new Wind(null, null);
        com.thedeveloperworldisyours.weather10.data.model.List listItem = new com.thedeveloperworldisyours.weather10.data.model.List("London", main, wind, weatherList);
        mPresenter.onClickItem(listItem, "");

        verify(mView).takeGeneric(any(Generic.class));
    }
}
