package com.example.patshopclient.home.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.blankj.utilcode.util.ObjectUtils;

import java.util.List;

/**
 * Created by qiubin on 2020-03-18.
 * Describe: viewpager adapter
 */
public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    List<String> titleList;

    public HomeViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList, List<String> titleList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return ObjectUtils.isNotEmpty(fragmentList) ? fragmentList.size() : 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void updateData(List<Fragment> fragmentList, List<String> titleList) {
        this.fragmentList.clear();
        this.titleList.clear();
        this.fragmentList.addAll(fragmentList);
        this.titleList.addAll(titleList);
        this.notifyDataSetChanged();
    }
}
