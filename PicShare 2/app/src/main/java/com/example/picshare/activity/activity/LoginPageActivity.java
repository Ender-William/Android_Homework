package com.example.picshare.activity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.picshare.R;
import com.example.picshare.activity.api.Api;
import com.example.picshare.activity.api.ApiConfig;
import com.example.picshare.activity.api.TtitCallback;
import com.example.picshare.activity.entity.LoginResponse;
import com.example.picshare.activity.util.StringUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class LoginPageActivity extends BaseActivity {
    private Button LoginBtn,TransToSignUpBtn;
    private RadioButton RememberPwd;
    private EditText LoginUsername,LoginPasswd;
    private String account = null;
    private String pwd = null;
    private Intent TransToSignUpPageIntent = new Intent();
    private Intent TransToHomePageIntent = new Intent();

    @Override
    protected int initLayout() {
        return R.layout.loginpage;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //强制使用竖屏
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();

        LoginUsername = (EditText)findViewById(R.id.LoginUserNameET);
        LoginPasswd = (EditText)findViewById(R.id.LoginPasswdET);

        Intent GetSignUpPageInfo = getIntent();
        String GetSignUpPageUsername = null;
        GetSignUpPageUsername = GetSignUpPageInfo.getStringExtra("username");
        if (GetSignUpPageUsername !=""){
            LoginUsername.setText(GetSignUpPageUsername);
        }

        //跳转至主页面
        LoginBtn = (Button) findViewById(R.id.LoginBtn);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account = LoginUsername.getText().toString().trim();
                pwd = LoginPasswd.getText().toString().trim();
                login(account,pwd);
//
            }
        });

        //跳转至注册页面
        TransToSignUpBtn = (Button) findViewById(R.id.TransSignUpBtn);
        TransToSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(SignUpPageActivity.class,true);
            }
        });
    }

    private void login(String account, String pwd){
        if(StringUtils.isEmpty(account)){
            showToast("请输入账号");
            return;
        }
        if(StringUtils.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("userName",account);
        params.put("password",pwd);

        Api.config(ApiConfig.LOGIN, params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess", res);
//                showToastSync(res);
                Gson gson = new Gson();
                LoginResponse loginResponse = gson.fromJson(res,LoginResponse.class);
                if (loginResponse.getCode() == 1){
                    String token = loginResponse.getToken();
                    String msg = loginResponse.getMsg();
                    SaveStringToSharedPreferences("sp_ttit","username",account);
                    RememberPwd = (RadioButton) findViewById(R.id.RememberPassword);

                    if (RememberPwd.isChecked()){
                        SaveStringToSharedPreferences("sp_ttit","password",pwd);
                    }

                    SaveStringToSharedPreferences("sp_ttit","token",pwd);
                    SaveStringToSharedPreferences("sp_ttit","msg",msg);
                    navigateTo(HomeActivity.class,false);
                    //延时一秒钟结束Activity
                    DelayEndActivity(1000);
                    showToastSync("登录成功");
                }else{
                    showToastSync("登录失败");
                }

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}