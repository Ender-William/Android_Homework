package com.example.a0523test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SedActivity extends AppCompatActivity {

    private TextView showStr;
    private String tempStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sed);

        showStr = findViewById(R.id.ShowStrTV);

        Intent getStr = getIntent();
        tempStr = getStr.getStringExtra("show");

        showStr.setText(tempStr);



    }
}