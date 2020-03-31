package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.MineModel;

/**
 * Created by qiubin on 2020-03-15.
 * Describe: 首页 我的 viewmodel
 */
public class MineViewModel extends BaseViewModel<MineModel> {

    public static String TAG = MineViewModel.class.getSimpleName();
//    private SingleLiveEvent<HomeContentDTO> homeContentLiveEvent;
    public MineViewModel(@NonNull Application application, MineModel model) {
        super(application, model);
    }

}
