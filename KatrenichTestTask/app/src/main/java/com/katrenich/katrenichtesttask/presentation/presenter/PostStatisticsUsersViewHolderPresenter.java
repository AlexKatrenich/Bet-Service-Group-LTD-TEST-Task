package com.katrenich.katrenichtesttask.presentation.presenter;


import com.katrenich.katrenichtesttask.model.data.User;
import com.katrenich.katrenichtesttask.presentation.BasePresenter;
import com.katrenich.katrenichtesttask.presentation.view.RecyclerViewListItem;

public class PostStatisticsUsersViewHolderPresenter extends BasePresenter<User, RecyclerViewListItem> {

    @Override
    protected void updateView() {
        view().setUserAvatar(model.getUserAvatar());
        view().setUserName(model.getName());
    }
}
