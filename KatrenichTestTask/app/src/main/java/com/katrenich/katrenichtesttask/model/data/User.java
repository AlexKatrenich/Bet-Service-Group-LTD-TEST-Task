package com.katrenich.katrenichtesttask.model.data;

import java.util.Objects;

public class User {

    private String nickName;

    private String userAvatarImageURL; // змінна відображає адресу посилання на зображення аватару користувача

    public User(String nickName) {
        this.nickName = nickName;
    }

    public User(String nickName, String userAvatarImageURL) {
        this.nickName = nickName;
        this.userAvatarImageURL = userAvatarImageURL;
    }

    public String getName() {
        return nickName;
    }

    public void setName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserAvatarImageURL() {
        return userAvatarImageURL;
    }

    public void setUserAvatarImageURL(String userAvatarImageURL) {
        this.userAvatarImageURL = userAvatarImageURL;
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
