package com.katrenich.katrenichtesttask.model.network.user_post_statistics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostInfoWrapper {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("bookmarks_count")
    @Expose
    private Integer bookmarksCount;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    @Override
    public String toString() {
        return "PostInfoWrapper{" +
                "id='" + id + '\'' +
                ", bookmarksCount='" + bookmarksCount + '\'' +
                ", viewsCount='" + viewsCount + '\'' +
                '}';
    }
}
