package com.example.patshopclient.login.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ObjectUtils;
import com.example.android_patshopclient.R;
import com.example.lib_http.RetrofitManager;
import com.example.lib_http.entity.home.LoginDTO;
import com.example.lib_http.service.LoginService;
import com.example.patshopclient.common.BaseActivity;
import com.example.lib_userinfo.config.UserInfoBean;
import com.example.patshopclient.common.config.PathConfig;
import com.example.patshopclient.home.activity.MainActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Route(path = PathConfig.LOGIN)
public class LoginActivity extends BaseActivity {

    @Autowired(name = "fromRequest")
    public boolean isFromRequest;

    private EditText etPhone;
    private EditText etVerifyCode;
    private TextView btnSubmit;
    private ImageView ivClear;
    private ImageView ivPasswordClear;
    private ImageView ivBack;


    @Override
    public int onBindLayout() {
        return R.layout.activity_login1;
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
        etPhone = findViewById(R.id.et_phone);
        etVerifyCode = findViewById(R.id.et_verified);
        btnSubmit = findViewById(R.id.btn_submit);
        ivClear = findViewById(R.id.iv_clear);
        ivPasswordClear = findViewById(R.id.iv_password_clear);
        ivBack = findViewById(R.id.iv_back);
        if (isFromRequest) {
            new MaterialAlertDialogBuilder(getContext())
                    .setTitle("需要先登陆才会有数据哦")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
    }

    @Override
    public void initData() {

    }


    public void getLogin(String username, String password) {
        LoginService loginService = RetrofitManager.getInstance().getLoginService();
        Call<LoginDTO> loginCall = loginService.getLogin(username, password);
        loginCall.enqueue(new Callback<LoginDTO>() {
            @Override
            public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                if (response == null) {
                    new MaterialAlertDialogBuilder(getContext())
                            .setTitle("登陆失败，请重试！")
                            .create().show();
                    return;
                }
                LoginDTO loginDTO = response.body();

                String sessionId = loginDTO.getData().getSerializable();
                LoginDTO.DataBean.UmsMemberDaoBean memberBean = loginDTO.getData().getUmsMemberDao();
                UserInfoBean.getInstance().clearUserInfo();
                UserInfoBean.getInstance().saveUname(username);
                UserInfoBean.getInstance().saveSessionId(sessionId);
                UserInfoBean.getInstance().saveUserIdentity(memberBean.getManager());
                UserInfoBean.getInstance().saveUphone(memberBean.getPhone());
                UserInfoBean.getInstance().saveUavator(memberBean.getIcon());
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<LoginDTO> call, Throwable t) {
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("网络发生了一点错误，请稍后重试")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();
            }
        });


    }

    @Override
    public void initListener() {
        super.initListener();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etPhone.getText().toString();
                String code = etVerifyCode.getText().toString();
                if (ObjectUtils.isEmpty(userName)) {
                    new MaterialAlertDialogBuilder(getContext())
                            .setTitle("请输入用户名")
                            .create().show();
                    return;
                }
                if (ObjectUtils.isEmpty(etVerifyCode.getText().toString())) {
                    new MaterialAlertDialogBuilder(getContext())
                            .setTitle("请输入密码")
                            .create().show();
                    return;
                }
                getLogin(userName, code);
            }
        });

        ivClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPhone.setText("");
            }
        });

        ivPasswordClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etVerifyCode.setText("");
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
