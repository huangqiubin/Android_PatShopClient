package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.lib_http.pojo.TopicPOJO;
import com.example.lib_http.entity.home.CommunityTopicDTO;
import com.example.lib_http.entity.home.TopicListDTO;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by qiubin on 2020-04-15.
 * Describe:社区请求接口
 */
public interface CommunityService {

    @GET(API.URL_HOST_PATSHOP + "/community/hot_topic")
    Observable<CommunityTopicDTO> getHotTopicList(@Query("hotTopic") int hotTopic);

    @GET(API.URL_HOST_PATSHOP + "/community/topic_list")
    Observable<TopicListDTO> getTopicList();

    @POST(API.URL_HOST_PATSHOP + "/community/post_topic")
    Observable<ResponceBodyDTO> postTopic(@Body TopicPOJO topic);
}
