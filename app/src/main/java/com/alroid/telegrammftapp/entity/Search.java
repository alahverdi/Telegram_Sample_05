package com.alroid.telegrammftapp.entity;

import android.graphics.drawable.Drawable;

public class Search {
    int id;
    Drawable imgUser;
    String userName;

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

    @Override
    public String toString() {
        return "Search{" +
                "id=" + id +
                ", imgUser=" + imgUser +
                ", userName='" + userName + '\'' +
                '}';
    }
}
