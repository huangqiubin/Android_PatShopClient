package com.example.patshopclient.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.NetworkUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.baseview.LoadingInitView;
import com.example.patshopclient.common.baseview.LoadingTransView;
import com.example.patshopclient.common.baseview.NetErrorView;
import com.example.patshopclient.common.baseview.NoDataView;
import com.example.patshopclient.common.event.common.BaseFragmentEvent;
import com.example.patshopclient.common.util.log.KLog;
import com.example.patshopclient.common.view.IBaseView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by qiubin on 2020-03-11.
 * Describe: fragment基类
 */
public abstract class BaseFragment extends Fragment implements IBaseView {

    protected static final String TAG = BaseFragment.class.getSimpleName();
    protected AppCompatActivity mActivity;
    protected View rootView;
    protected TextView mTxtTitle;
    protected Toolbar mToolbar;

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
    private boolean isViewCreated = false;
    private boolean isViewVisable = false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (AppCompatActivity) getActivity();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_root, container, false);
        initCommonView(rootView);
        initView(rootView);
        initListener();
        initParam();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        //如果启用了懒加载就进行懒加载，否则就进行预加载
        if (enableLazyData()) {
            lazyLoad();
        } else {
            initData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public <T> void onEvent(BaseFragmentEvent<T> event) {
    }


    public void initCommonView(View view) {
        mViewStubToolbar = view.findViewById(R.id.view_stub_toolbar);
        mViewStubContent = view.findViewById(R.id.view_stub_content);
        mViewStubInitLoading = view.findViewById(R.id.view_stub_init_loading);
        mViewStubTransLoading = view.findViewById(R.id.view_stub_trans_loading);
        mViewStubNoData = view.findViewById(R.id.view_stub_nodata);
        mViewStubError = view.findViewById(R.id.view_stub_error);

        if (enableToolbar()) {
            mViewStubToolbar.setLayoutResource(onBindToolbarLayout());
            View viewToolbar = mViewStubToolbar.inflate();
            initTooBar(viewToolbar);
        }
        mViewStubContent.setLayoutResource(onBindLayout());
        mViewStubContent.inflate();
    }

    public abstract void initView(View view);

    @Override
    public void initListener() {

    }

    @Override
    public void initView() {

    }

    public void initParam() {
    }

    @Override
    public void finishActivity() {
        mActivity.finish();
    }

    @Override
    public void showInitLoadView(boolean show) {
        if (mLoadingInitView == null) {
            View view = mViewStubInitLoading.inflate();
            mLoadingInitView = view.findViewById(R.id.view_init_loading);
        }
        mLoadingInitView.setVisibility(show ? View.VISIBLE : View.GONE);
        mLoadingInitView.loading(show);
    }

    @Override
    public void showNoDataView(boolean show) {
        if (mNoDataView == null) {
            View view = mViewStubNoData.inflate();
            mNoDataView = view.findViewById(R.id.view_no_data);
        }
        mNoDataView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showTransLoadingView(boolean show) {
        if (mLoadingTransView == null) {
            View view = mViewStubTransLoading.inflate();
            mLoadingTransView = view.findViewById(R.id.view_trans_loading);
        }
        mLoadingTransView.setVisibility(show ? View.VISIBLE : View.GONE);
        mLoadingTransView.loading(show);
    }

    @Override
    public void showNetWorkErrView(boolean show) {
        if (mNetErrorView == null) {
            View view = mViewStubError.inflate();
            mNetErrorView = view.findViewById(R.id.view_net_error);
            mNetErrorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!NetworkUtils.isAvailable() && !NetworkUtils.isConnected()) {
                        Toast.makeText(mActivity, "网络发生错误，请稍后重试！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showNetWorkErrView(false);
                    initData();
                }
            });
        }
        mNetErrorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public boolean enableToolbar() {
        return false;
    }

    public abstract int onBindLayout();

    public abstract void initData();

    public abstract String getToolbarTitle();

    public int onBindToolbarLayout() {
        return R.layout.common_toolbar;
    }

    protected void initTooBar(View view) {
        mToolbar = view.findViewById(R.id.toolbar_root);
        mTxtTitle = view.findViewById(R.id.toolbar_title);
        if (mToolbar != null) {
            mActivity.setSupportActionBar(mToolbar);
            mActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.onBackPressed();
                }
            });
        }
        if (mTxtTitle != null) {
            mTxtTitle.setText(getToolbarTitle());
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isViewVisable = isVisibleToUser;
        //如果启用了懒加载就进行懒加载，
        if (enableLazyData() && isViewVisable) {
            lazyLoad();
        }
    }

    //默认不启用懒加载
    public boolean enableLazyData() {
        return false;
    }

    private void lazyLoad() {
        //这里进行双重标记判断,必须确保onCreateView加载完毕且页面可见,才加载数据
        KLog.v("MYTAG", "lazyLoad start...");
        KLog.v("MYTAG", "isViewCreated:" + isViewCreated);
        KLog.v("MYTAG", "isViewVisable" + isViewVisable);
        if (isViewCreated && isViewVisable) {
            initData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isViewVisable = false;
        }
    }
}
