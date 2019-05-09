package com.katrenich.katrenichtesttask.model.network.user_post_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWrapper {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("avatar_image")
    @Expose
    private UserAvatarImage avatarImage;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserAvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(UserAvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    @Override
    public String toString() {
        return "UserWrapper{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
