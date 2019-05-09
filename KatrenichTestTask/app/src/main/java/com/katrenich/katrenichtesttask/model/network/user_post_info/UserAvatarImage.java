package com.katrenich.katrenichtesttask.model.network.user_post_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAvatarImage {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_large")
    @Expose
    private String urlLarge;
    @SerializedName("url_small")
    @Expose
    private String urlSmall;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlLarge() {
        return urlLarge;
    }

    public void setUrlLarge(String urlLarge) {
        this.urlLarge = urlLarge;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    @Override
    public String toString() {
        return "UserAvatarImage{" +
                "id=" + id +
                ", urlSmall='" + urlSmall + '\'' +
                '}';
    }
}
