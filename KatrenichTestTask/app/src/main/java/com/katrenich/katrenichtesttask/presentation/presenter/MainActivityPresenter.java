package com.katrenich.katrenichtesttask.presentation.presenter;

import com.katrenich.katrenichtesttask.presentation.BasePresenter;
import com.katrenich.katrenichtesttask.presentation.view.MainActivityView;

public class MainActivityPresenter extends BasePresenter<Void, MainActivityView> {

    @Override
    protected void updateView() {
        // TODO реалізація оновлення даних на екрані
    }

    public void onRefreshButtonClicked() {
        // TODO реалізація бізнес-логіки
        view().showMessage("Refresh-button was clicked");
    }

    public void onDoneButtonClicked() {
        // TODO реалізація бізнес-логіки
        view().showMessage("Done-button was clicked");
    }
}
