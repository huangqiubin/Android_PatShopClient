package com.example.patshopclient.home.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.lib_http.entity.home.ActivityContentDTO;
import com.example.lib_http.entity.home.SignInDTO;
import com.example.patshopclient.common.event.SingleLiveEvent;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.home.model.ActivityModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiubin on 2020-04-05.
 * Describe:
 */
public class ActivityViewModel extends BaseViewModel<ActivityModel> {

    private SingleLiveEvent<ActivityContentDTO> activityContentLiveEvent;
    private SingleLiveEvent<SignInDTO> signInLiveEvent;

    public ActivityViewModel(@NonNull Application application, ActivityModel model) {
        super(application, model);
    }

    public void getActivityContent(String userName) {
        mModel.getActivityContent(userName).subscribe(new Observer<ActivityContentDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ActivityContentDTO activityContentDTO) {
                getActivityContentLiveEvent().postValue(activityContentDTO);
            }

            @Override
            public void onError(Throwable e) {
                getUC().getShowNoDataViewEvent().postValue(true);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getSignIn() {
        mModel.getSignIn().subscribe(new Observer<SignInDTO>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SignInDTO signInDTO) {
                getSignInLiveEvent().postValue(signInDTO);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getApplication(), "网络出现了一点小异常，请稍后重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public SingleLiveEvent<ActivityContentDTO> getActivityContentLiveEvent() {
        return activityContentLiveEvent = createLiveData(activityContentLiveEvent);
    }

    public SingleLiveEvent<SignInDTO> getSignInLiveEvent() {
        return signInLiveEvent = createLiveData(signInLiveEvent);
    }
}
