package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.patshopclient.common.mvvm.model.BaseModel;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.CommunityModel;

/**
 * Created by qiubin on 2020-03-17.
 * Describe: 社区Viewmodel
 */
public class CommunityViewModel extends BaseViewModel<CommunityModel> {
    public CommunityViewModel(@NonNull Application application, CommunityModel model) {
        super(application, model);
    }
}
