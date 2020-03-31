package com.example.patshopclient.home.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.home.model.CommunityModel;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;

/**
 * Created by qiubin on 2020-03-17.
 * Describe:
 */
public class CommunityModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile CommunityModelFactory INSTANCE;
    private final Application application;

    public static CommunityModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (CommunityModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CommunityModelFactory(application);
                }

            }
        }
        return INSTANCE;
    }

    public CommunityModelFactory(Application application) {
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
