package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.lib_http.entity.home.ProductDetailDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.ProductDetailModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ProductDetailViewModel extends BaseViewModel<ProductDetailModel> {

    public static String TAG = ProductDetailViewModel.class.getSimpleName();
    private SingleLiveEvent<ProductDetailDTO> productDetailLiveEvent;

    public ProductDetailViewModel(@NonNull Application application, ProductDetailModel model) {
        super(application, model);
    }

    public void httpGetProductDetail(int productId) {
        mModel.getProductDetail(productId).subscribe(new Observer<ProductDetailDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ProductDetailDTO productDetailDTO) {
                getProductDetailLiveEvent().postValue(productDetailDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public SingleLiveEvent<ProductDetailDTO> getProductDetailLiveEvent() {
        return productDetailLiveEvent = createLiveData(productDetailLiveEvent);
    }

}