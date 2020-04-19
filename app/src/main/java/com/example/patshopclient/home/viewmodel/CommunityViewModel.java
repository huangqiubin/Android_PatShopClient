package com.example.patshopclient.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.lib_http.entity.home.CommunityTopicDTO;
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

    private SingleLiveEvent<CommunityTopicDTO> hotTopicLiveEvent;

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

    public SingleLiveEvent<CommunityTopicDTO> getHotTopicLiveEvent() {
        return hotTopicLiveEvent = createLiveData(hotTopicLiveEvent);
    }

}
