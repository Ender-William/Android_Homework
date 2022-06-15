package com.example.picshare.activity.util;

public class StringUtils {

    //判断字符串是否为空
    public static boolean isEmpty(String str){
        if(str == null || str.length()<=0){
            return true;
        }else{
            return false;
        }
    }
}
