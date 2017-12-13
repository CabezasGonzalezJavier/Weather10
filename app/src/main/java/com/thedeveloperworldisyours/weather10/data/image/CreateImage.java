package com.thedeveloperworldisyours.weather10.data.image;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class CreateImage {
    public static Drawable getImageFromString(String main, Context context) {
        SelectImage imageMain;
        if (main.equals("Clear")) {
            imageMain = new SelectImage(ImageMain.SUNNY);
        } else if (main.equals("Drizzle")) {
            imageMain = new SelectImage(ImageMain.RAINY);
        } else if (main.equals("Rain")) {
            imageMain = new SelectImage(ImageMain.RAINY);
        } else if (main.equals("Mist")) {
            imageMain = new SelectImage(ImageMain.PARTLY_CLOUDY);
        } else if (main.equals("Clouds")) {
            imageMain = new SelectImage(ImageMain.CLOUDY);
        } else if (main.equals("Snow")) {
            imageMain = new SelectImage(ImageMain.SNOWY);
        } else if (main.equals("Extreme")) {
            imageMain = new SelectImage(ImageMain.SNOWY);
        } else {
            imageMain = new SelectImage(ImageMain.SUNNY);
        }

        return imageMain.chooseImage(context);
    }
}
