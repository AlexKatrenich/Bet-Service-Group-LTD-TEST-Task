package com.katrenich.katrenichtesttask.model.network.user_post_statistics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostInfoWrapper {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("bookmarks_count")
    @Expose
    private Integer bookmarksCount;
    @SerializedName("reposts_count")
    @Expose
    private Integer repostsCount;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public Integer getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(Integer repostsCount) {
        this.repostsCount = repostsCount;
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
                ", slug='" + slug + '\'' +
                ", commentsCount='" + commentsCount + '\'' +
                ", likesCount='" + likesCount + '\'' +
                ", bookmarksCount='" + bookmarksCount + '\'' +
                ", repostsCount='" + repostsCount + '\'' +
                ", viewsCount='" + viewsCount + '\'' +
                '}';
    }
}
