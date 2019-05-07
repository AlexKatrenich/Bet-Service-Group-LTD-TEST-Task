package com.katrenich.katrenichtesttask.presentation.view;

import com.katrenich.katrenichtesttask.model.data.User;

import java.util.List;

public interface PostStatisticsView {
    void showLikesList(List<User> likes);
    void showCommentatorsList(List<User> commentators);
    void showMarksList(List<User> marks);
}
