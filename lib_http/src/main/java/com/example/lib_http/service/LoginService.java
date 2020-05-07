package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.LoginDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020-04-03.
 * Describe:登陆请求接口
 */
public interface LoginService {

    @GET(API.URL_HOST_PATSHOP + "/login/login")
    Call<LoginDTO> getLogin(@Query("username") String username, @Query("password") String password);

}
