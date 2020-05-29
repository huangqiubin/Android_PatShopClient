package com.example.patshopclient.home.fragment;


import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.baseview.NoDataView;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.activity.ProductDetailActivity;
import com.example.patshopclient.home.adapter.BidProductAdapter;
import com.example.patshopclient.home.factory.ManageSaleViewModelFactory;
import com.example.patshopclient.home.viewmodel.ManageSaleViewModel;

/**
 * Created by qiubin on 2020-03-18.
 * Describe: 首页拍品viewpager界面
 */
public class ManageSaleFragment extends BaseMvvmFragment<ManageSaleViewModel> {

    private BidProductAdapter bidProductAdapter;
    private String title;

    @Override
    public void initView(View view) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        bidProductAdapter = new BidProductAdapter(getContext(), null);
        bidProductAdapter.setEmptyView(new NoDataView(getContext(), null));
        recyclerView.setAdapter(bidProductAdapter);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_manage_sale;
    }

    @Override
    public void initParam() {
        super.initParam();
        assert getArguments() != null;
        this.title = getArguments().getString("title");
    }

    @Override
    public void initData() {
        mViewModel.getManageContent();
    }

    @Override
    public void initListener() {
        bidProductAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getContext(), ProductDetailActivity.class);
            intent.putExtra(ProductDetailActivity.PRODUCTID, bidProductAdapter.getItem(position).getProductId());
            startActivity(intent);
        });
    }

    @Override
    public boolean enableLazyData() {
        return false;
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<ManageSaleViewModel> onBindViewModel() {
        return ManageSaleViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return ManageSaleViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getManageSaleContentLiveEvent().observe(this, manageSaleDTO -> {
            LogUtils.d("huangqiubin","managesalefragment");
            if ("竞拍中".equals(title) && ObjectUtils.isNotEmpty(manageSaleDTO.getData().getOnProductList())) {
                bidProductAdapter.setNewData(manageSaleDTO.getData().getOnProductList());
            } else if ("已下架".equals(title) && ObjectUtils.isNotEmpty(manageSaleDTO.getData().getEndProductList())) {
                bidProductAdapter.setNewData(manageSaleDTO.getData().getEndProductList());
            }
        });


    }
}
