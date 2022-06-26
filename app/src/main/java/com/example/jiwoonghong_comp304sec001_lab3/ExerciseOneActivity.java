package com.example.jiwoonghong_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.resources.TextAppearanceConfig;

public class ExerciseOneActivity extends AppCompatActivity {

    AnimationDrawable ex1FrameAnimation = null;
    TextView tvLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_one);

        tvLabel = findViewById(R.id.activity_exercise1_textBelow);

        final Button btnStart = (Button) findViewById(R.id.activity_exercise1_btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
                tvLabel.setText("I love rainy nights");
            }
        });

        final Button btnStop = (Button) findViewById(R.id.activity_exercise1_btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
                tvLabel.setText("");
            }
        });
    }

    private void startAnimation() {

        ImageView img = (ImageView) findViewById(R.id.activity_exercise1_imageview);

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_01);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_02);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_03);
        BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_04);
        BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_05);
        BitmapDrawable frame6 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_06);
        BitmapDrawable frame7 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_07);
        BitmapDrawable frame8 = (BitmapDrawable) getResources().getDrawable(R.drawable.rain_08);

        int duration = 250;

        ex1FrameAnimation = new AnimationDrawable();
        ex1FrameAnimation.setOneShot(false);
        ex1FrameAnimation.addFrame(frame1, duration);
        ex1FrameAnimation.addFrame(frame2, duration);
        ex1FrameAnimation.addFrame(frame3, duration);
        ex1FrameAnimation.addFrame(frame4, duration);
        ex1FrameAnimation.addFrame(frame5, duration);
        ex1FrameAnimation.addFrame(frame6, duration);
        ex1FrameAnimation.addFrame(frame7, duration);
        ex1FrameAnimation.addFrame(frame8, duration);

        img.setBackground(ex1FrameAnimation);

        ex1FrameAnimation.setVisible(true, true);
        ex1FrameAnimation.start();
    }

    private void stopAnimation()
    {
        ex1FrameAnimation.stop();
        ex1FrameAnimation.setVisible(false,false);
    }
}