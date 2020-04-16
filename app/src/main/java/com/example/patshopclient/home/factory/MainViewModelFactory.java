package com.example.patshopclient.home.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.home.model.CommunityModel;
import com.example.patshopclient.home.model.MainActivityModel;
import com.example.patshopclient.home.model.MineModel;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;
import com.example.patshopclient.home.viewmodel.MainActivityViewModel;
import com.example.patshopclient.home.viewmodel.MineViewModel;

/**
 * Created by qiubin on 2020-03-11.
 * Describe:
 */
public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile MainViewModelFactory INSTANCE;
    private final Application application;

    public static MainViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (MainViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MainViewModelFactory(application);
                }

            }
        }
        return INSTANCE;
    }

    private MainViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(application, new MainActivityModel(application));
        } else if (modelClass.isAssignableFrom(MineViewModel.class)) {
            return (T) new MineViewModel(application, new MineModel(application));
        }
        return null;
    }
}
