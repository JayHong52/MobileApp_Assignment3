package com.example.jiwoonghong_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ExerciseTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_two);

        final Button btnStart = (Button) findViewById(R.id.activity_exercise2_btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimationSpaceTravel(R.anim.anim_space_travel);
                performAnimationEarth(R.anim.anim_earth);
                performAnimationMars(R.anim.anim_mars);
            }
        });
    }

    private void performAnimationSpaceTravel(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.activity_exercise2_spaceship);

        reusableImageView.setImageResource(R.drawable.rocket);

        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    private void performAnimationEarth(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.activity_exercise2_earth);

        reusableImageView.setImageResource(R.drawable.earth);

        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    private void performAnimationMars(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.activity_exercise2_mars);

        reusableImageView.setImageResource(R.drawable.mars);

        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView rocket = (ImageView)findViewById(R.id.activity_exercise2_spaceship);
            ImageView earth = (ImageView)findViewById(R.id.activity_exercise2_earth);
            ImageView mars = (ImageView)findViewById(R.id.activity_exercise2_mars);

            rocket.setVisibility(View.INVISIBLE);
            earth.setVisibility(View.INVISIBLE);
            mars.setVisibility(View.INVISIBLE);

            // Enable all buttons once animation is ove
        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running

        }
    }
}