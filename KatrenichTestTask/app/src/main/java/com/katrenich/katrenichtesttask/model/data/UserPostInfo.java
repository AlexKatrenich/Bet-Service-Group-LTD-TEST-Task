package com.katrenich.katrenichtesttask.model.data;

public class UserPostInfo {
    private int postId; // ІД поста
    private String postSlug; // мітка поста
    private int commentatorsCount; // кількість користувачів, що прокоментували пост
    private int likesCount; // кількість користувачів, які поставили лайк в пості
    private int bookmarksCount; // кількість користувачів, що додали пост в закладки
    private int repostsCount; // кількість користувачів, що зарепостили пост
    private int viewsCount; // кількість переглядів посту
    private int mentionedUserCount; // кількість користувачів відмічених в пості

    public UserPostInfo() {

    }

    public UserPostInfo(int postId, String postSlug, int commentatorsCount, int likesCount, int bookmarksCount, int repostsCount, int viewsCount) {
        this.postId = postId;
        this.postSlug = postSlug;
        this.commentatorsCount = commentatorsCount;
        this.likesCount = likesCount;
        this.bookmarksCount = bookmarksCount;
        this.repostsCount = repostsCount;
        this.viewsCount = viewsCount;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public int getCommentatorsCount() {
        return commentatorsCount;
    }

    public void setCommentatorsCount(int commentatorsCount) {
        this.commentatorsCount = commentatorsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(int bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }


    public int getMentionedUserCount() {
        return mentionedUserCount;
    }

    public void setMentionedUserCount(int mentionedUserCount) {
        this.mentionedUserCount = mentionedUserCount;
    }
}
