package com.example.patshopclient.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.BaseActivity;

@Route(path = "login/login_activity")
public class LoginActivity extends BaseActivity {

    private EditText etPhone;
    private EditText etVerifyCode;
    private TextView btnSubmit;
    private ImageView ivClear;
    private ImageView ivPasswordClear;


    @Override
    public int onBindLayout() {
        return R.layout.activity_login1;
    }

    @Override
    public void initView() {
        etPhone = findViewById(R.id.et_phone);
        etVerifyCode = findViewById(R.id.et_verified);
        btnSubmit = findViewById(R.id.btn_submit);
        ivClear = findViewById(R.id.iv_clear);
        ivPasswordClear = findViewById(R.id.iv_password_clear);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        super.initListener();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
