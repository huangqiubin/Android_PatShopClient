package com.example.patshopclient.home.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.home.model.MainActivityModel;
import com.example.patshopclient.home.model.ProductDetailModel;
import com.example.patshopclient.home.viewmodel.MainActivityViewModel;
import com.example.patshopclient.home.viewmodel.ProductDetailViewModel;

/**
 * Created by qiubin on 2020-03-11.
 * Describe:
 */
public class ProductDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ProductDetailViewModelFactory INSTANCE;
    private final Application application;

    public static ProductDetailViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ProductDetailViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductDetailViewModelFactory(application);
                }

            }
        }
        return INSTANCE;
    }

    private ProductDetailViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProductDetailViewModel.class)) {
            return (T) new ProductDetailViewModel(application, new ProductDetailModel(application));
        }
        return null;
    }
}
