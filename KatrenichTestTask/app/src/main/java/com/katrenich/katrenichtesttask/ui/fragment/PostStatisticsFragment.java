package com.katrenich.katrenichtesttask.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.adapters.PostStatisticsRvAdapter;
import com.katrenich.katrenichtesttask.model.data.User;
import com.katrenich.katrenichtesttask.model.data.UserPostInfo;
import com.katrenich.katrenichtesttask.presentation.PresenterManager;
import com.katrenich.katrenichtesttask.presentation.presenter.PostStatisticsFragmentPresenter;
import com.katrenich.katrenichtesttask.presentation.view.PostStatisticsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* Клас відображає на екрані першу вкладку BottomNavigationView головного екрану
 * Фрагмент повинен відображати інформацію про статистику обраного посту на сайті 'inrating.top'
 * Перелік користувачів, які: зарепостили, лайкнули, коментували та були відмічені в пості
 */
public class PostStatisticsFragment extends Fragment implements PostStatisticsView {
    private static final String TAG = "PostStatisticsFragment";


    private PostStatisticsFragmentPresenter mPresenter;

    @BindView(R.id.rv_fragment_post_statistics_likes)
    protected RecyclerView mRvLikes; // список прокрутки користувачів, що лайкнули пост
    protected PostStatisticsRvAdapter mListLikesAdapter;

    @BindView(R.id.rv_fragment_post_statistics_comments)
    protected RecyclerView mRvComments; // список прокрутки користувачів, що прокоментували пост
    protected PostStatisticsRvAdapter mListCommentatorsAdapter;

    @BindView(R.id.rv_fragment_post_statistics_marks)
    protected RecyclerView mRvMarks; // список прокрутки користувачів, що відмічені в пості
    protected PostStatisticsRvAdapter mListMarksAdapter;

    @BindView(R.id.rv_fragment_post_statistics_bookmarks)
    protected RecyclerView mRvBookmarks; // список користувачів, що додали пост в закладки
    protected PostStatisticsRvAdapter mListBookmarksAdapter;

    @BindView(R.id.tv_count_users_view)
    protected TextView usersViewCount;

    @BindView(R.id.tv_count_users_like)
    protected TextView usersLikesCount;

    @BindView(R.id.tv_count_users_repost)
    protected TextView repostCount;

    @BindView(R.id.tv_count_users_comment)
    protected TextView postCommentatorsCount;

    @BindView(R.id.tv_count_users_bookmark)
    protected TextView bookmarksCount;

    @BindView(R.id.tv_count_users_mark)
    protected TextView conutMentionedUsers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init(savedInstanceState, view);
    }

    private void init(Bundle savedInstanceState, View view) {
        if (savedInstanceState == null){
            mPresenter = new PostStatisticsFragmentPresenter();
        } else {
            mPresenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        // Блок лайків
        mListLikesAdapter = new PostStatisticsRvAdapter();
        mRvLikes.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvLikes.setAdapter(mListLikesAdapter);

        // Блок коментаторів
        mListCommentatorsAdapter = new PostStatisticsRvAdapter();
        mRvComments.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvComments.setAdapter(mListCommentatorsAdapter);

        // Блок відміток
        mListMarksAdapter = new PostStatisticsRvAdapter();
        mRvMarks.setAdapter(mListMarksAdapter);
        mRvMarks.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Блок закладок
        mListBookmarksAdapter = new PostStatisticsRvAdapter();
        mRvBookmarks.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvBookmarks.setAdapter(mListBookmarksAdapter);

        /*--------------TEST------------*/
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.picture_no_photo_aviable);
        ArrayList<User> users = new ArrayList<>();
        Log.i(TAG, "init: " + users);
        users.add(new User("Alex", bm));
        users.add(new User("Jersi", bm));
        users.add(new User("Tupish", bm));
        showLikesList(users);

        users.add(new User("Stefani", bm));
        users.add(new User("Adam", bm));
        users.add(new User("Alex", bm));
        users.add(new User("Jersi", bm));
        users.add(new User("Tupish", bm));
        users.remove(1);
        users.remove(2);
        Log.i(TAG, "init: " + users);
        showCommentatorsList(users);


        users.add(new User("Pamella", bm));
        users.add(new User("Perkamur", bm));
        users.add(new User("Alesya", bm));
        users.add(new User("Olga", bm));
        Log.i(TAG, "init: " + users);
        showMarksList(users);

        showBookmarksList(users);
        /*-----------END TEST-----------*/

    }

    @Override
    public void onStart() {
        mPresenter.bindView(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.unbindView();
    }

    @Override
    public void onDestroy() {
        // обнулення посилань
        mRvMarks.setLayoutManager(null);
        mRvMarks.setAdapter(null);
        mRvComments.setLayoutManager(null);
        mRvComments.setAdapter(null);
        mRvLikes.setAdapter(null);
        mRvLikes.setLayoutManager(null);
        mRvBookmarks.setLayoutManager(null);
        mRvBookmarks.setAdapter(null);
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(mPresenter, outState);
    }

    @OnClick(R.id.ib_post_statistics_fragment_button_back)
    public void onBackButtonClicked(){
        mPresenter.onBackButtonClicked();
    }

    @Override
    public void showLikesList(List<User> likes) {
        ViewGroup.LayoutParams params = mRvLikes.getLayoutParams();
        if (likes.size() > 0) {
            Log.d(TAG, "showLikesList: " + likes);
            mListLikesAdapter.clearAndAddAll(likes);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }

        mRvLikes.setLayoutParams(params);
    }

    @Override
    public void showCommentatorsList(List<User> commentators) {
        ViewGroup.LayoutParams params = mRvComments.getLayoutParams();
        if(commentators.size() > 0) {
            Log.i(TAG, "showCommentatorsList: " + commentators);
            mListCommentatorsAdapter.clearAndAddAll(commentators);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }
        mRvComments.setLayoutParams(params);
    }

    @Override
    public void showMarksList(List<User> marks) {
        ViewGroup.LayoutParams params = mRvMarks.getLayoutParams();
        if (marks.size() > 0){
            Log.i(TAG, "showMarksList: " + marks);
            mListMarksAdapter.clearAndAddAll(marks);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }
        mRvMarks.setLayoutParams(params);
    }

    @Override
    public void showBookmarksList(List<User> bookmarks) {
        ViewGroup.LayoutParams params = mRvBookmarks.getLayoutParams();
        if(bookmarks.size() > 0){
            Log.i(TAG, "showBookmarksList: " + bookmarks);
            mListBookmarksAdapter.clearAndAddAll(bookmarks);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }
        mRvBookmarks.setLayoutParams(params);
    }

    @Override
    public void showMainInfo(UserPostInfo postInfo) {
        // відображення значень з моделі даних в UI
        usersViewCount.setText(String.valueOf(postInfo.getViewsCount()));
        usersLikesCount.setText(String.valueOf(postInfo.getLikesCount()));
        postCommentatorsCount.setText(String.valueOf(postInfo.getCommentatorsCount()));
        repostCount.setText(String.valueOf(postInfo.getRepostsCount()));
        bookmarksCount.setText(String.valueOf(postInfo.getBookmarksCount()));
        conutMentionedUsers.setText(String.valueOf(postInfo.getMentionedUserCount()));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
