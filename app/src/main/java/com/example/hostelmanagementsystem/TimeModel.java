package com.example.hostelmanagementsystem;

import android.content.Intent;

public class TimeModel {
    Integer id;
    String date;

    public TimeModel( String date) {
        this.date = date;
    }
    public TimeModel(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
