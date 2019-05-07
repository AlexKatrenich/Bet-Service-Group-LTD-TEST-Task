package com.katrenich.katrenichtesttask.ui.view_holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.katrenich.katrenichtesttask.presentation.BasePresenter;

public abstract class MvpViewHolder <P extends BasePresenter> extends RecyclerView.ViewHolder{
    private P presenter;

    public MvpViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bindPresenter(P presenter){
        this.presenter = presenter;
        presenter.bindView(this);
    }

    public void unbindPresenter(){
        presenter = null;
    }
}
