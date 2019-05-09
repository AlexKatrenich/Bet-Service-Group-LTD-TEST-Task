package com.katrenich.katrenichtesttask.ui.view_holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.presentation.presenter.PostStatisticsUsersViewHolderPresenter;
import com.katrenich.katrenichtesttask.presentation.view.RecyclerViewListItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostStatisticsUsersViewHolder extends MvpViewHolder<PostStatisticsUsersViewHolderPresenter>
            implements RecyclerViewListItem {

    public static final String TAG = "PostStatisticsUsersVH";

    private Context mContext;

    @BindView(R.id.iv_post_statistics_picture_rv_item)
    protected ImageView mUserAvatar;

    @BindView(R.id.tv_post_statistics_caption_rv_item)
    protected TextView mUserName;

    public PostStatisticsUsersViewHolder(@NonNull View view) {
        super(view);
        mContext = view.getContext();
        ButterKnife.bind(this, view);
    }

    @Override
    public void setUserAvatar(@NonNull String userAvatarURL) {
        Log.i(TAG, "setUserAvatarImageURL:" + userAvatarURL);
        Glide.with(mContext)
                .load(userAvatarURL)
                .placeholder(R.drawable.picture_no_photo_aviable)
                .into(mUserAvatar);
    }

    @Override
    public void setUserName(@NonNull String userName) {
        Log.i(TAG, "setUserName: " + userName);
        mUserName.setText(userName);
    }
}
