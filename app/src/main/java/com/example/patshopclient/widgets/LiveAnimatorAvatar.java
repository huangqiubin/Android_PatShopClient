package com.example.patshopclient.widgets;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ConvertUtils;
import com.example.android_patshopclient.R;

/**
 * Created by qiubin on 2020-04-16.
 * Describe: 视频头像动画
 */
public class LiveAnimatorAvatar extends RelativeLayout {

    private Paint paint;
    private ImageView ivAvatar;
    private int avatarWidth;
    private int avatarHeight;
    private float firstCircleRadius;
    private float secondCircleRadius;
    private float thirdCircleRadius;
    private int secondAndThirdAlpha;
    private float mRadius;//增加的半径


    public LiveAnimatorAvatar(Context context) {
        this(context, null);
    }

    public LiveAnimatorAvatar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LiveAnimatorAvatar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.live_animator_avatar, this);
        ivAvatar = findViewById(R.id.iv_avatar);
        ViewGroup.LayoutParams layoutParams = ivAvatar.getLayoutParams();
        avatarWidth = layoutParams.width;
        avatarHeight = layoutParams.height;
        firstCircleRadius = (float) avatarWidth / 2 + ConvertUtils.dp2px(3);
        secondCircleRadius = (float) avatarWidth / 2 + ConvertUtils.dp2px(8);
        thirdCircleRadius = (float) avatarWidth / 2 + ConvertUtils.dp2px(20);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.color_D44430));
        paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(3f);
        paint.setAlpha(1);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, firstCircleRadius, paint);
        paint.setStrokeWidth(1.5f);
        paint.setAlpha(secondAndThirdAlpha);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, secondCircleRadius + mRadius, paint);
        paint.setStrokeWidth(0.2f);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, thirdCircleRadius + mRadius, paint);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void start() {
        //半径变大动画
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 8);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mRadius = (int) animation.getAnimatedValue() * 2;
                Log.d("huangqiubin", "mRadius : " + mRadius);
            }
        });
    }
}
