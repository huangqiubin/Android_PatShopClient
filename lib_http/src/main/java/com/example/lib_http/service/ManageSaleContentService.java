package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.ManageSaleDTO;
import com.example.lib_http.entity.home.OffProductDTO;
import com.example.lib_http.entity.home.ResponceBodyDTO;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020/5/13.
 * Describe:
 */
public interface ManageSaleContentService {

    /**
     * 获取参拍列表数据
     */
    @GET(API.URL_HOST_PATSHOP + "/manage_sale/manage_sale")
    Observable<ManageSaleDTO> getManageSale();

    /**
     * 发布拍品
     */
    @Multipart
    @POST(API.URL_HOST_PATSHOP + "/manage_sale/add_product")
    Observable<ResponceBodyDTO> addProduct(@Query("name") String name, @Query("subTitle") String subTitle, @Query("categoryName") String categoryName,
                                           @Query("bidCountDown") long bidCountDown, @Query("startPrice") double startPrice,
                                           @Query("markUp") double markUp, @Query("marketPrice") double marketPrice,
                                           @Part List<MultipartBody.Part> pics, @Part List<MultipartBody.Part> albumsPics);

    @GET(API.URL_HOST_PATSHOP +"/manage_sale/off_product")
    Observable<OffProductDTO> offProduct(@Query("productId") int productId);

}
