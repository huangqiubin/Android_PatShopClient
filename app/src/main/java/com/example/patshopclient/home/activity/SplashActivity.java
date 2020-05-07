package com.example.patshopclient.home.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.example.android_patshopclient.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivMao;
    private TextView tvHelloWorld;
    private TextView tvBid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivMao = findViewById(R.id.iv_mao);
        tvBid = findViewById(R.id.tv_bid);
        tvHelloWorld = findViewById(R.id.tv_hello_world);

        Drawable drawable = getResources().getDrawable(R.drawable.icon_bid);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable.setTint(getResources().getColor(R.color.color_333333));
        }
        drawable.setBounds(0, 0, ConvertUtils.dp2px(50), ConvertUtils.dp2px(50));
        tvBid.setCompoundDrawablePadding(ConvertUtils.dp2px(8));
        tvBid.setCompoundDrawables(drawable, null, null, null);

        int screenHeight = ScreenUtils.getScreenHeight();
        int screenWidth = ScreenUtils.getScreenWidth();

        ViewGroup.LayoutParams layoutParams = ivMao.getLayoutParams();
        layoutParams.width = (int) (screenWidth * 0.8);
        layoutParams.height = (int) (screenWidth * 0.8);
        ivMao.setLayoutParams(layoutParams);

        ObjectAnimator tvBidAnimator = ObjectAnimator.ofFloat(tvBid, "translationY", 0, -(screenHeight * 0.9f), -(screenHeight * 0.80f));
        ObjectAnimator tvHelloWorldAnimator = ObjectAnimator.ofFloat(tvHelloWorld, "translationY", 0, -(screenHeight * 0.88f), -(screenHeight * 0.73f));
        ObjectAnimator ivMaoAnimator = ObjectAnimator.ofFloat(ivMao, "translationY", 0, -(screenHeight * 0.60f), -(screenHeight * 0.48f));
        tvBidAnimator.setDuration(800);
        tvBidAnimator.setInterpolator(new DecelerateInterpolator());
        tvHelloWorldAnimator.setDuration(800);
        tvHelloWorldAnimator.setInterpolator(new DecelerateInterpolator());
        ivMaoAnimator.setDuration(800);
        ivMaoAnimator.setInterpolator(new DecelerateInterpolator());

        tvBidAnimator.start();
        tvBidAnimator.addListener(new Animator.AnimatorListener() {
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
                ARouter.getInstance().build("/home/activity/main")
                        .withString("key", "huangqiubin")
                        .navigation();
                finish();
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
