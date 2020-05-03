package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.BidProductResultDTO;
import com.example.lib_http.entity.home.HomeBidProductDTO;
import com.example.lib_http.entity.home.HomeContentDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020-03-10.
 * Describe:
 */
public interface HomeContentService {

    @GET(API.URL_HOST_PATSHOP + "/home/content")
    Observable<HomeContentDTO> getHomeContent();

    @GET(API.URL_HOST_PATSHOP + "/home/bid_product")
    Observable<HomeBidProductDTO> getHomeBidProduct(@Query("categoryName") String categoryName);

    @GET(API.URL_HOST_PATSHOP + "/home/home_hot_bid")
    Observable<HomeBidProductDTO> getHomeHotBid();

}
