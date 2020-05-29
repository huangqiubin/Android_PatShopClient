package com.example.lib_http;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.example.lib_http.config.API;
import com.example.lib_http.http.LoginHandlerInterceptor;
import com.example.lib_http.service.ActivityService;
import com.example.lib_http.service.CommunityService;
import com.example.lib_http.service.HomeContentService;
import com.example.lib_http.service.LoginService;
import com.example.lib_http.service.ManageSaleContentService;
import com.example.lib_http.service.MineContentService;
import com.example.lib_http.service.ProductDetailService;
import com.example.lib_http.util.LogUtils;
import com.example.lib_http.util.SSLContextUtil;
import com.example.lib_userinfo.config.UserInfoBean;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Description: <RetrofitManager>
 */
public class RetrofitManager {
    public static RetrofitManager retrofitManager;
    public static Context mContext;
    private Retrofit mRetrofit;
    public String TOKEN;
    OkHttpClient.Builder okHttpBuilder;

    private RetrofitManager() {
        Interceptor interceptor = new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                ResponseBody responseBody = response.body();
                String rBody;
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE);
                Buffer buffer = source.buffer();

                Charset charset = Charset.forName("UTF-8");
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(Charset.forName("UTF-8"));
                    } catch (UnsupportedCharsetException e) {
                        e.printStackTrace();
                    }
                }
                rBody = buffer.clone().readString(charset);
                LogUtils.iTag("http", "url: " + request.url());
                LogUtils.json("http", rBody);
                return response;
            }
        };
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.interceptors().add(new LoginHandlerInterceptor());
        okHttpBuilder.interceptors().add(interceptor);

//        okHttpBuilder.interceptors().add(logging);

        SSLContext sslContext = SSLContextUtil.getDefaultSLLContext();
        if (sslContext != null) {
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            okHttpBuilder.sslSocketFactory(socketFactory);
        }
        addCookie();
        okHttpBuilder.hostnameVerifier(SSLContextUtil.HOSTNAME_VERIFIER);
        mRetrofit = new Retrofit.Builder().client(okHttpBuilder.build()).baseUrl(API.URL_HOST_PATSHOP).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static void init(Application application) {
        mContext = application;
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public void addCookie() {
        if (okHttpBuilder != null)
            okHttpBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    String sessionId = UserInfoBean.getInstance().getSessionId();
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Cookie", "JSESSIONID=" + sessionId);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
    }

    public void addToken(final String token) {
        if (okHttpBuilder != null)
            okHttpBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", "Bearer " + token);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
    }


    /**
     * 创建HomeContentService
     */
    public HomeContentService getHomeContentService() {
        return mRetrofit.create(HomeContentService.class);
    }

    /**
     * 创建商品详情Service
     */
    public ProductDetailService getProductDetailService() {
        return mRetrofit.create(ProductDetailService.class);
    }

    /**
     * 创建首页社区热门话题Service
     */
    public CommunityService getCommunityService() {
        return mRetrofit.create(CommunityService.class);
    }

    /**
     * 创建登陆Service
     */
    public LoginService getLoginService() {
        return mRetrofit.create(LoginService.class);
    }

    /**
     * 创建我的页面Service
     */
    public MineContentService getMineContentService() {
        return mRetrofit.create(MineContentService.class);
    }

    /**
     * 创建活动页面Service
     */
    public ActivityService getActivityService() {
        return mRetrofit.create(ActivityService.class);
    }

    /**
     * 创建商家管理页面Service
     */
    public ManageSaleContentService getManageSaleService() {
        return mRetrofit.create(ManageSaleContentService.class);
    }
}