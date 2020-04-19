package com.example.patshopclient.home.fragment;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.example.android_patshopclient.R;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.factory.ActivityViewModelFactory;
import com.example.patshopclient.home.viewmodel.ActivityViewModel;

/**
 * Created by qiubin on 2020-04-05.
 * Describe:
 */
public class ActivityFragment extends BaseMvvmFragment<ActivityViewModel> {

    @Override
    public void initView(View view) {

    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_activity;
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<ActivityViewModel> onBindViewModel() {
        return ActivityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return ActivityViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }
}
