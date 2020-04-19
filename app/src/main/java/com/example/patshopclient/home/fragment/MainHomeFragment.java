package com.example.patshopclient.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.HomeContentDTO;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.activity.ProductCategoryActivity;
import com.example.patshopclient.home.adapter.HomeViewPagerAdapter;
import com.example.patshopclient.home.adapter.MainHomeBannerAdapter;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.MainActivityViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by qiubin on 2020-03-11.
 * Describe: 主页 home fragment
 */
public class MainHomeFragment extends BaseMvvmFragment<MainActivityViewModel> {

    private AppBarLayout appBarLayout;
    private Banner banner;
    private MainHomeBannerAdapter mainHomeBannerAdapter;
    private ViewPager vpBidProduct;
    private TabLayout tabLayout;
    private HomeViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private LinearLayout llTab1;
    private LinearLayout llTab2;
    private LinearLayout llTab3;
    private LinearLayout llTab4;
    private LinearLayout llTab5;
    private LinearLayout llTab6;

    @Override
    public void initView(View view) {
        appBarLayout = rootView.findViewById(R.id.appbar);
        banner = rootView.findViewById(R.id.banner);
        mainHomeBannerAdapter = new MainHomeBannerAdapter(null);
        banner.setAdapter(mainHomeBannerAdapter);
        banner.setIndicator(new CircleIndicator(getContext()));
        viewPagerAdapter = new HomeViewPagerAdapter(getParentFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList, titleList);
        vpBidProduct = rootView.findViewById(R.id.viewpager);
        vpBidProduct.setAdapter(viewPagerAdapter);
        vpBidProduct.setOffscreenPageLimit(6);
        tabLayout = rootView.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vpBidProduct);
        llTab1 = rootView.findViewById(R.id.ll_tab1);
        llTab2 = rootView.findViewById(R.id.ll_tab2);
        llTab3 = rootView.findViewById(R.id.ll_tab3);
        llTab4 = rootView.findViewById(R.id.ll_tab4);
        llTab5 = rootView.findViewById(R.id.ll_tab5);
        llTab6 = rootView.findViewById(R.id.ll_tab6);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        mViewModel.httpGetContent();
    }

    @Override
    public void initListener() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int appBarHeight = appBarLayout.getHeight();
                if (verticalOffset <= -appBarHeight) {
                    tabLayout.setBackgroundColor(getResources().getColor(R.color.color_FFD900));
                    tabLayout.setTabTextColors(getResources().getColor(R.color.color_333333), getResources().getColor(R.color.color_FFFFFF));
                } else {
                    tabLayout.setBackgroundColor(getResources().getColor(R.color.color_F5F5F5));
                    tabLayout.setTabTextColors(getResources().getColor(R.color.color_333333), getResources().getColor(R.color.color_FFD900));
                }
            }
        });
        llTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                intent.putExtra(ProductCategoryActivity.CATEGORYNAME, "生活充值");
                startActivity(intent);
            }
        });
        llTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                intent.putExtra(ProductCategoryActivity.CATEGORYNAME, "游戏点卷");
                startActivity(intent);
            }
        });
        llTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                intent.putExtra(ProductCategoryActivity.CATEGORYNAME, "手机数码");
                startActivity(intent);
            }
        });
        llTab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                intent.putExtra(ProductCategoryActivity.CATEGORYNAME, "手办模型");
                startActivity(intent);
            }
        });
        llTab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                intent.putExtra(ProductCategoryActivity.CATEGORYNAME, "美妆好物");
                startActivity(intent);
            }
        });
        llTab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProductCategoryActivity.class);
                intent.putExtra(ProductCategoryActivity.CATEGORYNAME, "生活百货");
                startActivity(intent);
            }
        });
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<MainActivityViewModel> onBindViewModel() {
        return MainActivityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MainViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getHomeContentLiveEvent().observe(this, new Observer<HomeContentDTO>() {
            @Override
            public void onChanged(HomeContentDTO homeContentDTO) {
                if (ObjectUtils.isNotEmpty(homeContentDTO.getData().getHomeAdvertiseList())) {
                    mainHomeBannerAdapter.updataDatas(homeContentDTO.getData().getHomeAdvertiseList());
                }
                if (ObjectUtils.isNotEmpty(homeContentDTO.getData().getProductCategoryDaoList())) {
                    BidProductFragment hotBidProductFragment = new BidProductFragment();
                    Bundle b = new Bundle();
                    b.putInt("position", 0);
                    b.putString("title", "热门");
                    hotBidProductFragment.setArguments(b);
                    titleList.add("热门");
                    fragmentList.add(hotBidProductFragment);
                    for (int i = 0; i < homeContentDTO.getData().getProductCategoryDaoList().size(); i++) {
                        titleList.add(homeContentDTO.getData().getProductCategoryDaoList().get(i).getKeywords());
                        BidProductFragment bidProductFragment = new BidProductFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", i + 1);
                        bundle.putString("title", homeContentDTO.getData().getProductCategoryDaoList().get(i).getCategoryName());
                        bidProductFragment.setArguments(bundle);
                        fragmentList.add(bidProductFragment);
                    }
                    viewPagerAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
