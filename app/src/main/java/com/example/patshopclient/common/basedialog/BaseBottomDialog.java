package com.example.patshopclient.common.basedialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.ScreenUtils;
import com.example.android_patshopclient.R;

/**
 * created by xuyunlong on 2018/11/15
 */
public abstract class BaseBottomDialog extends AlertDialog {
    protected View rootView;
    protected Context mContext;

    protected BaseBottomDialog(@NonNull Context context) {
        this(context, R.style.dialog_common_theme);
    }

    protected BaseBottomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setWindowAnimations(R.style.dlg_bottom_style);
        window.getDecorView().setPadding(0, 0, 0, 0);
        if (ScreenUtils.isLandscape() && needFillHeightWhenLandscape()) {
            window.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
            lp.width = ScreenUtils.getScreenWidth() * 3 / 5;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        } else {
            window.setGravity(Gravity.BOTTOM);
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            if (heightWeight() == 0f) {
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            } else {
                lp.height = (int) (ScreenUtils.getScreenHeight() * heightWeight());
            }

        }
        window.setAttributes(lp);
        window.setDimAmount(0.3f);
        rootView = LayoutInflater.from(context).inflate(getLayoutId(), null);
        initView();
        setView(rootView);
    }

    protected float heightWeight() {
        return 0f;
    }

    protected boolean needFillHeightWhenLandscape() {
        return true;
    }

    protected void initView() {

    }

    protected abstract int getLayoutId();


}
