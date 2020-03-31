package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.patshopclient.common.mvvm.model.BaseModel;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;

/**
 * Created by qiubin on 2020-03-17.
 * Describe: 社区Viewmodel
 */
public class CommunityViewModel extends BaseViewModel<BaseModel> {
    public CommunityViewModel(@NonNull Application application, BaseModel model) {
        super(application, model);
    }
}
