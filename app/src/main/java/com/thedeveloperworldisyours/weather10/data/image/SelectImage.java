package com.thedeveloperworldisyours.weather10.data.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.thedeveloperworldisyours.weather10.R;
import com.thedeveloperworldisyours.weather10.data.image.ImageMain;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class SelectImage {
    ImageMain mWeather;

    public SelectImage(ImageMain weather) {
        this.mWeather = weather;
    }
    public Drawable chooseImage(Context context) {
        switch (mWeather) {
            case SUNNY:
                return ContextCompat.getDrawable(context, R.drawable.ic_sunny);
            case CLOUDY:
                return ContextCompat.getDrawable(context, R.drawable.ic_cloudy);
            case PARTLY_CLOUDY:
                return ContextCompat.getDrawable(context, R.drawable.ic_partly_cloudy);
            case RAINY:
                return ContextCompat.getDrawable(context, R.drawable.ic_rainning);
            case SNOWY:
                return ContextCompat.getDrawable(context, R.drawable.ic_snowy);
            default:
                return ContextCompat.getDrawable(context, R.drawable.ic_sunny);
        }
    }
}
