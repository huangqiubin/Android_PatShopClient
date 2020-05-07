package com.example.patshopclient.home.model;

import android.app.Application;

import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.ActivityContentDTO;
import com.example.lib_http.entity.home.SignInDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.ActivityService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Created by qiubin on 2020-04-05.
 * Describe:
 */
public class ActivityModel extends BaseModel {
    ActivityService activityService;

    public ActivityModel(Application application) {
        super(application);
        activityService = RetrofitManager.getInstance().getActivityService();
    }

    public Observable<ActivityContentDTO> getActivityContent(String userName){
        return activityService.getActivityContent(userName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<SignInDTO> getSignIn(){
        return activityService.getSignIn().compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }
}
