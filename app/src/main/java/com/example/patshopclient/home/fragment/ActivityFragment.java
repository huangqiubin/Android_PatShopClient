package com.example.patshopclient.home.fragment;

import android.content.DialogInterface;
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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
    private List<SignInPOJO> signInList = new ArrayList<>();
    private SignInAdapter signInAdapter = new SignInAdapter(null);
    private TextView tvComplete1;
    private TextView tvComplete2;
    private TextView tvComplete3;
    private TextView tvComplete4;
    private TextView tvComplete5;


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
        tvComplete1 = rootView.findViewById(R.id.tv_complete1);
        tvComplete2 = rootView.findViewById(R.id.tv_complete2);
        tvComplete3 = rootView.findViewById(R.id.tv_complete3);
        tvComplete4 = rootView.findViewById(R.id.tv_complete4);
        tvComplete5 = rootView.findViewById(R.id.tv_complete5);
        tvComplete1.setOnClickListener(v -> noticeUserNotComplete());
        tvComplete2.setOnClickListener(v -> noticeUserNotComplete());
        tvComplete3.setOnClickListener(v -> noticeUserNotComplete());
        tvComplete4.setOnClickListener(v -> noticeUserNotComplete());
        tvComplete5.setOnClickListener(v -> noticeUserNotComplete());
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
                boolean hasTodaySign = activityContentDTO.getData().isHasTodaySign();
                //如果是昨天或者今天，就显示签到标记
                if (isYesterday || hasTodaySign) {
                    int rewardCoin = activityContentDTO.getData().getSignInModel().getRewardCoin();
                    for (int i = 0; i <= rewardCoin - 3; i++) {
                        signInAdapter.getData().get(i).setSign(true);
                    }
                    signInAdapter.notifyDataSetChanged();
                }
                if (hasTodaySign) {
                    setTvSignState(true);
                } else {
                    setTvSignState(false);
                }

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
                    setTvSignState(true);
                } else {
                    setTvSignState(false);
                }
            }
        });

    }

    //设置签到按钮状态
    private void setTvSignState(boolean isSignIn) {
        if (isSignIn) {
            tvSign.setSolidColor(R.color.color_999A9C);
            tvSign.setClickable(false);
            tvSign.setText("已签到");
        } else {
            tvSign.setSolidColor(R.color.color_F73255);
            tvSign.setClickable(true);
            tvSign.setText("签到");
        }

    }

    private void noticeUserNotComplete() {
        new MaterialAlertDialogBuilder(getContext()).setTitle("程序员小哥哥正在加紧开发此功能哦！")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();
    }
}
