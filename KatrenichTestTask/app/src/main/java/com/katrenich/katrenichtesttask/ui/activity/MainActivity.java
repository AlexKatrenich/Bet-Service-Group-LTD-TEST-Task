package com.katrenich.katrenichtesttask.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.katrenich.katrenichtesttask.R;
import com.katrenich.katrenichtesttask.presentation.view.MainActivityView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    // ініціалізація елементів екрану
    private void init(Bundle savedInstanceState) {

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
