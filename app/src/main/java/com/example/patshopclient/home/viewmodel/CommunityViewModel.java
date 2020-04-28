package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.lib_http.pojo.TopicPOJO;
import com.example.lib_http.entity.home.CommunityTopicDTO;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.lib_http.entity.home.TopicListDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.CommunityModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiubin on 2020-03-17.
 * Describe: 社区Viewmodel
 */
public class CommunityViewModel extends BaseViewModel<CommunityModel> {

    public static String TAG = CommunityViewModel.class.getSimpleName();
    //热门话题事件
    private SingleLiveEvent<CommunityTopicDTO> hotTopicLiveEvent;
    //话题列表事件
    private SingleLiveEvent<TopicListDTO> topicListLiveEvent;
    //发布话题事件
    private SingleLiveEvent<ResponceBodyDTO> responceLiveEvent;

    public CommunityViewModel(@NonNull Application application, CommunityModel model) {
        super(application, model);
    }

    /**
     * 获取社区热门话题
     */
    public void httpGetHotTopic() {
        mModel.getHotTopic().subscribe(new Observer<CommunityTopicDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CommunityTopicDTO communityTopicDTO) {
                getHotTopicLiveEvent().postValue(communityTopicDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 获取社区二级分类热门话题
     */
    public void httpGetTopicList() {
        mModel.getTopicList().subscribe(new Observer<TopicListDTO>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TopicListDTO topicListDTO) {
                getTopicListLiveEvent().postValue(topicListDTO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 发布话题
     */
    public void httpPostTopic(TopicPOJO topicPOJO) {
        mModel.postTopic(topicPOJO).subscribe(new Observer<ResponceBodyDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponceBodyDTO responceBodyDTO) {
                getResponceLiveEvent().postValue(responceBodyDTO);
            }

            @Override
            public void onError(Throwable e) {
                mUIChangeLiveData.getShowTransLoadingViewEvent().postValue(false);
            }

            @Override
            public void onComplete() {
                mUIChangeLiveData.getShowTransLoadingViewEvent().postValue(false);
            }
        });
    }

    public SingleLiveEvent<ResponceBodyDTO> getResponceLiveEvent() {
        return responceLiveEvent = createLiveData(responceLiveEvent);
    }

    public SingleLiveEvent<TopicListDTO> getTopicListLiveEvent() {
        return topicListLiveEvent = createLiveData(topicListLiveEvent);
    }

    public SingleLiveEvent<CommunityTopicDTO> getHotTopicLiveEvent() {
        return hotTopicLiveEvent = createLiveData(hotTopicLiveEvent);
    }

}
