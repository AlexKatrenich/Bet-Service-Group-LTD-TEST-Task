package com.katrenich.katrenichtesttask.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.model.data.User;
import com.katrenich.katrenichtesttask.presentation.presenter.PostStatisticsUsersViewHolderPresenter;
import com.katrenich.katrenichtesttask.ui.view_holder.PostStatisticsUsersViewHolder;

public class PostStatisticsRvAdapter
        extends MvpRecyclerListAdapter<User, PostStatisticsUsersViewHolderPresenter, PostStatisticsUsersViewHolder> {

    @NonNull
    @Override
    protected Object getModelId(User model) {
        return model.getName();
    }

    @NonNull
    @Override
    protected PostStatisticsUsersViewHolderPresenter createPresenter(@NonNull User model) {
        PostStatisticsUsersViewHolderPresenter presenter = new PostStatisticsUsersViewHolderPresenter();
        presenter.setModel(model);
        return presenter;
    }

    @NonNull
    @Override
    public PostStatisticsUsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PostStatisticsUsersViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_rv_fragment_post_statistics_likes, viewGroup, false));
    }
}
