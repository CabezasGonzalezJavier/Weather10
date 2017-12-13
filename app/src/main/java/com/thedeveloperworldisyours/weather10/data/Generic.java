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

    public Generic() {

    }

    public Generic(String title, String image, String description, String temp, String pressure, String humidity, String tempMin, String tempMax, String speed, String deg) {
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
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }
}
