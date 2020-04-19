package com.example.patshopclient;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;

import cn.jiguang.verifysdk.api.JVerificationInterface;

/**
 * Created by qiubin on 2020-03-26.
 * Describe:
 */
public class MyApplication extends Application {
    Context context;
    public static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        context = getApplicationContext();
        if ((AppUtils.isAppDebug())) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            LogUtils.getConfig().setLogSwitch(true);
        }else {
            LogUtils.getConfig().setLogSwitch(false);
        }
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化
        JVerificationInterface.init(context);
        JVerificationInterface.setDebugMode(AppUtils.isAppDebug());

    }

}
