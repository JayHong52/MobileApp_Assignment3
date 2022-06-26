package com.example.jiwoonghong_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickExerciseButton(View v)
    {
        if (v.getId() == R.id.activity_menu_btn_exercise1){
            Intent intent = new Intent(this, ExerciseOneActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.activity_menu_btn_exercise2){
            Intent intent = new Intent(this, ExerciseTwoActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.activity_menu_btn_exercise3){
            Intent intent = new Intent(this, ExerciseThreeActivity.class);
            startActivity(intent);
        }
    }
}