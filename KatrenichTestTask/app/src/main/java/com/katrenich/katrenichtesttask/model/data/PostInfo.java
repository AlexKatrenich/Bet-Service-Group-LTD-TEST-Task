package com.katrenich.katrenichtesttask.model.data;

import android.support.annotation.Nullable;

import java.util.List;

public class PostInfo {
    private int postId; // ІД поста
    private int postViewsCount; // Кількість переглядів поста
    private int postBookmarksCount; // кількість користувачів, що додали пост в закладки

    @Nullable
    private List<User> postLikersList; // список користувачів, що поставили лайк
    @Nullable
    private List<User> postCommentatorsList; // список користувачів, що прокоментували
    @Nullable
    private List<User> MentionedUsersList; // список користувачів, що відмічені в пості
    @Nullable
    private List<User> repostUsersList; // кількість користувачів, що зарепостили

    public PostInfo() {

    }

    public PostInfo(int postId, int postViewsCount, int postBookmarksCount) {
        this.postId = postId;
        this.postViewsCount = postViewsCount;
        this.postBookmarksCount = postBookmarksCount;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostViewsCount() {
        return postViewsCount;
    }

    public void setPostViewsCount(int postViewsCount) {
        this.postViewsCount = postViewsCount;
    }

    public int getPostBookmarksCount() {
        return postBookmarksCount;
    }

    public void setPostBookmarksCount(int postBookmarksCount) {
        this.postBookmarksCount = postBookmarksCount;
    }
    @Nullable
    public List<User> getPostLikersList() {
        return postLikersList;
    }

    public void setPostLikersList(List<User> postLikersList) {
        this.postLikersList = postLikersList;
    }

    @Nullable
    public List<User> getPostCommentatorsList() {
        return postCommentatorsList;
    }

    public void setPostCommentatorsList(List<User> postCommentatorsList) {
        this.postCommentatorsList = postCommentatorsList;
    }

    @Nullable
    public List<User> getMentionedUsersList() {
        return MentionedUsersList;
    }

    public void setMentionedUsersList(List<User> mentionedUsersList) {
        MentionedUsersList = mentionedUsersList;
    }

    @Nullable
    public List<User> getRepostUsersList() {
        return repostUsersList;
    }

    public void setRepostUsersList(List<User> repostUsersList) {
        this.repostUsersList = repostUsersList;
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "postId=" + postId +
                ", postViewsCount=" + postViewsCount +
                ", postBookmarksCount=" + postBookmarksCount +
                '}';
    }
}
