package com.katrenich.katrenichtesttask.presentation.view;

import com.katrenich.katrenichtesttask.model.data.User;

import java.util.List;

public interface PostStatisticsView {
    // метод для відображення списку користувачів, що лайкнули пост
    void showLikesList(List<User> likes);

    // метод для відображення списку користувачів, що прокоментували пост
    void showCommentatorsList(List<User> commentators);

    // метод для відображення списку користувачів, що були відмічені в пості
    void showMentionedList(List<User> marks);

    // метод для відображення списку користувачів, що додали пост в закладки
    void showRepostersList(List<User> reposters);

    void showCountViews(int conut);

    void showCountBookmarks(int count);

    void showMessage(String message);
}
