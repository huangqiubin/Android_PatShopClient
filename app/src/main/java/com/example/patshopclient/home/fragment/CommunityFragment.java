package com.example.patshopclient.home.fragment;

import android.view.View;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.android_patshopclient.R;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.factory.CommunityViewModelFactory;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;
import com.google.android.material.tabs.TabLayout;

/**
 * Created by qiubin on 2020-03-17.
 * Describe: 首页 社区 fragment
 */
public class CommunityFragment extends BaseMvvmFragment<CommunityViewModel> {

    private LinearLayout llHotTopic;
    private LinearLayout llParticipateTopic;
    private LinearLayout llSponsorTopic;
    private LinearLayout llMineTopic;
    private ViewPager vpTopic;
    private TabLayout tabLayout;

    @Override
    public int onBindLayout() {
        return R.layout.fragment_community;
    }

    @Override
    public void initView(View view) {
        llHotTopic = rootView.findViewById(R.id.ll_hot_topic);
        llParticipateTopic = rootView.findViewById(R.id.ll_participate_topic);
        llSponsorTopic = rootView.findViewById(R.id.ll_sponsor_topic);
        llMineTopic = rootView.findViewById(R.id.ll_mine_topic);
        vpTopic = rootView.findViewById(R.id.vp_topic);
        tabLayout = rootView.findViewById(R.id.tab_layout);
    }

    @Override
    public void initListener() {
        super.initListener();
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
        return CommunityViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }

}
