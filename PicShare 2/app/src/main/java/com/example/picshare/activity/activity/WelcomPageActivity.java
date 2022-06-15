package com.example.picshare.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.picshare.R;
import com.example.picshare.activity.api.Api;
import com.example.picshare.activity.api.ApiConfig;
import com.example.picshare.activity.api.TtitCallback;
import com.example.picshare.activity.entity.LoginResponse;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomPageActivity extends BaseActivity {

    private String account;
    private String pwd;

    @Override
    protected int initLayout() {
        return R.layout.welcomepage;
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

        if (CheckisSharedPreferencesContains("sp_ttit","username") &&
                CheckisSharedPreferencesContains("sp_ttit","password")){
            account = GetStringSharedPreferencesContains("sp_ttit","username");
            pwd = GetStringSharedPreferencesContains("sp_ttit","password");
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("userName",account);
            params.put("password",pwd);
            Api.config(ApiConfig.LOGIN, params).postRequest(new TtitCallback() {
                @Override
                public void onSuccess(String res) {
                    Log.e("onSuccess", res);
                    Gson gson = new Gson();
                    LoginResponse loginResponse = gson.fromJson(res,LoginResponse.class);
                    if (loginResponse.getCode() == 1){
                        String token = loginResponse.getToken();
                        String msg = loginResponse.getMsg();
                        SaveStringToSharedPreferences("sp_ttit","username",account);
                        SaveStringToSharedPreferences("sp_ttit","password",pwd);
                        SaveStringToSharedPreferences("sp_ttit","token",token);
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

        Button clickNextPageBtn;
        clickNextPageBtn = (Button) findViewById(R.id.NextPageBtn);
        clickNextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(LoginPageActivity.class,false);
                //延时一秒钟结束Activity
                DelayEndActivity(1000);
            }
        });

    }
}
