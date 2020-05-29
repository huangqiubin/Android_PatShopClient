package com.example.patshopclient.home.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.home.model.ManageSaleModel;
import com.example.patshopclient.home.viewmodel.ManageSaleViewModel;

/**
 * Created by qiubin on 2020-03-11.
 * Describe:
 */
public class ManageSaleViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ManageSaleViewModelFactory INSTANCE;
    private final Application application;

    public static ManageSaleViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ManageSaleViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ManageSaleViewModelFactory(application);
                }

            }
        }
        return INSTANCE;
    }

    private ManageSaleViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ManageSaleViewModel.class)) {
            return (T) new ManageSaleViewModel(application, new ManageSaleModel(application));
        }
        return null;
    }
}
