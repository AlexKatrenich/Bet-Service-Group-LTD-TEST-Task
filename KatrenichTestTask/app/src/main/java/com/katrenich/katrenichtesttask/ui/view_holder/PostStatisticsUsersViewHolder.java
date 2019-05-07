package com.katrenich.katrenichtesttask.ui.view_holder;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.presentation.presenter.PostStatisticsUsersViewHolderPresenter;
import com.katrenich.katrenichtesttask.presentation.view.RecyclerViewListItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostStatisticsUsersViewHolder extends MvpViewHolder<PostStatisticsUsersViewHolderPresenter>
            implements RecyclerViewListItem {

    public static final String TAG = "PostStatisticsUsersVH";

    @BindView(R.id.iv_post_statistics_picture_rv_item)
    protected ImageView mUserAvatar;

    @BindView(R.id.tv_post_statistics_caption_rv_item)
    protected TextView mUserName;

    public PostStatisticsUsersViewHolder(@NonNull View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    @Override
    public void setUserAvatar(@NonNull Bitmap userAvatar) {
        Log.i(TAG, "setUserAvatar:");
        mUserAvatar.setImageBitmap(userAvatar);
    }

    @Override
    public void setUserName(@NonNull String userName) {
        Log.i(TAG, "setUserName: " + userName);
        mUserName.setText(userName);
    }
}
