package com.example.picshare.activity.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView();
        initData();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    public void showToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public void navigateTo(Class cls,boolean bool){
        Intent in = new Intent(mContext,cls);
        if(bool){
            startActivity(in, ActivityOptions.makeSceneTransitionAnimation((Activity) mContext).toBundle());
        }else{
            startActivity(in);
        }

    }

    protected void SaveStringToSharedPreferences(String spName, String key, String val) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,val);
        editor.commit();
    }

    protected void SaveIntToSharedPreferences(String spName, String key, int val) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,val);
        editor.commit();
    }

    protected void SaveFloatToSharedPreferences(String spName, String key, float val) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key,val);
        editor.commit();
    }

    protected void SaveBooleanToSharedPreferences(String spName, String key, boolean val) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,val);
        editor.commit();
    }

    protected boolean CheckisSharedPreferencesContains(String spName, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        boolean isContains = sharedPreferences.contains(key);
        return isContains;
    }

    protected String GetStringSharedPreferencesContains(String spName, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        String val = sharedPreferences.getString(key,null);
        return val;
    }

    protected int GetIntSharedPreferencesContains(String spName, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(spName,MODE_PRIVATE);
        int val = sharedPreferences.getInt(key,0);
        return val;
    }

    protected void DelayEndActivity(int sed) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        },sed);
    }

}
