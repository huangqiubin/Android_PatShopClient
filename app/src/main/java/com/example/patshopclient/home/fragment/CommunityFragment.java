package com.example.patshopclient.home.fragment;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.example.android_patshopclient.R;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.factory.CommunityModelFactory;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;

/**
 * Created by qiubin on 2020-03-17.
 * Describe: 首页 社区 fragment
 */
public class CommunityFragment extends BaseMvvmFragment<CommunityViewModel> {
    @Override
    public Class<CommunityViewModel> onBindViewModel() {
        return CommunityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return new CommunityModelFactory(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_community;
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

}
