package com.katrenich.katrenichtesttask.presentation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M, V>{
    public static final String TAG = "BasePresenter";
    protected M model;
    private WeakReference<V> view;

    /* отримання та фіксація посилання на модель(об'єкт, список об'єктів), яку повинна відображати View*/
    public void setModel(M model) {
        this.model = model;
        if (setupDone()){
            updateView();
        }
    }

    /* метод для фіксації полсилання(WeakReference) на View, перевірка актуальності View/Model та перевідображення даних на екрані*/
    public void bindView(@NonNull V view){
        this.view = new WeakReference<>(view);
        if(setupDone()){
            updateView();
        }
        Log.i(TAG, "bindView: ");
    }

    /* метод для відкріплення посилання на View*/
    public void unbindView(){
        this.view = null;
    }

    /* метод для отримання посилання на View якщо вона не знищена GarbageCollector*/
    @Nullable
    protected V view() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    /* метод для перевірки актуальності посилань на View(Екран) та модель*/
    protected boolean setupDone() {
        return view() != null && model != null ;
    }

    /* бізнес-логіка в презентері, наприклад виклик методів для "пере-відображення" списку об'єктів на View*/
    protected abstract void updateView();

}
