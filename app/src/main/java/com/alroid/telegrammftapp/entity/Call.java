package com.alroid.telegrammftapp.entity;

import android.graphics.drawable.Drawable;

public class Call {
    int id;
    Drawable imgUser;
    String userName,
            message,
            hour,
            date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImgUser() {
        return imgUser;
    }

    public void setImgUser(Drawable imgUser) {
        this.imgUser = imgUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", imgUser=" + imgUser +
                ", userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", hour='" + hour + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
