package com.example.patshopclient.home.fragment;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_patshopclient.R;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;

/**
 * Created by qiubin on 2020-04-02.
 * Describe: 话题 fragment
 */
public class TopicFragment extends BaseMvvmFragment<CommunityViewModel> {

    private RecyclerView recyclerView;
    @Override
    public void initView(View view) {
        recyclerView = rootView.findViewById(R.id.recycler);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    public void initData() {

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
        return MainViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }
}
