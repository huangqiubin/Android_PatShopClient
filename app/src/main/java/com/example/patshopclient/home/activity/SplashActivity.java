package com.example.patshopclient.home.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ScreenUtils;
import com.example.android_patshopclient.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivMao;
    private ImageView ivBid;
    private TextView tvHelloWorld;
    private TextView tvBid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivMao = findViewById(R.id.iv_mao);
        ivBid = findViewById(R.id.iv_bid);
        tvBid = findViewById(R.id.tv_bid);
        tvHelloWorld = findViewById(R.id.tv_hello_world);


        int screenHeight = ScreenUtils.getScreenHeight();
        int screenWidth = ScreenUtils.getScreenWidth();

        ViewGroup.LayoutParams layoutParams = ivMao.getLayoutParams();
        layoutParams.width = (int) (screenWidth * 0.8);
        layoutParams.height = (int) (screenWidth * 0.8);
        ivMao.setLayoutParams(layoutParams);


        ObjectAnimator ivBidAnimator = ObjectAnimator.ofFloat(ivBid, "translationY", 0, -(screenHeight * 0.9f), -(screenHeight * 0.68f));
        ObjectAnimator tvBidAnimator = ObjectAnimator.ofFloat(tvBid, "translationY", 0, -(screenHeight * 0.9f), -(screenHeight * 0.68f));
        ivBidAnimator.setDuration(800);
        tvBidAnimator.setDuration(800);
        ivBidAnimator.setInterpolator(new DecelerateInterpolator());
        tvBidAnimator.setInterpolator(new DecelerateInterpolator());
        ivBidAnimator.start();
        tvBidAnimator.start();
        ObjectAnimator tvHelloWorldAnimator = ObjectAnimator.ofFloat(tvHelloWorld, "translationY", 0, -(screenHeight * 0.84f), -(screenHeight * 0.62f));
        tvHelloWorldAnimator.setDuration(800);
        tvHelloWorldAnimator.setInterpolator(new DecelerateInterpolator());

        ObjectAnimator ivMaoAnimator = ObjectAnimator.ofFloat(ivMao, "translationY", 0, -(screenHeight * 0.60f), -(screenHeight * 0.48f));
        ivMaoAnimator.setDuration(800);
        ivMaoAnimator.setInterpolator(new DecelerateInterpolator());

        ivBidAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                tvHelloWorldAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        tvHelloWorldAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ivMaoAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ivMaoAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                ARouter.getInstance().build("/home/activity/main")
                        .withString("key", "huangqiubin")
                        .navigation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


}
