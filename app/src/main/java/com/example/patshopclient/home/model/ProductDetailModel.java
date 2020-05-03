package com.example.patshopclient.home.model;

import android.app.Application;

import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.BidProductResultDTO;
import com.example.lib_http.entity.home.ProductDetailDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.ProductDetailService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ProductDetailModel extends BaseModel {

    private ProductDetailService productDetailService;

    public ProductDetailModel(Application application) {
        super(application);
        productDetailService = RetrofitManager.getInstance().getProductDetailService();
    }

    public Observable<ProductDetailDTO> getProductDetail(int productId) {
        return productDetailService.getProductDetail(productId).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<BidProductResultDTO> bidProductResult(int productId, double bidPatCoin, String userName) {
        return productDetailService.getBidProduct(productId, bidPatCoin, userName).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }
}
