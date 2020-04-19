package com.example.patshopclient.home.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.home.model.ActivityModel;
import com.example.patshopclient.home.model.CommunityModel;
import com.example.patshopclient.home.viewmodel.ActivityViewModel;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;

/**
 * Created by qiubin on 2020-04-15.
 * Describe:
 */
public class ActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ActivityViewModelFactory INSTANCE;
    private final Application application;

    public static ActivityViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ActivityViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ActivityViewModelFactory(application);
                }

            }
        }
        return INSTANCE;
    }

    private ActivityViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ActivityViewModel.class)) {
            return (T) new ActivityViewModel(application, new ActivityModel(application));
        }
        return null;
    }
}
