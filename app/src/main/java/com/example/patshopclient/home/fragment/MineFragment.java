package com.example.patshopclient.home.fragment;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.viewmodel.MineViewModel;

/**
 * Created by qiubin on 2020-03-15.
 * Describe:
 */
public class MineFragment extends BaseMvvmFragment<MineViewModel> {


    @Override
    public void initView(View view) {

    }

    @Override
    public int onBindLayout() {
        return 0;
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<MineViewModel> onBindViewModel() {
        return null;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return null;
    }

    @Override
    public void initViewObservable() {

    }

}
