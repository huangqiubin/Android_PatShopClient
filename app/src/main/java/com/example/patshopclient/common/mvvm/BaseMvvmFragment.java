package com.example.patshopclient.common.mvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.patshopclient.common.BaseFragment;
import com.example.patshopclient.common.mvvm.viewmodel.BaseViewModel;
import com.example.patshopclient.common.util.log.KLog;

import java.util.Map;

/**
 * Description: <BaseMvpFragment><br>
 */
public abstract class BaseMvvmFragment<VM extends BaseViewModel> extends BaseFragment {
    protected VM mViewModel;

    public void initParam() {
        initViewModel();
        initBaseViewObservable();
        initViewObservable();
    }

    private void initViewModel() {
        mViewModel = createViewModel();
        getLifecycle().addObserver(mViewModel);
    }

    public VM createViewModel() {
        return new ViewModelProvider(this, onBindViewModelFactory()).get(onBindViewModel());
    }

    public abstract Class<VM> onBindViewModel();

    public abstract ViewModelProvider.Factory onBindViewModelFactory();

    public abstract void initViewObservable();

    protected void initBaseViewObservable() {
        mViewModel.getUC().getShowInitLoadViewEvent().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean show) {
                showInitLoadView(show);
            }
        });
        mViewModel.getUC().getShowTransLoadingViewEvent().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean show) {
                KLog.v("MYTAG", "view postShowTransLoadingViewEvent start...");
                showTransLoadingView(show);
            }
        });
        mViewModel.getUC().getShowNoDataViewEvent().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean show) {
                showNoDataView(show);
            }
        });
        mViewModel.getUC().getShowNetWorkErrViewEvent().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean show) {
                showNetWorkErrView(show);
            }
        });
        mViewModel.getUC().getStartActivityEvent().observe(this, new Observer<Map<String, Object>>() {
            @Override
            public void onChanged(@Nullable Map<String, Object> params) {
                Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterField.CLASS);
                Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
                startActivity(clz, bundle);
            }
        });
        mViewModel.getUC().getFinishActivityEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                if (mActivity != null) {
                    mActivity.finish();
                }
            }
        });
        mViewModel.getUC().getOnBackPressedEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                if (mActivity != null) {
                    mActivity.onBackPressed();
                }
            }
        });
    }

    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
