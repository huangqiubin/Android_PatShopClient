package com.example.patshopclient.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.Html;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.blankj.utilcode.util.ObjectUtils;

/**
 * 自定义倒计时文本控件
 * 支持 XX:xx:xx 格式的倒计时  : 可自己替换
 *
 * @author shenxueyuan  2019-06-13
 */
public class WPTTimeTextView extends AppCompatTextView implements Runnable {

    private String frontText = "", mHourSplit = ":", mMinSplit = ":", mSecondSplit = "";
    // 画笔  拓展样式
    Paint mPaint;
    // 天，小时，分钟，秒
    public long mday, mhour, mmin, msecond;
    // 是否启动了
    private boolean run = false;
    // 服务器当前时间
    private long serverNowTime = 0;
    // 倒计时结束回调
    private TimeCountDownListener countDownListener;
    // 倒计时回调
    private TimeCountRunListener timeCountRunListener;
    // 回调参数
    private String uri;
    public boolean hasDay = false;

    public WPTTimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public WPTTimeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
    }

    public WPTTimeTextView(Context context) {
        super(context);
    }

    /**
     * 设置截止时间
     * adapter 每次加载的时候，都要重新设置一下 deadline 防止重用导致时间错乱。自己
     *
     * @param deadline 截止时间
     *                 如果时间不传，默认取本地时间
     */
    public void setDeadLine(long deadline) {
        if (String.valueOf(deadline).length() == 10) {
            deadline = deadline * 1000;
        }
        // 根据当前时间、截止时间  算出 时间差
        long curTime = System.currentTimeMillis();
        if (serverNowTime > 0) {
            curTime = serverNowTime;
        }
        if (String.valueOf(curTime).length() == 10) {
            curTime = curTime * 1000;
        }
        if (deadline > curTime) {
            long diff = deadline - curTime;
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            long second = (diff / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);

            mday = days;
            if (!hasDay) {
                hours += days * 24;
            }
            mhour = hours;
            mmin = minutes;
            msecond = second;
        } else {
            mday = 0;
            mhour = 0;
            mmin = 0;
            msecond = 0;
        }
    }

    // 时间long型 2:1 返回String 02：01
    public String long2String(long longNum) {
        String mLongNum = longNum + "";
        if (longNum < 10) {
            mLongNum = "0" + mLongNum;
        }
        return mLongNum;
    }

    /**
     * 设置截止时间
     *
     * @param deadline      截止时间
     * @param serverNowTime 服务器当前时间
     */
    public void setDeadLine(long deadline, long serverNowTime) {
        this.serverNowTime = serverNowTime;
        setDeadLine(deadline);
    }

    public void setDeadLine(long deadline, long serverNowTime, String mHourSplit, String mMinSplit, String mSecondSplit) {
        this.serverNowTime = serverNowTime;
        this.mHourSplit = mHourSplit;
        this.mMinSplit = mMinSplit;
        this.mSecondSplit = mSecondSplit;
        setDeadLine(deadline);
    }

    /**
     * 设置倒计时的前缀 倒计时：剩余时间：xxxx： 等
     *
     * @param frontText
     */
    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    /**
     * 设置截止时间
     *
     * @param deadline      截止时间
     * @param serverNowTime 服务器当前时间
     */
    public void setDeadLine(long deadline, long serverNowTime, String uri) {
        this.serverNowTime = serverNowTime;
        this.uri = uri;
        setDeadLine(deadline);
    }

    /**
     * 倒计时计算
     * 这边计算比较傻瓜式
     */
    private void ComputeTime() {
        if (mday == 0 && mhour == 0 && mmin == 0 && msecond == 0) {
            return;
        }
        msecond--;
        if (msecond < 0) {
            mmin--;
            msecond = 59;
            if (mmin < 0) {
                mmin = 59;
                mhour--;
                if (mhour < 0) {
                    // 倒计时结束
                    mhour = 24;
                    mday--;
                }
            }
        }
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public void run() {
        //标示已经启动
        run = true;

        ComputeTime();
        // 00:01:21 00:01:21  00小时:21分:21秒
        String strTime = frontText + (ObjectUtils.isNotEmpty(mHourSplit) ? (mhour < 10 ? "0" + mhour : mhour) : "")
                + mHourSplit // 小时分隔符
                + (mmin < 10 ? "0" + mmin : mmin)
                + mMinSplit // 分钟分隔符
                + (msecond < 10 ? "0" + msecond : msecond)
                + mSecondSplit; // 秒分隔符福
        this.setText(Html.fromHtml(strTime));
        if (timeCountRunListener != null) {
            timeCountRunListener.onCountRunCallback(mhour, mmin, msecond);
        }
        // 如果倒计时为0了，给回调，不做循环
        if (mday == 0 && mhour == 0 & mmin == 0 && msecond == 0) {
            if (countDownListener != null) {
                run = false;
                removeCallbacks(this);
                countDownListener.onCountDownOver(uri);
            }
        } else {
            // 否则隔一秒更新一次
            postDelayed(this, 1000);
        }
    }

    public void setCountDownListener(TimeCountDownListener countDownListener) {
        this.countDownListener = countDownListener;
    }

    public interface TimeCountDownListener {
        public void onCountDownOver(String uri);
    }

    public interface TimeCountRunListener {
        public void onCountRunCallback(long hour, long min, long sec);
    }

    public void setCountRunListener(TimeCountRunListener runListener) {
        this.timeCountRunListener = runListener;
    }
}