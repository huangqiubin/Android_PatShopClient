package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.lib_http.entity.home.HomeBidProductDTO;
import com.example.lib_http.entity.home.HomeContentDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.MainActivityModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiubin on 2020-03-11.
 * Describe: MainActivity处理业务逻辑的地方
 */
public class MainActivityViewModel extends BaseViewModel<MainActivityModel> {

    public static String TAG = MainActivityViewModel.class.getSimpleName();
    private SingleLiveEvent<HomeContentDTO> homeContentLiveEvent;
    private SingleLiveEvent<HomeBidProductDTO> homeBidProductLiveEvent;
    private SingleLiveEvent<HomeBidProductDTO> homeHotBidSingleLiveEvent;

    public MainActivityViewModel(@NonNull Application application, MainActivityModel model) {
        super(application, model);
    }

    /**
     * 获取首页内容
     */
    public void httpGetContent() {
        mModel.getHomeContent().subscribe(new Observer<HomeContentDTO>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeContentDTO homeContentDTO) {
                getHomeContentLiveEvent().postValue(homeContentDTO);
            }

            @Override
            public void onError(Throwable e) {
                getUC().getShowNoDataViewEvent().postValue(true);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 获取首页分类拍品
     */
    public void httpGetBidProduct(String categoryName) {
        mModel.getHomeBidProduct(categoryName).subscribe(new Observer<HomeBidProductDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeBidProductDTO homeBidProductDTO) {
                getHomeBidProductLiveEvent().postValue(homeBidProductDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 获取首页热门拍品
     */
    public void httpGetHotBid() {
        mModel.getHomeHotBid().subscribe(new Observer<HomeBidProductDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeBidProductDTO homeBidProductDTO) {
                getHomeHotBidSingleLiveEvent().postValue(homeBidProductDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public SingleLiveEvent<HomeContentDTO> getHomeContentLiveEvent() {
        return homeContentLiveEvent = createLiveData(homeContentLiveEvent);
    }

    public SingleLiveEvent<HomeBidProductDTO> getHomeBidProductLiveEvent() {
        return homeBidProductLiveEvent = createLiveData(homeBidProductLiveEvent);
    }

    public SingleLiveEvent<HomeBidProductDTO> getHomeHotBidSingleLiveEvent() {
        return homeHotBidSingleLiveEvent = createLiveData(homeHotBidSingleLiveEvent);
    }
}
