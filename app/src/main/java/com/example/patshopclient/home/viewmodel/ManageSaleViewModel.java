package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lib_http.entity.home.ManageSaleDTO;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.ManageSaleModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

/**
 * Created by qiubin on 2020/5/12.
 * Describe:
 */
public class ManageSaleViewModel extends BaseViewModel<ManageSaleModel> {
    private SingleLiveEvent<ManageSaleDTO> manageSaleContentLiveEvent;
    private SingleLiveEvent<ResponceBodyDTO> addProductLiveEvent;

    //选择商品封面图的文件地址
    public MutableLiveData<List<String>> picPathList = new MutableLiveData<>();
    //选择商品相册集的文件地址
    public MutableLiveData<List<String>> imagePathList = new MutableLiveData<>();

    public ManageSaleViewModel(@NonNull Application application, ManageSaleModel model) {
        super(application, model);
    }

    public void getManageContent() {
        mModel.getManageSaleContent().subscribe(new Observer<ManageSaleDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ManageSaleDTO manageSaleDTO) {
                getManageSaleContentLiveEvent().postValue(manageSaleDTO);
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

    public void postAddProduct(String name, String subTitle, String categoryName, long bidCountDown,
                               double startPrice, double markUp, double marketPrice,
                               List<MultipartBody.Part> pics, List<MultipartBody.Part> albumsPics) {
        mModel.postAddProduct(name, subTitle, categoryName, bidCountDown, startPrice, markUp, marketPrice, pics, albumsPics).subscribe(new Observer<ResponceBodyDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponceBodyDTO responceBodyDTO) {
                getAddProductLiveEvent().postValue(responceBodyDTO);
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

    public SingleLiveEvent<ManageSaleDTO> getManageSaleContentLiveEvent() {
        return manageSaleContentLiveEvent = createLiveData(manageSaleContentLiveEvent);
    }

    public SingleLiveEvent<ResponceBodyDTO> getAddProductLiveEvent() {
        return addProductLiveEvent = createLiveData(addProductLiveEvent);
    }

}
