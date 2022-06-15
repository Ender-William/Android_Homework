package com.example.picshare.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.picshare.R;
import com.example.picshare.activity.util.Basic;

public class SignUpPageActivity extends AppCompatActivity {
    private EditText UserNameET,PasswdET,RePasswdET,EmailET,InviteCodeET;
    private Button SignUpBtn;
    private String UserName = null;
    private String Passwd = null;
    private String RePasswd = null;

    private View.OnClickListener CheckAndTransToLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.SignUpBtn:
                    //点击注册
                    UserName = UserNameET.getText().toString();
                    Passwd = PasswdET.getText().toString();
                    RePasswd = RePasswdET.getText().toString();

                    //验证密码是否一致
                    if(Basic.SignUpServices(UserName,Passwd,RePasswd)){
                        // 通过验证
                        Toast.makeText(SignUpPageActivity.this,
                                "用户" + UserName + "注册成功!" + "\n" + "密码是" + Passwd,
                                Toast.LENGTH_SHORT).show();

                        //页面跳转，顺道传参
                        Intent intent1 = new Intent();
                        intent1.setClass(SignUpPageActivity.this,LoginPageActivity.class);
                        //startActivity(intent1);
                        intent1.putExtra("username",UserName);//传递注册成功的用户名
                        startActivity(intent1, ActivityOptions.makeSceneTransitionAnimation(SignUpPageActivity.this).toBundle());

                    }else {
                        // 不能通过验证
                        Toast.makeText(SignUpPageActivity.this, "用户" + UserName + "注册失败!",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);

        //强制使用竖屏
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();

        UserNameET = (EditText) findViewById(R.id.UserNameET);
        PasswdET = (EditText) findViewById(R.id.PasswdET);
        RePasswdET = (EditText) findViewById(R.id.RePasswdET);
        SignUpBtn = (Button) findViewById(R.id.SignUpBtn);


        SignUpBtn.setOnClickListener(CheckAndTransToLogin);
    }
}