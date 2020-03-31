package com.example.patshopclient.home.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.home.model.MainActivityModel;
import com.example.patshopclient.home.viewmodel.MainActivityViewModel;

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
        }
        return null;
    }
}
