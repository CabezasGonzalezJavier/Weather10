package com.thedeveloperworldisyours.weather10.data;

import com.thedeveloperworldisyours.weather10.data.model.List;

import static com.thedeveloperworldisyours.weather10.utils.Constants.FIRST_POSITION;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class CreateGeneric {

    public static Generic newGeneric(List list, String noFound) {

        if (list != null) {
            String title = noFound;
            String temp = noFound;
            String image = noFound;
            String description = noFound;
            String pressure = noFound;
            String humidity = noFound;
            String tempMin = noFound;
            String tempMax = noFound;
            String speed = noFound;
            String deg = noFound;
            String rain = "0";
            if (list.getName() != null) {
                title = list.getName();
            }
            if (list.getWeather().get(FIRST_POSITION).getMain() != null) {
                image = String.valueOf(list.getWeather().get(FIRST_POSITION).getMain());
            }
            if (list.getWeather().get(FIRST_POSITION).getDescription() != null) {
                description = String.valueOf(list.getWeather().get(FIRST_POSITION).getDescription());
            }
            if (list.getMain().getTemp() != null) {
                temp = String.valueOf(list.getMain().getTemp());
            }
            if (list.getMain().getPressure() != null) {
                pressure = String.valueOf(list.getMain().getPressure());
            }
            if (list.getMain().getHumidity() != null) {
                humidity = String.valueOf(list.getMain().getHumidity());
            }
            if (list.getMain().getTempMin() != null) {
                tempMin = String.valueOf(list.getMain().getTempMin());
            }
            if (list.getMain().getTempMax() != null) {
                tempMax = String.valueOf(list.getMain().getTempMax());
            }
            if (list.getWind().getSpeed() != null) {
                speed = String.valueOf(list.getWind().getSpeed());
            }
            if (list.getWind().getDeg() != null) {
                deg = String.valueOf(list.getWind().getDeg());
            }
            if (list.getRain() != null) {
                rain = String.valueOf(list.getRain().get3h());
            }

            return new Generic(title, image, description, temp, pressure, humidity, tempMin, tempMax, speed, deg, rain);
        } else {
            return new Generic();
        }
    }
}
