package com.example.patshopclient.home.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.BarUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.BaseActivity;
import com.example.patshopclient.common.helper.BottomTabHelper;

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


}
