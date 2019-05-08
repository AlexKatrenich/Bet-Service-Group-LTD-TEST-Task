package com.katrenich.katrenichtesttask.presentation.view;

import com.katrenich.katrenichtesttask.model.data.User;
import com.katrenich.katrenichtesttask.model.data.UserPostInfo;

import java.util.List;

public interface PostStatisticsView {
    // метод для відображення списку користувачів, що лайкнули пост
    void showLikesList(List<User> likes);

    // метод для відображення списку користувачів, що прокоментували пост
    void showCommentatorsList(List<User> commentators);

    // метод для відображення списку користувачів, що були відмічені в пості
    void showMarksList(List<User> marks);

    // метод для відображення списку користувачів, що додали пост в закладки
    void showBookmarksList(List<User> bookmarks);

    /* метод для відображення основної інформації про пост користувача
       * ІД, slug
       * кількість користувачів, що лайкнули, додали в закладки, прокоментували, переглянули, зарепостили
     */
    void showMainInfo(UserPostInfo model);

    void showMessage(String message);
}
