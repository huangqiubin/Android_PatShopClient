package com.example.patshopclient.common.config;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;

/**
 * Created by qiubin on 2020-04-04.
 * Describe: 用户的基本信息
 */
public class UserInfoBean {

    private static UserInfoBean instance;

    public static UserInfoBean getInstance() {
        if (instance == null) {
            synchronized (UserInfoBean.class) {
                if (instance == null) {
                    instance = new UserInfoBean();
                }
            }
        }
        return instance;
    }

    private UserInfoBean() {

    }

    public String getUid() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_ID, "");
    }

    //todo 去除默认值
    public String getUname() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_NAME, "18378583473");
    }

    public String getUavator() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_AVATAR, "");
    }

    public String getUphone() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_PHONE, "");
    }

    public String getToken() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_TOKEN, "");
    }

    public String getSessionId() {
        return SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).getString(SPConstant.USER_SESSIONID, "");
    }

    public void saveUid(String uid) {
        if (ObjectUtils.isNotEmpty(uid)) {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_ID, uid);
        } else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_ID);
        }
    }

    public void saveUname(String uname) {
        if (ObjectUtils.isNotEmpty(uname)) {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_NAME, uname);
        } else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_NAME);
        }
    }

    public void saveUavator(String uavator) {
        if (ObjectUtils.isNotEmpty(uavator)) {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_AVATAR, uavator);
        } else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_AVATAR);
        }
    }

    public void saveUphone(String uphone) {
        if (ObjectUtils.isNotEmpty(uphone)) {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_PHONE, uphone);
        } else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_PHONE);
        }
    }

    public void saveTaken(String token) {
        if (ObjectUtils.isNotEmpty(token)) {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_TOKEN, token);
        } else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_TOKEN);
        }
    }

    public void saveSessionId(String sessionId) {
        if (ObjectUtils.isNotEmpty(sessionId)) {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).put(SPConstant.USER_SESSIONID, sessionId);
        } else {
            SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).remove(SPConstant.USER_SESSIONID);
        }
        ;
    }

    public void clearUserInfo() {
        SPUtils.getInstance(SPConstant.USER_LOGIN_FILE).clear(true);
    }
}
