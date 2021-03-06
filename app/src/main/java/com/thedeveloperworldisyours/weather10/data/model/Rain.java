package com.thedeveloperworldisyours.weather10.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by javiergonzalezcabezas on 13/12/17.
 */

public class Rain {

    @SerializedName("3h")
    @Expose
    private Integer _3h;

    public Rain(Integer _3h) {
        this._3h = _3h;
    }

    public Integer get3h() {
        return _3h;
    }

    public void set3h(Integer _3h) {
        this._3h = _3h;
    }

}
