package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.ActivityContentDTO;
import com.example.lib_http.entity.home.SignInDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020-05-05.
 * Describe: 活动页面请求接口
 */
public interface ActivityService {

    @GET(API.URL_HOST_PATSHOP + "/activity/activity_content")
    Observable<ActivityContentDTO> getActivityContent(@Query("userName") String userName);

    @GET(API.URL_HOST_PATSHOP + "/activity/sign_in")
    Observable<SignInDTO> getSignIn();
}
