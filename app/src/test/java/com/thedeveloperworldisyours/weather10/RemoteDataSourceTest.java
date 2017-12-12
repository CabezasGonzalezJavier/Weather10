package com.thedeveloperworldisyours.weather10;

import com.google.gson.Gson;
import com.thedeveloperworldisyours.weather10.data.RemoteDataSource;
import com.thedeveloperworldisyours.weather10.data.model.Example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.observers.TestSubscriber;

import static com.thedeveloperworldisyours.weather10.utils.Constants.APP_ID;
import static com.thedeveloperworldisyours.weather10.utils.Constants.CNT;
import static com.thedeveloperworldisyours.weather10.utils.Constants.LAT;
import static com.thedeveloperworldisyours.weather10.utils.Constants.LON;
import static com.thedeveloperworldisyours.weather10.utils.Constants.URL_BASE;

/**
 * Created by javiergonzalezcabezas on 12/12/17.
 */

public class RemoteDataSourceTest {
    Example mResult;
    MockWebServer mMockWebServer;
    TestSubscriber<Example> mSubscriber;

    @Before
    public void setUp() {
        com.thedeveloperworldisyours.weather10.data.model.List listExample = new com.thedeveloperworldisyours.weather10.data.model.List(11, "London");
        java.util.List<com.thedeveloperworldisyours.weather10.data.model.List> listElements = new ArrayList<>();
        listElements.add(listExample);

        mResult = new Example("accurate", "200", 10, listElements);

        mMockWebServer = new MockWebServer();
        mSubscriber = new TestSubscriber<>();
    }

    @Test
    public void serverCallWithError() {
        //Given
        String url = "dfdf/";
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mResult)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getWeatherRx(LAT, LON, CNT, APP_ID).subscribe(mSubscriber);

        //Then
        mSubscriber.assertNoErrors();
        mSubscriber.assertCompleted();
    }

    @Test
    public void severCallWithSuccessful() {
        //Given
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mResult)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(URL_BASE))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getWeatherRx(LAT, LON, CNT, APP_ID).subscribe(mSubscriber);

        //Then
        mSubscriber.assertNoErrors();
        mSubscriber.assertCompleted();
    }
}
