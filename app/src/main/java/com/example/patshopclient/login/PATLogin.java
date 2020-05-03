package com.example.patshopclient.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.lib_http.RetrofitManager;
import com.example.patshopclient.common.config.BaseData;
import com.example.patshopclient.common.config.ServerConfig;
import com.example.patshopclient.common.config.UserInfoBean;
import com.example.patshopclient.login.activity.LoginActivity;

/**
 * Created by qiubin on 2020-04-03.
 * Describe:拍拍乐 登陆类
 */
public class PATLogin {

    /**
     * 检查是否登陆
     * @return
     */
    public static boolean checkLoginState(){
        String account = SPUtils.getInstance(ServerConfig.COMMONE_FILE).getString(BaseData.userPhone, "");
        if (ObjectUtils.isNotEmpty(account)){
            return true;
        }
        return false;
    }

    /**
     * 退出登录
     */
    public static void quitLogin(){
    }

    /**
     * 去登陆界面
     * @param activity
     */
    public static void gotoLogin(Activity activity){
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }




    interface LoginCallBack{
        void succes();

        void fail();
    }


}
