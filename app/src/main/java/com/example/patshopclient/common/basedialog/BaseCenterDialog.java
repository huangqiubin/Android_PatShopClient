package com.example.patshopclient.common.basedialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.android_patshopclient.R;


/**
 * created by xuyunlong on 2018/12/11
 */
public abstract class BaseCenterDialog extends AlertDialog {
    protected View rootView;

    protected BaseCenterDialog(@NonNull Context context) {
        this(context, R.style.dialog_common_theme_bottom);
    }

    protected BaseCenterDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        rootView = LayoutInflater.from(context).inflate(getLayoutId(), null);
        setView(rootView);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    protected abstract int getLayoutId();

    protected void initView() {

    }
}
