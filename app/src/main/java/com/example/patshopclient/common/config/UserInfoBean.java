package com.example.patshopclient.common.config;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;

/**
 * Created by qiubin on 2020-04-04.
 * Describe:
 */
public class UserInfoBean {

    private String uid;
    private String uname;
    private String uavator;
    private String uphone;
    private String token;

    public String getUid() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_ID, "");
    }

    public String getUname() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_NAME, "");
    }

    public String getUavator() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_AVATOR, "");
    }

    public String getUphone() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_PHONE, "");
    }

    public String getToken() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_TOKEN, "");
    }

    public void saveUid(String uid){
        if (ObjectUtils.isNotEmpty(uid)){
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_ID, uid);
        }else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_ID);
        }
    }

    public void saveUname(String uname){
        if (ObjectUtils.isNotEmpty(uname)){
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_NAME, uname);
        }else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_NAME);
        }
    }

    public void saveUavator(String uavator){
        if (ObjectUtils.isNotEmpty(uavator)){
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_AVATOR, uavator);
        }else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_AVATOR);
        }
    }

    public void saveUphone(String uphone){
        if (ObjectUtils.isNotEmpty(uphone)){
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_PHONE, uphone);
        }else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_PHONE);
        }
    }

    public void saveTaken(String token){
        if (ObjectUtils.isNotEmpty(token)){
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_TOKEN, token);
        }else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_TOKEN);
        }
    }
}
