package com.katrenich.katrenichtesttask.ui.fragment;


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
import com.katrenich.katrenichtesttask.presentation.PresenterManager;
import com.katrenich.katrenichtesttask.presentation.presenter.PostStatisticsFragmentPresenter;
import com.katrenich.katrenichtesttask.presentation.view.PostStatisticsView;

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
    protected RecyclerView mRvMentioned; // список прокрутки користувачів, що відмічені в пості
    protected PostStatisticsRvAdapter mListMarksAdapter;

    @BindView(R.id.rv_fragment_post_repost_users)
    protected RecyclerView mRvReposters; // список користувачів, що зробили репост
    protected PostStatisticsRvAdapter mListRepostersAdapter;

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
    protected TextView countMentionedUsers;

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
            Log.i(TAG, "init: savedInstanceState == null");
            mPresenter = new PostStatisticsFragmentPresenter();
        } else {
            mPresenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
            Log.i(TAG, "init: restore presenter ");
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
        mRvMentioned.setAdapter(mListMarksAdapter);
        mRvMentioned.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Блок закладок
        mListRepostersAdapter = new PostStatisticsRvAdapter();
        mRvReposters.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvReposters.setAdapter(mListRepostersAdapter);

    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart: " + this);
        mPresenter.bindView(this);
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: " + this);
        mPresenter.viewStatusResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: " + this);
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: " + this);
        mPresenter.unbindView();
        super.onStop();

    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: " + this);
        // обнулення посилань
        mRvMentioned.setLayoutManager(null);
        mRvMentioned.setAdapter(null);
        mRvComments.setLayoutManager(null);
        mRvComments.setAdapter(null);
        mRvLikes.setAdapter(null);
        mRvLikes.setLayoutManager(null);
        mRvReposters.setLayoutManager(null);
        mRvReposters.setAdapter(null);
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
//        /*-------------------------------------*/
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle("Введіть ІД поста");
//
//        final EditText input = new EditText(getContext());
//        input.setInputType(InputType.TYPE_CLASS_NUMBER);
//        builder.setView(input);
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                 String id = input.getText().toString();
//
//                 int postID = Integer.valueOf(id);
//                 mPresenter.getPostDataByID(postID);
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        builder.show();
        /*-------------------------------------*/

    }

    @Override
    public void showLikesList(List<User> list) {
        ViewGroup.LayoutParams params = mRvLikes.getLayoutParams();
        if (list.size() > 0) {
            Log.i(TAG, "showLikesList: " + list);
            mListLikesAdapter.clearAndAddAll(list);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }

        usersLikesCount.setText(String.valueOf(list.size()));
        mRvLikes.setLayoutParams(params);
    }

    @Override
    public void showCommentatorsList(List<User> list) {
        ViewGroup.LayoutParams params = mRvComments.getLayoutParams();
        if(list.size() > 0) {
            Log.i(TAG, "showCommentatorsList: " + list);
            mListCommentatorsAdapter.clearAndAddAll(list);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }
        postCommentatorsCount.setText(String.valueOf(list.size()));
        mRvComments.setLayoutParams(params);
    }

    @Override
    public void showMentionedList(List<User> list) {
        ViewGroup.LayoutParams params = mRvMentioned.getLayoutParams();
        if (list.size() > 0){
            Log.i(TAG, "showMentionedList: " + list);
            mListMarksAdapter.clearAndAddAll(list);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }
        countMentionedUsers.setText(String.valueOf(list.size()));
        mRvMentioned.setLayoutParams(params);
    }

    @Override
    public void showRepostersList(List<User> list) {
        ViewGroup.LayoutParams params = mRvReposters.getLayoutParams();
        if(list.size() > 0){
            Log.i(TAG, "showRepostersList: " + list);
            mListRepostersAdapter.clearAndAddAll(list);
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.recycler_view_post_statistics_height),
                    getResources().getDisplayMetrics());
        } else {
            params.height = 0;
        }

        repostCount.setText(String.valueOf(list.size()));
        mRvReposters.setLayoutParams(params);
    }

    @Override
    public void showCountViews(int count) {
        usersViewCount.setText(String.valueOf(count));
    }

    @Override
    public void showCountBookmarks(int count) {
        bookmarksCount.setText(String.valueOf(count));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


}
