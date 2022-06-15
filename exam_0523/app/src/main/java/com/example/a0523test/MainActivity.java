package com.example.a0523test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button SubBtn;
    private EditText NamET;
    private EditText ScorET;
    private String NameStr;
    private String ScorStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SubBtn = findViewById(R.id.subBtn);
        NamET = findViewById(R.id.InputName);
        ScorET = findViewById(R.id.InputScore);

        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NameStr = NamET.getText().toString();
                ScorStr = ScorET.getText().toString();

                Intent intent = new Intent();
                String sendMsg;
                sendMsg = NameStr + " 的成绩是 " + ScorStr;
                intent.setClass(MainActivity.this,SedActivity.class);
                intent.putExtra("show",sendMsg);
                startActivity(intent);

            }
        });

    }
}