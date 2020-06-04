package com.example.patshopclient.home.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.lib_http.entity.home.BidSaleDTO;
import com.example.lib_http.entity.home.BidSaleListDTO;
import com.example.lib_http.entity.home.LogoutDTO;
import com.example.lib_http.entity.home.MineContentDTO;
import com.example.lib_http.entity.home.OnLookListDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.MineModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiubin on 2020-03-15.
 * Describe: 首页 我的 viewmodel
 */
public class MineViewModel extends BaseViewModel<MineModel> {

    public static String TAG = MineViewModel.class.getSimpleName();
    private SingleLiveEvent<MineContentDTO> mineContentLiveEvent;
    private SingleLiveEvent<BidSaleDTO> bidSaleListLiveEvent;
    private SingleLiveEvent<OnLookListDTO> onLookListLiveEvent;
    private SingleLiveEvent<LogoutDTO> logoutLiveEvent;

    public MineViewModel(@NonNull Application application, MineModel model) {
        super(application, model);
    }

    public void getMineContent(String userName) {
        mModel.getMineContent(userName).subscribe(new Observer<MineContentDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MineContentDTO mineContentDTO) {
                getMineContentLiveEvent().postValue(mineContentDTO);
            }

            @Override
            public void onError(Throwable e) {
                getUC().getShowNetWorkErrViewEvent().postValue(true);
            }

            @Override
            public void onComplete() {
            }
        });
    }

    public void getBidSaleList(String userName){
        mModel.getBidSaleList(userName).subscribe(new Observer<BidSaleDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BidSaleDTO bidSaleDTO) {
                getBidSaleListLiveEvent().postValue(bidSaleDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getOnLookList(String userName){
        mModel.getOnLookList(userName).subscribe(new Observer<OnLookListDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(OnLookListDTO onLookListDTO) {
                getOnLookListLiveEvent().postValue(onLookListDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getLogout(){
        mModel.getLogout().subscribe(new Observer<LogoutDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LogoutDTO logoutDTO) {
                getLogoutLiveEvent().postValue(logoutDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public SingleLiveEvent<OnLookListDTO> getOnLookListLiveEvent() {
        return onLookListLiveEvent = createLiveData(onLookListLiveEvent);
    }

    public SingleLiveEvent<MineContentDTO> getMineContentLiveEvent() {
        return mineContentLiveEvent = createLiveData(mineContentLiveEvent);
    }

    public SingleLiveEvent<BidSaleDTO> getBidSaleListLiveEvent() {
        return bidSaleListLiveEvent = createLiveData(bidSaleListLiveEvent);
    }

    public SingleLiveEvent<LogoutDTO> getLogoutLiveEvent(){
        return logoutLiveEvent = createLiveData(logoutLiveEvent);
    }

}
