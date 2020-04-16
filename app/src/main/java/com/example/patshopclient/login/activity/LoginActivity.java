package com.example.patshopclient.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.BaseActivity;

@Route(path = "login/login_activity")
public class LoginActivity extends BaseActivity {

    private EditText etPhone;
    private EditText etVerifyCode;
    private TextView tvGetCode;
    private TextView btnSubmit;


    @Override
    public int onBindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        etPhone = findViewById(R.id.et_phone);
        etVerifyCode = findViewById(R.id.et_verified);
        tvGetCode = findViewById(R.id.tv_get_code);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        super.initListener();
        tvGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
