package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.BidSaleDTO;
import com.example.lib_http.entity.home.BidSaleListDTO;
import com.example.lib_http.entity.home.MineContentDTO;
import com.example.lib_http.entity.home.OnLookListDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020-05-04.
 * Describe:
 */
public interface MineContentService {
    /**
     * 获取我的信息
     * @param userName
     * @return
     */
    @GET(API.URL_HOST_PATSHOP + "/mine/content")
    Observable<MineContentDTO> getMineContent(@Query("userName") String userName);

    /**
     * 获取参拍列表数据
     */
    @GET(API.URL_HOST_PATSHOP + "/mine/bid_sale")
    Observable<BidSaleDTO> getBidSaleList(@Query("userName") String userName);

    /**
     * 获取围观列表数据
     */
    @GET(API.URL_HOST_PATSHOP + "/mine/on_look")
    Observable<OnLookListDTO> getOnLookList(@Query("userName") String userName);
}
