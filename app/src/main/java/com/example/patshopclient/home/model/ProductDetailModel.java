package com.example.patshopclient.home.model;

import android.app.Application;

import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.BidProductResultDTO;
import com.example.lib_http.entity.home.OffProductDTO;
import com.example.lib_http.entity.home.ProductDetailDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.ManageSaleContentService;
import com.example.lib_http.service.ProductDetailService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ProductDetailModel extends BaseModel {

    private ProductDetailService productDetailService;
    private ManageSaleContentService manageSaleService;

    public ProductDetailModel(Application application) {
        super(application);
        productDetailService = RetrofitManager.getInstance().getProductDetailService();
        manageSaleService = RetrofitManager.getInstance().getManageSaleService();
    }

    public Observable<ProductDetailDTO> getProductDetail(int productId) {
        return productDetailService.getProductDetail(productId).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<BidProductResultDTO> bidProductResult(int productId, double bidPatCoin, String userName) {
        return productDetailService.getBidProduct(productId, bidPatCoin, userName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<OffProductDTO> offProduct(int productId) {
        return manageSaleService.offProduct(productId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
