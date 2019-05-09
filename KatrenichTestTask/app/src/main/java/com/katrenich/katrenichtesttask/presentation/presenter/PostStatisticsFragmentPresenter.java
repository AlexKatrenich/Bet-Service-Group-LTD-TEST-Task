package com.katrenich.katrenichtesttask.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.katrenich.katrenichtesttask.model.data.User;
import com.katrenich.katrenichtesttask.model.data.PostInfo;
import com.katrenich.katrenichtesttask.model.network.NetworkService;
import com.katrenich.katrenichtesttask.model.network.user_post_info.PostInfoWrapper;
import com.katrenich.katrenichtesttask.model.network.user_post_info.PostUsersList;
import com.katrenich.katrenichtesttask.model.network.user_post_info.UserWrapper;
import com.katrenich.katrenichtesttask.presentation.BasePresenter;
import com.katrenich.katrenichtesttask.presentation.view.PostStatisticsView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostStatisticsFragmentPresenter extends BasePresenter<PostInfo, PostStatisticsView> {
    public static final String TAG = "PostStatFragPresenter";

    public PostStatisticsFragmentPresenter() {
        setModel(new PostInfo());
    }

    @Override
    protected void updateView() {
        Log.i(TAG, "updateView: " + model);
        if (setupDone()) {
            view().showCountViews(model.getPostViewsCount());
            view().showCountBookmarks(model.getPostBookmarksCount());
            if(model.getPostLikersList() != null) view().showLikesList(model.getPostLikersList());
            if(model.getMentionedUsersList() != null) view().showMentionedList(model.getMentionedUsersList());
            if(model.getPostCommentatorsList() != null) view().showCommentatorsList(model.getPostCommentatorsList());
            if(model.getRepostUsersList() != null) view().showRepostersList(model.getRepostUsersList());
        }
    }

    @Override
    public void bindView(@NonNull PostStatisticsView view) {
        super.bindView(view);
        getPostDataByID(134294);
    }

    // метод для отримання додаткової інфорації про пост: Кількість переглядів та Закладок
    private void getPostInfoByID(Integer id) {
        if (id == null) {
            Log.i(TAG, "getPostInfoByID: ID = NULL");
            return;
        }

        // отримання основної інформації про пост
        NetworkService.getInstance()
                .getUserPostInfoJSON()
                .getUserPostInfoById(id)
                .enqueue(new Callback<PostInfoWrapper>() {
                    @Override
                    public void onResponse(Call<PostInfoWrapper> call, Response<PostInfoWrapper> response) {
                        if (response.isSuccessful()){
                            PostInfoWrapper postStatistics = response.body();
                            Log.i(TAG, "onResponse: " + postStatistics);
                            try {
                                model.setPostId(postStatistics.getId());
                                model.setPostBookmarksCount(postStatistics.getBookmarksCount());
                                model.setPostViewsCount(postStatistics.getViewsCount());
                                view().showCountViews(model.getPostViewsCount());
                                view().showCountBookmarks(model.getPostBookmarksCount());
                            } catch (NullPointerException e){
                                Log.i(TAG, "onResponse: " + e.getMessage());
                            }
                        } else {
                            Log.i(TAG, "onResponse is not successful" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostInfoWrapper> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });

    }

    // метод для отримання інформації про користувачів, що лайкнули пост
    private void getPostLikersInfo(int postID){
        NetworkService.getInstance().getUserPostInfoJSON()
                .getUserPostLikersInfoById(postID)
                .enqueue(new Callback<PostUsersList>() {
                    @Override
                    public void onResponse(Call<PostUsersList> call, Response<PostUsersList> response) {
                        if (response.isSuccessful()){
                            PostUsersList postUsersList = response.body();
                            List<UserWrapper> users = postUsersList.getData();
                            if(users != null) {
                                Log.i(TAG, "onResponse: " + users);
                                ArrayList<User> list = new ArrayList<>();

                                for (UserWrapper uWrapper : users) {
                                    list.add(new User(uWrapper.getNickname(), uWrapper.getAvatarImage().getUrlSmall()));
                                }
                                Log.i(TAG, "onResponse USERS:" + list + " " + setupDone());
                                model.setPostLikersList(list);
                                if (setupDone()) view().showLikesList(list);
                            }
                        } else {
                            Log.i(TAG, "onResponse: is not successful" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostUsersList> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    // метод для отримання інформації про користувачів, що прокоментували пост
    private void getCommentatorsInfo(int postID){
        NetworkService.getInstance().getUserPostInfoJSON()
                .getUserPostCommentatorsById(postID)
                .enqueue(new Callback<PostUsersList>() {
                    @Override
                    public void onResponse(Call<PostUsersList> call, Response<PostUsersList> response) {
                        if (response.isSuccessful()){
                            PostUsersList postUsersList = response.body();
                            List<UserWrapper> users = postUsersList.getData();
                            if(users != null) {
                                Log.i(TAG, "onResponse: " + users);
                                ArrayList<User> list = new ArrayList<>();

                                for (UserWrapper uWrapper : users) {
                                    list.add(new User(uWrapper.getNickname(), uWrapper.getAvatarImage().getUrlSmall()));
                                }
                                Log.i(TAG, "onResponse USERS:" + list + " " + setupDone());
                                model.setPostCommentatorsList(list);
                                if (setupDone()) view().showCommentatorsList(list);
                            }
                        } else {
                            Log.i(TAG, "onResponse: is not successful" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostUsersList> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    // метод для отримання інформації про користувачів, що зробили репост
    private void getRepostsInfo(int postID){
        NetworkService.getInstance().getUserPostInfoJSON()
                .getUserPostRepostersById(postID)
                .enqueue(new Callback<PostUsersList>() {
                    @Override
                    public void onResponse(Call<PostUsersList> call, Response<PostUsersList> response) {
                        if (response.isSuccessful()){
                            PostUsersList postUsersList = response.body();
                            List<UserWrapper> users = postUsersList.getData();
                            if(users != null) {
                                Log.i(TAG, "onResponse: " + users);
                                ArrayList<User> list = new ArrayList<>();

                                for (UserWrapper uWrapper : users) {
                                    list.add(new User(uWrapper.getNickname(), uWrapper.getAvatarImage().getUrlSmall()));
                                }
                                Log.i(TAG, "onResponse USERS:" + list + " " + setupDone());
                                model.setRepostUsersList(list);
                                if (setupDone()) view().showRepostersList(list);
                            }
                        } else {
                            Log.i(TAG, "onResponse: is not successful" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostUsersList> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    // метод для отримання інформації про користувачів, що відмічені в пості
    private void getMentionedUsersInfo(int postID){
        NetworkService.getInstance().getUserPostInfoJSON()
                .getMentionedUsersById(postID)
                .enqueue(new Callback<PostUsersList>() {
                    @Override
                    public void onResponse(Call<PostUsersList> call, Response<PostUsersList> response) {
                        if (response.isSuccessful()){
                            PostUsersList postUsersList = response.body();
                            List<UserWrapper> users = postUsersList.getData();
                            if(users != null) {
                                Log.i(TAG, "onResponse: " + users);
                                ArrayList<User> list = new ArrayList<>();

                                for (UserWrapper uWrapper : users) {
                                    list.add(new User(uWrapper.getNickname(), uWrapper.getAvatarImage().getUrlSmall()));
                                }
                                Log.i(TAG, "onResponse USERS:" + list + " " + setupDone());
                                model.setMentionedUsersList(list);
                                if (setupDone()) view().showMentionedList(list);
                            }
                        } else {
                            Log.i(TAG, "onResponse: is not successful" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostUsersList> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    public void onBackButtonClicked() {
        // TODO реалізація бізнес-логіки
        view().showMessage("Button back was clicked");
    }

    // метод створений для виклику в
    private void getPostDataByID(int id){
        getPostInfoByID(id);
        getPostLikersInfo(id);
        getCommentatorsInfo(id);
        getRepostsInfo(id);
        getMentionedUsersInfo(id);
    }

    public void viewStatusResume() {
        updateView();
    }
}
