package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.lib_http.entity.home.BidSaleListDTO;
import com.example.lib_http.entity.home.MineContentDTO;
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
    private SingleLiveEvent<BidSaleListDTO> bidSaleListLiveEvent;

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

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getBidSaleList(String userName){
        mModel.getBidSaleList(userName).subscribe(new Observer<BidSaleListDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BidSaleListDTO bidSaleListDTO) {
                getBidSaleListLiveEvent().postValue(bidSaleListDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public SingleLiveEvent<MineContentDTO> getMineContentLiveEvent() {
        return mineContentLiveEvent = createLiveData(mineContentLiveEvent);
    }

    public SingleLiveEvent<BidSaleListDTO> getBidSaleListLiveEvent() {
        return bidSaleListLiveEvent = createLiveData(bidSaleListLiveEvent);
    }

}
