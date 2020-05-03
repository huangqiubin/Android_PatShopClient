package com.example.lib_http.service;

import com.example.lib_http.config.API;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.lib_http.pojo.TopicPOJO;
import com.example.lib_http.entity.home.CommunityTopicDTO;
import com.example.lib_http.entity.home.TopicListDTO;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
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

    @Multipart
    @POST(API.URL_HOST_PATSHOP + "/community/post_topic")
    Observable<ResponceBodyDTO> postTopic(@Query("topicType") String topicType, @Query("topicSecType") String topicSecType, @Query("topicContent") String topicContent, @Part List<MultipartBody.Part> files);
}
