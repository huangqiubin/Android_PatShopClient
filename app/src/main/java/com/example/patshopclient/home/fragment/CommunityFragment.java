package com.example.patshopclient.home.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ArrayUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.adapter.CommunityTopicViewPagerAdapter;
import com.example.patshopclient.home.factory.CommunityViewModelFactory;
import com.example.patshopclient.home.viewmodel.CommunityViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

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
    private CommunityTopicViewPagerAdapter communityTopicViewPagerAdapter;

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tabTitleList = new ArrayList();
    private String[] titles = {"精华", "游戏", "数码", "美妆", "生活"};

    {
        tabTitleList.addAll(ArrayUtils.asArrayList(titles));
    }

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
        communityTopicViewPagerAdapter = new CommunityTopicViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList, tabTitleList);
        vpTopic.setAdapter(communityTopicViewPagerAdapter);
        tabLayout.setupWithViewPager(vpTopic);
    }

    @Override
    public void initParam() {
        super.initParam();
        for (int i = 0; i < tabTitleList.size(); i++) {
            TopicFragment topicFragment = new TopicFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            bundle.putString("title", tabTitleList.get(i));
            topicFragment.setArguments(bundle);
            fragmentList.add(topicFragment);
        }
        communityTopicViewPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void initListener() {
        super.initListener();
        llHotTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/community/activity/hot_topic").navigation();
            }
        });
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
