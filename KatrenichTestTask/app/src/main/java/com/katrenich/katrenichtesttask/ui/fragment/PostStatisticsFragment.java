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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.adapters.PostStatisticsRvAdapter;
import com.katrenich.katrenichtesttask.model.data.User;
import com.katrenich.katrenichtesttask.model.data.UserPostInfo;
import com.katrenich.katrenichtesttask.presentation.PresenterManager;
import com.katrenich.katrenichtesttask.presentation.presenter.PostStatisticsFragmentPresenter;
import com.katrenich.katrenichtesttask.presentation.view.PostStatisticsView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        /*--------------TEST------------*/
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.picture_no_photo_aviable);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Stefani", bm));
        users.add(new User("Adam", bm));
        users.add(new User("Alex", bm));
        users.add(new User("Jersi", bm));
        users.add(new User("Tupish", bm));
        showLikesList(users);

        users.remove(1);
        users.remove(2);
        showCommentatorsList(users);

        users.add(new User("Pamella", bm));
        users.add(new User("Perkamur", bm));
        users.add(new User("Alesya", bm));
        users.add(new User("Olga", bm));
        showMarksList(users);
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
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(mPresenter, outState);
    }

    @Override
    public void showLikesList(List<User> likes) {
        Log.d(TAG, "showLikesList: " + likes);
        mListLikesAdapter.clearAndAddAll(likes);
    }

    @Override
    public void showCommentatorsList(List<User> commentators) {
        Log.i(TAG, "showCommentatorsList: " + commentators);
        mListCommentatorsAdapter.clearAndAddAll(commentators);
    }

    @Override
    public void showMarksList(List<User> marks) {
        Log.i(TAG, "showMarksList: " + marks);
        mListMarksAdapter.clearAndAddAll(marks);
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
}
