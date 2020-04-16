package com.example.patshopclient.common.helper;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.patshopclient.home.fragment.CommunityFragment;
import com.example.patshopclient.home.fragment.MainHomeFragment;
import com.example.patshopclient.home.fragment.MineFragment;

/**
 * Created by qiubin on 2020-03-13.
 * Describe: 首页底部按钮帮助类
 */
public class BottomTabHelper implements View.OnClickListener {
    private Context mContext;
    private LinearLayout linearLayout;
    private RelativeLayout rlHome;
    private RelativeLayout rlCommunity;
    private RelativeLayout rlActivity;
    private RelativeLayout rlMe;
    private ImageView ivHome;
    private ImageView ivCommunity;
    private ImageView ivActivity;
    private ImageView ivMe;
    private TextView tvHome;
    private TextView tvCommunity;
    private TextView tvActivity;
    private TextView tvMe;

    private MainHomeFragment homeFragment;
    private CommunityFragment communityFragment;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;

    private BottomTabClickListener bottomTabClickListener;
    private int index = 0;

    public BottomTabHelper(Context context, LinearLayout linearLayout, FragmentManager fragmentManager) {
        this.mContext = context;
        this.linearLayout = linearLayout;
        this.fragmentManager = fragmentManager;
        initView();
        initEvent();
    }

    /**
     * 初始化所有控件
     */
    private void initView() {
        rlHome = linearLayout.findViewById(R.id.rl_home);
        rlCommunity = linearLayout.findViewById(R.id.rl_community);
        rlActivity = linearLayout.findViewById(R.id.rl_activity);
        rlMe = linearLayout.findViewById(R.id.rl_mine);
        ivHome = linearLayout.findViewById(R.id.iv_home);
        ivCommunity = linearLayout.findViewById(R.id.iv_community);
        ivActivity = linearLayout.findViewById(R.id.iv_activity);
        ivMe = linearLayout.findViewById(R.id.iv_mine);
        tvHome = linearLayout.findViewById(R.id.tv_home);
        tvCommunity = linearLayout.findViewById(R.id.tv_community);
        tvActivity = linearLayout.findViewById(R.id.tv_activity);
        tvMe = linearLayout.findViewById(R.id.tv_mine);
        //默认选中第一个
        resetSelected();
        ivHome.setImageResource(R.drawable.icon_home);
        tvHome.setTextColor(Color.parseColor("#B9463D"));
        switchFragment(0);
    }

    /**
     * 设置底部导航栏点击事件
     */
    private void initEvent() {
        rlHome.setOnClickListener(this);
        rlCommunity.setOnClickListener(this);
        rlActivity.setOnClickListener(this);
        rlMe.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_home:
                resetSelected();
                ivHome.setImageResource(R.drawable.icon_home);
                tvHome.setTextColor(Color.parseColor("#FFD900"));
                switchFragment(0);
                break;
            case R.id.rl_community:
                resetSelected();
                ivCommunity.setImageResource(R.drawable.icon_community);
                tvCommunity.setTextColor(Color.parseColor("#FFD900"));
                switchFragment(1);
                break;
            case R.id.rl_activity:
                resetSelected();
                ivActivity.setImageResource(R.drawable.icon_activity);
                tvActivity.setTextColor(Color.parseColor("#FFD900"));
                switchFragment(2);
                break;
            case R.id.rl_mine:
                resetSelected();
                ivMe.setImageResource(R.drawable.icon_me);
                tvMe.setTextColor(Color.parseColor("#FFD900"));
                switchFragment(3);
                break;

        }
    }

    /**
     * 重置所有控件选中状态
     */
    private void resetSelected() {
        ivHome.setImageResource(R.drawable.icon_home_unselect);
        ivCommunity.setImageResource(R.drawable.icon_community_unselect);
        ivActivity.setImageResource(R.drawable.icon_activity_unselect);
        ivMe.setImageResource(R.drawable.icon_me_unselect);

        tvHome.setTextColor(Color.parseColor("#999A9C"));
        tvCommunity.setTextColor(Color.parseColor("#999A9C"));
        tvActivity.setTextColor(Color.parseColor("#999A9C"));
        tvMe.setTextColor(Color.parseColor("#999A9C"));
    }

    /**
     * 切换fragment
     *
     * @param index
     */
    private void switchFragment(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (index) {
            case 0:
                if (ObjectUtils.isEmpty(homeFragment)) {
                    homeFragment = new MainHomeFragment();
                    fragmentTransaction.add(R.id.fl_content, homeFragment);
                }
                hideFragments(fragmentTransaction);
                fragmentTransaction.show(homeFragment);
                fragmentTransaction.commit();
                this.index = 0;
                break;
            case 1:
                if (ObjectUtils.isEmpty(communityFragment)) {
                    communityFragment = new CommunityFragment();
                    fragmentTransaction.add(R.id.fl_content, communityFragment);
                }
                hideFragments(fragmentTransaction);
                fragmentTransaction.show(communityFragment);
                fragmentTransaction.commit();
                this.index = 1;
                break;
            case 2:

                break;
            case 3:
                if (ObjectUtils.isEmpty(mineFragment)) {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.fl_content, mineFragment);
                }
                hideFragments(fragmentTransaction);
                fragmentTransaction.show(mineFragment);
                fragmentTransaction.commit();
                this.index = 3;
                break;
        }
    }

    /**
     * 隐藏所有fragment
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (ObjectUtils.isNotEmpty(homeFragment)) {
            fragmentTransaction.hide(homeFragment);
        }
        if (ObjectUtils.isNotEmpty(communityFragment)) {
            fragmentTransaction.hide(communityFragment);
        }
        if (ObjectUtils.isNotEmpty(mineFragment)) {
            fragmentTransaction.hide(mineFragment);
        }
    }

    public interface BottomTabClickListener {
        void onBottomTabClickListener();
    }
}
