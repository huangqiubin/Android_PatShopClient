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
 * Created by qiubin on 2020-04-15.
 * Describe:
 */
public class CommunityViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile CommunityViewModelFactory INSTANCE;
    private final Application application;

    public static CommunityViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (MainViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CommunityViewModelFactory(application);
                }

            }
        }
        return INSTANCE;
    }

    private CommunityViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CommunityViewModel.class)) {
            return (T) new CommunityViewModel(application, new CommunityModel(application));
        }
        return null;
    }
}
