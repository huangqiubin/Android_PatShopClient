package com.example.patshopclient.home.model;

import android.app.Application;

import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.ManageSaleDTO;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.ManageSaleContentService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;

/**
 * Created by qiubin on 2020/5/12.
 * Describe:商家管理接口
 */
public class ManageSaleModel extends BaseModel {

    private ManageSaleContentService manageSaleContentService;

    public ManageSaleModel(Application application) {
        super(application);
        manageSaleContentService = RetrofitManager.getInstance().getManageSaleService();
    }

    public Observable<ManageSaleDTO> getManageSaleContent() {
        return manageSaleContentService.getManageSale().compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<ResponceBodyDTO> postAddProduct(String name, String subTitle, String categoryName, long bidCountDown,
                                                      double startPrice, double markUp, double marketPrice,
                                                      List<MultipartBody.Part> pics, List<MultipartBody.Part> albumsPics) {
        return manageSaleContentService.addProduct(name, subTitle, categoryName, bidCountDown, startPrice, markUp, marketPrice, pics, albumsPics).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }
}
