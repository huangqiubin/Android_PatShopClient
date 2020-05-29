package com.example.patshopclient.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.baseview.LoadingInitView;
import com.example.patshopclient.common.baseview.LoadingTransView;
import com.example.patshopclient.common.baseview.NetErrorView;
import com.example.patshopclient.common.baseview.NoDataView;
import com.example.patshopclient.common.event.common.BaseActivityEvent;
import com.example.patshopclient.common.manager.ActivityManager;
import com.example.patshopclient.common.view.IBaseView;
import com.example.patshopclient.home.activity.ProductCategoryActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected static final String TAG = BaseActivity.class.getSimpleName();
    protected Toolbar mToolbar;
    protected TextView mTxtTitle;
    protected NetErrorView mNetErrorView;
    protected NoDataView mNoDataView;
    protected LoadingInitView mLoadingInitView;
    protected LoadingTransView mLoadingTransView;
    private ViewStub mViewStubToolbar;
    private ViewStub mViewStubContent;
    private ViewStub mViewStubInitLoading;
    private ViewStub mViewStubTransLoading;
    private ViewStub mViewStubNoData;
    private ViewStub mViewStubError;
    protected View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setContentView(R.layout.activity_base);
        initCommonView();

        initView();
        initListener();
        initParam();
        initData();
        EventBus.getDefault().register(this);
        ActivityManager.getInstance().addActivity(this);
    }

    protected void initCommonView() {
        mViewStubToolbar = findViewById(R.id.view_stub_toolbar);
        mViewStubContent = findViewById(R.id.view_stub_content);
        mViewStubInitLoading = findViewById(R.id.view_stub_init_loading);
        mViewStubTransLoading = findViewById(R.id.view_stub_trans_loading);
        mViewStubError = findViewById(R.id.view_stub_error);
        mViewStubNoData = findViewById(R.id.view_stub_nodata);

        if (enableToolbar()) {
            mViewStubToolbar.setLayoutResource(onBindToolbarLayout());
            View view = mViewStubToolbar.inflate();
            initToolbar(view);
        }
        mViewStubContent.setLayoutResource(onBindLayout());
        mContentView = mViewStubContent.inflate();
    }

    public abstract int onBindLayout();

    public boolean enableToolbar() {
        return false;
    }

    public int onBindToolbarLayout() {
        return R.layout.common_toolbar;
    }

    protected void initToolbar(View view) {
        mToolbar = view.findViewById(R.id.toolbar_root);
        mTxtTitle = view.findViewById(R.id.toolbar_title);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (mTxtTitle != null && !TextUtils.isEmpty(title)) {
            mTxtTitle.setText(title);
        }
        //可以再次覆盖设置title
        String toolBarTitle = getToolBarTitle();
        if (mTxtTitle != null && !TextUtils.isEmpty(toolBarTitle)) {
            mTxtTitle.setText(toolBarTitle);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        ActivityManager.getInstance().finishActivity(this);
    }

    public abstract void initView();

    public abstract void initData();

    public void initListener() {
    }

    public void initParam() {
    }


    @Override
    public void finishActivity() {
        finish();
    }

    public String getToolBarTitle() {
        return "";
    }

    public void showInitLoadView(boolean show) {
        if (mLoadingInitView == null) {
            View view = mViewStubInitLoading.inflate();
            mLoadingInitView = view.findViewById(R.id.view_init_loading);
        }
        mLoadingInitView.setVisibility(show ? View.VISIBLE : View.GONE);
        mLoadingInitView.loading(show);
    }


    public void showNetWorkErrView(boolean show) {
        if (mNetErrorView == null) {
            View view = mViewStubError.inflate();
            mNetErrorView = view.findViewById(R.id.view_net_error);
            mNetErrorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!NetworkUtils.isAvailable() && !NetworkUtils.isConnected()) {
                        Toast.makeText(BaseActivity.this, "网络发生错误，请稍后重试！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showNetWorkErrView(false);
                    initData();
                }
            });
        }
        mNetErrorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    public void showNoDataView(boolean show) {
        if (mNoDataView == null) {
            View view = mViewStubNoData.inflate();
            mNoDataView = view.findViewById(R.id.view_no_data);
        }
        mNoDataView.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    public void showTransLoadingView(boolean show) {
        if (mLoadingTransView == null) {
            View view = mViewStubTransLoading.inflate();
            mLoadingTransView = view.findViewById(R.id.view_trans_loading);
        }
        mLoadingTransView.setVisibility(show ? View.VISIBLE : View.GONE);
        mLoadingTransView.loading(show);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public <T> void onEvent(BaseActivityEvent<T> event) {
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void setStatusBarColor(int color, View view) {
        BarUtils.setStatusBarColor(this, color);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = BarUtils.getStatusBarHeight();
        view.setLayoutParams(layoutParams);
        view.setVisibility(View.VISIBLE);
    }
}
