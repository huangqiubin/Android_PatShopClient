package com.example.patshopclient.home.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.config.BaseData;
import com.example.patshopclient.common.config.ServerConfig;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.MineViewModel;

/**
 * Created by qiubin on 2020-03-15.
 * Describe:
 */
public class MineFragment extends BaseMvvmFragment<MineViewModel> {

    private ImageView ivHead;
    private TextView tvNickName;
    private TextView tvSignature;
    private LinearLayout llBidSale;
    private LinearLayout llLikeSale;
    private LinearLayout llTraceSale;
    private TextView tvBidSale;
    private TextView tvLikeSale;
    private TextView tvTraceSale;

    @Override
    public int onBindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        ivHead = rootView.findViewById(R.id.iv_head);
        tvNickName = rootView.findViewById(R.id.tv_nickname);
        tvSignature = rootView.findViewById(R.id.tv_signature);
        llBidSale = rootView.findViewById(R.id.ll_bid_sale);
        llLikeSale = rootView.findViewById(R.id.ll_like_sale);
        llTraceSale = rootView.findViewById(R.id.ll_trace_sale);
        tvBidSale = rootView.findViewById(R.id.tv_bid_sale);
        tvLikeSale = rootView.findViewById(R.id.tv_like_sale);
        tvTraceSale = rootView.findViewById(R.id.tv_trace_sale);
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
        return MineViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MainViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }

}
