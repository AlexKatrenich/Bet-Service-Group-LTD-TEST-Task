package com.katrenich.katrenichtesttask.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.presentation.PresenterManager;
import com.katrenich.katrenichtesttask.presentation.presenter.MainActivityPresenter;
import com.katrenich.katrenichtesttask.presentation.view.MainActivityView;
import com.katrenich.katrenichtesttask.ui.fragment.Fragment2;
import com.katrenich.katrenichtesttask.ui.fragment.Fragment3;
import com.katrenich.katrenichtesttask.ui.fragment.Fragment4;
import com.katrenich.katrenichtesttask.ui.fragment.Fragment5;
import com.katrenich.katrenichtesttask.ui.fragment.PostStatisticsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private static final String TAG_SAVE_INSTANCE_STATE_BOTTOM_NAVIGATION = "INSTANCE_STATE_BOTTOM_NAVIGATION";

    private MainActivityPresenter mPresenter;

    private int bnvSelectedItemId; // ІД елементу обраного в BottomNavigationView

    @BindView(R.id.main_activity_toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.bnv_main_activity)
    protected BottomNavigationView mNavigationView; // посилання на об'єкт нижньої панелі навігації на екрані

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    // ініціалізація елементів екрану
    private void init(Bundle savedInstanceState) {

        // створення нового або відновлення презентера
        if (savedInstanceState == null){
            mPresenter = new MainActivityPresenter();
        } else {
            mPresenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
            bnvSelectedItemId = savedInstanceState.getInt(TAG_SAVE_INSTANCE_STATE_BOTTOM_NAVIGATION, 0);
        }

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(""); // Видалення заговку по замовчуванню в ActionBar

        if (bnvSelectedItemId == 0) bindFragment(new PostStatisticsFragment());

        // опрацювання кліку по елементам BottomNavigationView
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.item_post_statistics :
                        bindFragment(new PostStatisticsFragment());
                        return true;
                    case R.id.item_fragment2 :
                        bindFragment(new Fragment2());
                        return true;
                    case R.id.item_fragment3 :
                        bindFragment(new Fragment3());
                        return true;
                    case R.id.item_fragment4 :
                        bindFragment(new Fragment4());
                        return true;
                    case R.id.item_fragment5 :
                        bindFragment(new Fragment5());
                        return true;
                    default :
                        return false;
                }
            }
        });
    }

    // метод для відображення вказано фрагменту в контейнері фрагментів головного екрану
    public void bindFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_main_activity, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        mPresenter.bindView(this); // закріплення презентера
        super.onStart();
    }

    @Override
    protected void onResume() {
        if(bnvSelectedItemId != 0 ){
            mNavigationView.setSelectedItemId(bnvSelectedItemId);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        bnvSelectedItemId = mNavigationView.getSelectedItemId();
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        PresenterManager.getInstance().savePresenter(mPresenter, outState);

        //зберігання стану BottomNavigationView
        outState.putInt(TAG_SAVE_INSTANCE_STATE_BOTTOM_NAVIGATION, bnvSelectedItemId);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        mPresenter.unbindView();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // обнулення посилань
        mNavigationView.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }

    @OnClick(R.id.ib_toolbar_refresh)
    public void onRefreshButtonClicked(){
        //TODO реалізація обробки кліку по кнопці
        showMessage("On refresh button clicked");
    }

    @OnClick(R.id.tv_toolbar_button_done)
    public void onDoneButtonClicked(){
        //TODO реалізація обробки кліку по кнопці
        showMessage("On done button clicked");
    }

    @Override
    public void showMessage(String message) {
        if (message != null && !message.equals("")) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
