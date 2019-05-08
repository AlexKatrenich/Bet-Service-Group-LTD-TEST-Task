package com.katrenich.katrenichtesttask.model.data;

import android.graphics.Bitmap;

import java.util.Objects;

public class User {
    private int userID;

    private String nickName;

    private Bitmap userAvatar;

    public User(String nickName) {
        this.nickName = nickName;
    }

    public User(String nickName, Bitmap userAvatar) {
        this.nickName = nickName;
        this.userAvatar = userAvatar;
    }

    public String getName() {
        return nickName;
    }

    public void setName(String nickName) {
        this.nickName = nickName;
    }

    public Bitmap getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(Bitmap userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nickName, user.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + nickName + '\'' +
                '}';
    }

}
