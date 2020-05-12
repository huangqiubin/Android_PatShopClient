package com.example.patshopclient.home.model;

import android.app.Application;

import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.BidSaleDTO;
import com.example.lib_http.entity.home.MineContentDTO;
import com.example.lib_http.entity.home.OnLookListDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.MineContentService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Created by qiubin on 2020-03-15.
 * Describe:
 */
public class MineModel extends BaseModel {

    MineContentService mineContentService;

    public MineModel(Application application) {
        super(application);
        mineContentService = RetrofitManager.getInstance().getMineContentService();
    }

    public Observable<MineContentDTO> getMineContent(String userName) {
        return mineContentService.getMineContent(userName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<BidSaleDTO> getBidSaleList(String userName) {
        return mineContentService.getBidSaleList(userName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<OnLookListDTO> getOnLookList(String userName) {
        return mineContentService.getOnLookList(userName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }
}
