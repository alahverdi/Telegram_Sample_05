package com.alroid.telegrammftapp.entity;

import android.graphics.drawable.Drawable;

public class Chat {
    int id;
    Drawable imgUser;
    String userName,
            message,
            hour,
            messageNumber;

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

    public String getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", img_user=" + imgUser +
                ", userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", hour='" + hour + '\'' +
                ", messageNumber='" + messageNumber + '\'' +
                '}';
    }
}
