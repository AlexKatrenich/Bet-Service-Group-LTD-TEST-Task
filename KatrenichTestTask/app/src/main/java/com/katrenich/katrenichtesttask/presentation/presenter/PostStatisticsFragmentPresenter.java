package com.katrenich.katrenichtesttask.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.katrenich.katrenichtesttask.model.data.UserPostInfo;
import com.katrenich.katrenichtesttask.model.network.NetworkService;
import com.katrenich.katrenichtesttask.model.network.user_post_statistics.PostInfoWrapper;
import com.katrenich.katrenichtesttask.model.network.user_post_statistics.PostLikersList;
import com.katrenich.katrenichtesttask.model.network.user_post_statistics.UserWrapper;
import com.katrenich.katrenichtesttask.presentation.BasePresenter;
import com.katrenich.katrenichtesttask.presentation.view.PostStatisticsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostStatisticsFragmentPresenter extends BasePresenter<UserPostInfo, PostStatisticsView> {
    public static final String TAG = "PostStatFragPresenter";

    @Override
    protected void updateView() {
        // Оновлення основної інформації про пост
        view().showMainInfo(model);
    }

    @Override
    public void bindView(@NonNull PostStatisticsView view) {
        super.bindView(view);
        getPostInfo();
    }

    private void getPostInfo() {
        // отримання основної інформації про пост
        NetworkService.getInstance()
                .getUserPostInfoJSON()
                .getUserPostInfoBySlug("AhA7JKV89m6P")
                .enqueue(new Callback<PostInfoWrapper>() {
                    @Override
                    public void onResponse(Call<PostInfoWrapper> call, Response<PostInfoWrapper> response) {
                        if (response.isSuccessful()){
                            PostInfoWrapper postStatistics = response.body();
                            Log.i(TAG, "onResponse: " + postStatistics);
                            try {
                                UserPostInfo postInfo = new UserPostInfo(
                                        postStatistics.getId(),
                                        postStatistics.getSlug(),
                                        postStatistics.getCommentsCount(),
                                        postStatistics.getLikesCount(),
                                        postStatistics.getBookmarksCount(),
                                        postStatistics.getRepostsCount(),
                                        postStatistics.getViewsCount()
                                );
                                setModel(postInfo);
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

        // Отримання інформації
    }

    public void onBackButtonClicked() {
        // TODO реалізація бізнес-логіки
//        view().showMessage("Back-button was clicked");

        NetworkService.getInstance().getUserPostInfoJSON()
                .getUserPostLikersInfoById(6825)
                .enqueue(new Callback<PostLikersList>() {
                    @Override
                    public void onResponse(Call<PostLikersList> call, Response<PostLikersList> response) {
                        if (response.isSuccessful()){
                            PostLikersList postLikersList = response.body();
                            if(postLikersList.getData() != null) Log.i(TAG, "onResponse: " + postLikersList.getData());
                        } else {
                            Log.i(TAG, "onResponse: is not successful" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostLikersList> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

}
