package com.example.patshopclient.home.fragment;


import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.HomeBidProductDTO;
import com.example.patshopclient.common.baseview.NoDataView;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.activity.ProductDetailActivity;
import com.example.patshopclient.home.adapter.BidProductAdapter;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.MainActivityViewModel;

/**
 * Created by qiubin on 2020-03-18.
 * Describe: 首页拍品viewpager界面
 */
public class BidProductFragment extends BaseMvvmFragment<MainActivityViewModel> {

    private RecyclerView recyclerView;
    private BidProductAdapter bidProductAdapter;
    private int position;
    private String title;

    @Override
    public void initView(View view) {
        recyclerView = rootView.findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setAutoMeasureEnabled(true);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        bidProductAdapter = new BidProductAdapter(getContext(), null);
        bidProductAdapter.setEmptyView(new NoDataView(getContext(), null));
        recyclerView.setAdapter(bidProductAdapter);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_bid_product;
    }

    @Override
    public void initParam() {
        super.initParam();
        this.position = getArguments().getInt("position");
        this.title = getArguments().getString("title");
    }

    @Override
    public void initData() {
        if ("热门".equals(title)) {
            mViewModel.httpGetHotBid();
        } else {
            mViewModel.httpGetBidProduct(title);
        }
    }

    @Override
    public void initListener() {
        bidProductAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                Intent intent = new Intent(getContext(), ProductDetailActivity.class);
                intent.putExtra(ProductDetailActivity.PRODUCTID, bidProductAdapter.getItem(position).getProductId());
                getContext().startActivity(intent);
            }
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
    public Class<MainActivityViewModel> onBindViewModel() {
        return MainActivityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MainViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

        mViewModel.getHomeHotBidSingleLiveEvent().observe(this, new Observer<HomeBidProductDTO>() {
            @Override
            public void onChanged(HomeBidProductDTO homeBidProductDTO) {
                bidProductAdapter.setNewData(homeBidProductDTO.getData().getHomeProductDaoList());
            }
        });

        mViewModel.getHomeBidProductLiveEvent().observe(this, new Observer<HomeBidProductDTO>() {
            @Override
            public void onChanged(HomeBidProductDTO homeBidProductDTO) {
                LogUtils.i(homeBidProductDTO.getData().getHomeProductDaoList());
                if (ObjectUtils.isNotEmpty(homeBidProductDTO)) {
                    bidProductAdapter.setNewData(homeBidProductDTO.getData().getHomeProductDaoList());
                }

            }
        });


    }
}
