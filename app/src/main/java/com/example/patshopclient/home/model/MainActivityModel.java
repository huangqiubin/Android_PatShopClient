package com.example.patshopclient.home.model;

import android.app.Application;

import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.HomeBidProductDTO;
import com.example.lib_http.entity.home.HomeContentDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.HomeContentService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Created by qiubin on 2020-03-11.
 * Describe: MainActivity请求网络获取数据
 */
public class MainActivityModel extends BaseModel {


    private HomeContentService homeContentService;


    public MainActivityModel(Application application) {
        super(application);
        homeContentService = RetrofitManager.getInstance().getHomeContentService();
    }

    public Observable<HomeContentDTO> getHomeContent() {
        return homeContentService.getHomeContent().compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<HomeBidProductDTO> getHomeBidProduct(String categoryName) {
        return homeContentService.getHomeBidProduct(categoryName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<HomeBidProductDTO> getHomeHotBid() {
        return homeContentService.getHomeHotBid().compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }
}
