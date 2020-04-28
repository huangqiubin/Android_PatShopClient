package com.example.patshopclient.home.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.BaseActivity;
import com.example.patshopclient.common.helper.BottomTabHelper;
import com.example.patshopclient.home.fragment.ActivityFragment;
import com.example.patshopclient.home.fragment.CommunityFragment;
import com.example.patshopclient.home.fragment.MainHomeFragment;
import com.example.patshopclient.home.fragment.MineFragment;

@Route(path = "/home/activity/main")
public class MainActivity extends BaseActivity {

    private FrameLayout flContent;
    private LinearLayout llBottomTab;

    private BottomTabHelper bottomTabHelper;
    private BottomTabHelper.BottomTabClickListener bottomTabClickListener;

    @Override
    public int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        BarUtils.setStatusBarLightMode(MainActivity.this, true);
        flContent = findViewById(R.id.fl_content);
        llBottomTab = findViewById(R.id.ll_main_bottom_tab);

    }

    @Override
    public void initParam() {
        bottomTabHelper = new BottomTabHelper(MainActivity.this, llBottomTab, getSupportFragmentManager());
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (ObjectUtils.isEmpty(bottomTabHelper.homeFragment) && fragment instanceof MainHomeFragment) {
            bottomTabHelper.homeFragment = (MainHomeFragment) fragment;
        }
        if (ObjectUtils.isEmpty(bottomTabHelper.communityFragment) && fragment instanceof CommunityFragment) {
            bottomTabHelper.communityFragment = (CommunityFragment) fragment;
        }
        if (ObjectUtils.isEmpty(bottomTabHelper.activityFragment) && fragment instanceof ActivityFragment) {
            bottomTabHelper.activityFragment = (ActivityFragment) fragment;
        }
        if (ObjectUtils.isEmpty(bottomTabHelper.mineFragment) && fragment instanceof MineFragment) {
            bottomTabHelper.mineFragment = (MineFragment) fragment;
        }
    }
}
