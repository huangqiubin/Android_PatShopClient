package com.example.patshopclient.home.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.BaseActivity;
import com.example.patshopclient.common.config.PathConfig;

@Route(path = PathConfig.HISTORICAL_ORDER)
public class HistoricalOrderActivity extends BaseActivity {

    private ImageView ivBack;
    private TextView toolbarTitle;

    @Override
    public int onBindLayout() {
        return R.layout.activity_historical_order;
    }

    @Override
    public void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivBack.setVisibility(View.VISIBLE);
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("历史订单");
        toolbarTitle.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        super.initListener();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
