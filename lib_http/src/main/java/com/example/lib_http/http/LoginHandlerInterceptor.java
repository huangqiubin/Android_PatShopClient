package com.example.lib_http.http;

import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by qiubin on 2020-05-03.
 * Describe:
 */
public class LoginHandlerInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        Log.i("http", "responseBody" + responseBody.toString());
        Log.i("http", "contentLength: " + contentLength);
        //服务端拦截了未登录用户请求
        if (contentLength == 0) {
            ARouter.getInstance().build("/login/activity/login_activity")
                    .withBoolean("fromRequest", true)
                    .navigation();

        }
        return response;
    }
}
