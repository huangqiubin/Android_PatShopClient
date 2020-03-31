package com.example.patshopclient.home.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.HomeBidProductDTO;
import com.example.patshopclient.common.baseview.NoDataView;
import com.example.patshopclient.common.mvvm.BaseMvvmActivity;
import com.example.patshopclient.home.adapter.BidProductAdapter;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.MainActivityViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

public class ProductCategoryActivity extends BaseMvvmActivity<MainActivityViewModel> {

    public static final String CATEGORYNAME = "categoryName";
    private RelativeLayout rlToolBar;
    private ImageView ivBack;
    private TextView tvTitle;
    private RecyclerView recyclerView;
    private BidProductAdapter bidProductAdapter;
    private SmartRefreshLayout refreshLayout;
    private String categoryName;

    @Override
    public int onBindLayout() {
        return R.layout.activity_product_category;
    }

    @Override
    public void initView() {
        setStatusBarColor(getResources().getColor(R.color.color_333333), findViewById(R.id.view_stub));
        rlToolBar = findViewById(R.id.rl_toolbar);
        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bidProductAdapter = new BidProductAdapter(this, null);
        bidProductAdapter.setEmptyView(new NoDataView(this, null));
        recyclerView.setAdapter(bidProductAdapter);
        refreshLayout = findViewById(R.id.refresh);
        Drawable drawable = ivBack.getDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable.setTint(getResources().getColor(R.color.color_FFFFFF));
        }
    }

    @Override
    public void initParam() {
        super.initParam();
        categoryName = getIntent().getStringExtra(CATEGORYNAME);
        tvTitle.setText(categoryName);
    }

    @Override
    public void initData() {
        mViewModel.httpGetBidProduct(this.categoryName);
    }

    @Override
    public void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public Class<MainActivityViewModel> onBindViewModel() {
        return MainActivityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MainViewModelFactory.getInstance(getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getHomeBidProductLiveEvent().observe(this, new Observer<HomeBidProductDTO>() {
            @Override
            public void onChanged(HomeBidProductDTO homeBidProductDTO) {
                if (homeBidProductDTO.getCode() != 200) return;
                List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> listBeans = homeBidProductDTO.getData().getHomeProductDaoList();
                bidProductAdapter.setNewData(listBeans);
            }
        });
    }
}
