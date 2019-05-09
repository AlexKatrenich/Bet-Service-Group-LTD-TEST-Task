package com.katrenich.katrenichtesttask.model.network.user_post_statistics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostUsersList {
    @SerializedName("data")
    @Expose
    private List<UserWrapper> data = null;

    public List<UserWrapper> getData() {
        return data;
    }

    public void setData(List<UserWrapper> data) {
        this.data = data;
    }

}
