package com.example.a0314homework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button updatebutton;
    private TextView show;
    private EditText age,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updatebutton = findViewById(R.id.updatebutton);
        show = (TextView)findViewById(R.id.show);
        age = findViewById(R.id.age);
        name = findViewById(R.id.name);

        updatebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String Age = age.getText().toString();

                String Name = name.getText().toString();
                show.setText(Name+"的年龄是"+Age);
            }
        });
    }
}


