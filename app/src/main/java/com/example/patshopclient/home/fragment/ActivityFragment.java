package com.example.patshopclient.home.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.ActivityContentDTO;
import com.example.lib_http.entity.home.SignInDTO;
import com.example.lib_http.pojo.SignInPOJO;
import com.example.lib_userinfo.config.UserInfoBean;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.home.adapter.SignInAdapter;
import com.example.patshopclient.home.factory.ActivityViewModelFactory;
import com.example.patshopclient.home.viewmodel.ActivityViewModel;
import com.example.patshopclient.widgets.WPTShapeTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiubin on 2020-04-05.
 * Describe:首页的活动页
 */
public class ActivityFragment extends BaseMvvmFragment<ActivityViewModel> {

    private WPTShapeTextView tvSign;
    private TextView tvSignMsg;
    private RecyclerView rvSign;
    private RecyclerView rvTask;
    private List<SignInPOJO> signInList = new ArrayList<>();
    private SignInAdapter signInAdapter = new SignInAdapter(null);


    @Override
    public int onBindLayout() {
        return R.layout.fragment_activity;
    }

    @Override
    public void initView(View view) {
        tvSign = rootView.findViewById(R.id.tv_sign);
        tvSignMsg = rootView.findViewById(R.id.tv_sign_msg);
        rvSign = rootView.findViewById(R.id.recycler_sign);
        rvSign.setAdapter(signInAdapter);
        rvTask = rootView.findViewById(R.id.recycler_task);
    }

    @Override
    public void initData() {
        signInList.clear();
        for (int i = 1; i <= 7; i++) {
            SignInPOJO signInPOJO = new SignInPOJO();
            signInPOJO.setDay(i);
            signInPOJO.setSign(false);
            signInList.add(signInPOJO);
        }
        signInAdapter.setNewData(signInList);
        String userName = UserInfoBean.getInstance().getUname();
        mViewModel.getActivityContent(userName);
    }

    @Override
    public void initListener() {
        super.initListener();
        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getSignIn();
            }
        });
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<ActivityViewModel> onBindViewModel() {
        return ActivityViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return ActivityViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getActivityContentLiveEvent().observe(this, new Observer<ActivityContentDTO>() {
            @Override
            public void onChanged(ActivityContentDTO activityContentDTO) {
                if (ObjectUtils.isEmpty(activityContentDTO)) {
                    return;
                }
                boolean isYesterday = activityContentDTO.getData().isYesterday();
                //如果不是昨天的话返回
                if (!isYesterday) {
                    return;
                }
                int rewardCoin = activityContentDTO.getData().getSignInModel().getRewardCoin();
                for (int i = 0; i <= rewardCoin - 3; i++) {
                    signInAdapter.getData().get(i).setSign(true);
                }
                signInAdapter.notifyDataSetChanged();
            }

        });

        mViewModel.getSignInLiveEvent().observe(this, new Observer<SignInDTO>() {
            @Override
            public void onChanged(SignInDTO signInDTO) {
                if (ObjectUtils.isEmpty(signInDTO)) {
                    Toast.makeText(mActivity, "签到失败", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (signInDTO.getData() == 1) {
                    tvSign.setSolidColor(R.color.color_999A9C);
                }
            }
        });

    }

    private void setTvSignState(boolean isSignIn){

    }
}
