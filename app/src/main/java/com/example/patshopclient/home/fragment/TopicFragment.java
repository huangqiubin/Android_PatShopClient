package com.example.patshopclient.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.baseview.NoDataView;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.adapter.TopicAdapter;
import com.example.patshopclient.home.factory.CommunityViewModelFactory;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;

/**
 * Created by qiubin on 2020-04-02.
 * Describe: 话题 fragment
 */
public class TopicFragment extends BaseMvvmFragment<CommunityViewModel> {

    private int position;
    private String title;
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;


    @Override
    public void initView(View view) {
        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        topicAdapter = new TopicAdapter(R.layout.item_topic, null);
        topicAdapter.setEmptyView(new NoDataView(getContext(), null));
        recyclerView.setAdapter(topicAdapter);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    public void initParam() {
        super.initParam();
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
        title = bundle.getString("title");
    }

    @Override
    public void initData() {
        if (ObjectUtils.isNotEmpty(mViewModel)){
            mViewModel.httpGetHotTopic();
        }
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<CommunityViewModel> onBindViewModel() {
        return CommunityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return CommunityViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getHotTopicLiveEvent().observe(this, communityTopicDTO -> {
            LogUtils.d("topic fragment get the data");
            Log.d("hangqiubin", "LogUtil");
            if (ObjectUtils.isEmpty(communityTopicDTO.getData().getTopicList())) {
                return;
            }
            topicAdapter.addData(communityTopicDTO.getData().getTopicList());
        });
    }
}
