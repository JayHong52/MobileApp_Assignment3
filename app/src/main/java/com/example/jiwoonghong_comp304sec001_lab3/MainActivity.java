package com.example.jiwoonghong_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this,MenuActivity.class);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.activity_main_logo);
        textView.setText("Welcome!");

        startActivity(intent);

    }
}