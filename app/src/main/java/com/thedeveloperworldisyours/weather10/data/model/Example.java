
package com.thedeveloperworldisyours.weather10.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("list")
    @Expose
    private java.util.List<com.thedeveloperworldisyours.weather10.data.model.List> list = null;

    public Example(String message, String cod, Integer count, java.util.List<List> list) {
        this.message = message;
        this.cod = cod;
        this.count = count;
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public java.util.List<com.thedeveloperworldisyours.weather10.data.model.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.thedeveloperworldisyours.weather10.data.model.List> list) {
        this.list = list;
    }

}
