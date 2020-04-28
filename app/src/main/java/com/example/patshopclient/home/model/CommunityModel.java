package com.example.patshopclient.home.model;

import android.app.Application;
import com.example.lib_http.RetrofitManager;
import com.example.lib_http.pojo.TopicPOJO;
import com.example.lib_http.entity.home.CommunityTopicDTO;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.lib_http.entity.home.TopicListDTO;
import com.example.lib_http.http.RxAdapter;
import com.example.lib_http.service.CommunityService;
import com.example.patshopclient.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Created by qiubin on 2020-03-17.
 * Describe:社区请求网络获取数据
 */
public class CommunityModel extends BaseModel {

    private CommunityService communityService;

    public CommunityModel(Application application) {
        super(application);
        communityService = RetrofitManager.getInstance().getCommunityService();
    }

    public Observable<CommunityTopicDTO> getHotTopic() {
        return communityService.getHotTopicList(1).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<TopicListDTO> getTopicList() {
        return communityService.getTopicList().compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

    public Observable<ResponceBodyDTO> postTopic(TopicPOJO topicPOJO) {
        return communityService.postTopic(topicPOJO).compose(RxAdapter.schedulersTransformer()).compose(RxAdapter.exceptionTransformer());
    }

}
