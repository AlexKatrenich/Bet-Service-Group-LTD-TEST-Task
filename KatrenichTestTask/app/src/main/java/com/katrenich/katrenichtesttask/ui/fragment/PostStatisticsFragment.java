package com.katrenich.katrenichtesttask.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katrenich.katrenichtesttask.R;

/* Клас відображає на екрані першу вкладку BottomNavigationView головного екрану
 * Фрагмент повинен відображати інформацію про статистику обраного посту на сайті 'inrating.top'
 * Перелік користувачів, які: зарепостили, лайкнули, коментували та були відмічені в пості
 */
public class PostStatisticsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
