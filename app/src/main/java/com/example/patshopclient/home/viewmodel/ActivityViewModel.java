package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.ActivityModel;

/**
 * Created by qiubin on 2020-04-05.
 * Describe:
 */
public class ActivityViewModel extends BaseViewModel<ActivityModel> {
    public ActivityViewModel(@NonNull Application application, ActivityModel model) {
        super(application, model);
    }
}
