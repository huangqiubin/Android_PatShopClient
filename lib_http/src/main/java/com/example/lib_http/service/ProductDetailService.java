package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.BidProductResultDTO;
import com.example.lib_http.entity.home.ProductDetailDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020-03-21.
 * Describe: 请求商品详情Service
 */
public interface ProductDetailService {

    /**
     * 获取商品详情
     * @param productId
     * @return
     */
    @GET(API.URL_HOST_PATSHOP + "/home/product_detail")
    Observable<ProductDetailDTO> getProductDetail(@Query("productId") int productId);

    /**
     * 商品出价竞拍
     * @return
     */
    @GET(API.URL_HOST_PATSHOP + "/home/bid_product_l")
    Observable<BidProductResultDTO> getBidProduct(@Query("productId")int productId,@Query("bidPatCoin") double bidPatCoin,@Query("userName") String userName);
}
