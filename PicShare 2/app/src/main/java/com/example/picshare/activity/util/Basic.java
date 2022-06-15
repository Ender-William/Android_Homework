package com.example.picshare.activity.util;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public class Basic {
    public static boolean isStringSame(String str1,String str2){
        if (str1.equals(str2)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean SignUpServices(String username,String passwd,String repasswd){
        if ((passwd.equals(repasswd)) && (username != "") && (username.length() != 0)
                && (passwd != "") && (passwd.length() != 0))
            // 上述判断依次为密码一致性判断,用户名不为空判断,密码不为空判断
            return true;
        return false;
    }

}
