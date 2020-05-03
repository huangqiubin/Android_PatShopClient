package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lib_http.pojo.TopicPOJO;
import com.example.lib_http.entity.home.CommunityTopicDTO;
import com.example.lib_http.entity.home.ResponceBodyDTO;
import com.example.lib_http.entity.home.TopicListDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.CommunityModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

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
    //选择图片的文件地址
    public MutableLiveData<List<String>> imagePath = new MediatorLiveData<>();

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
    public void httpPostTopic(TopicPOJO topicPOJO, List<MultipartBody.Part> files) {
        mModel.postTopic(topicPOJO, files).subscribe(new Observer<ResponceBodyDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponceBodyDTO responceBodyDTO) {
                getResponceLiveEvent().postValue(responceBodyDTO);
            }

            @Override
            public void onError(Throwable e) {

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
