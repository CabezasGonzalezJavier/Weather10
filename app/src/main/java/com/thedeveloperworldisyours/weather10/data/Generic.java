package com.thedeveloperworldisyours.weather10.data;

import java.io.Serializable;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class Generic implements Serializable {

    //City
    private String title;

    //weather
    private String image;
    private String description;

    //Main
    private String temp;
    private String pressure;
    private String humidity;
    private String tempMin;
    private String tempMax;

    //wind
    private String speed;
    private String deg;

    //rain
    private String rain;

    public Generic() {

    }

    public Generic(String title, String image, String description, String temp, String pressure, String humidity, String tempMin, String tempMax, String speed, String deg, String rain) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.speed = speed;
        this.deg = deg;
        this.rain = rain;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getTemp() {
        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDeg() {
        return deg;
    }

    public String getRain() {
        return rain;
    }
}
