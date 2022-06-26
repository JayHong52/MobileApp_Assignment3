package com.example.jiwoonghong_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ExerciseThreeActivity extends AppCompatActivity {

    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    private ImageView reusableImageView;

    private int current_X;
    private int current_Y;
    private int increment_X;
    private int increment_Y;
    private int increment_0;

    private Integer[] brushSize = {5, 10, 15, 20, 30, 40, 50};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_three);
        reusableImageView = findViewById(R.id.activity_exercise3_canvas);
        init();
    }

    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                drawDown();
                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                drawLeft();
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                drawUp();
                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                drawRight();
                return true;
        }
        return false;
    }
    // helper methods
    private void drawLeft() {
        if (this.current_X - this.increment_X < 0) {
            Toast.makeText(this, "Left...", Toast.LENGTH_SHORT).show();
        } else {
            this.drawLine(this.canvas, -this.increment_X, this.increment_0);
            this.reusableImageView.invalidate();
        }
    }

    private void drawUp() {
        if (this.current_Y - this.increment_Y < 0) {
            Toast.makeText(this, "Up...", Toast.LENGTH_SHORT).show();
        } else {
            this.drawLine(this.canvas, this.increment_0, -this.increment_Y);
            this.reusableImageView.invalidate();
        }
    }

    private void drawRight() {
        if (this.current_X + this.increment_X > this.bitmap.getWidth()) {
            Toast.makeText(this, "Right...", Toast.LENGTH_SHORT).show();
        } else {
            this.drawLine(this.canvas, this.increment_X, this.increment_0);
            // force redraw/update canvas
            this.reusableImageView.invalidate();
        }
    }

    private void drawDown() {
        if (this.current_Y + this.increment_Y > this.bitmap.getHeight()) {
            Toast.makeText(this, "Down...", Toast.LENGTH_SHORT).show();
        } else {
            this.drawLine(this.canvas, this.increment_0, this.increment_Y);
            this.reusableImageView.invalidate();
        }
    }

    private void init() {

        // Paint Setting
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);

        bitmap = Bitmap.createBitmap(1000,1000, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.BLACK);

        reusableImageView = findViewById(R.id.activity_exercise3_canvas);
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

        this.increment_X = 20;
        this.increment_Y = 20;
        this.increment_0 = 0;

        this.resetCanvas();

        // Event Handlers

        // Color Button


        final ImageButton button_red = (ImageButton) findViewById(R.id.activity_exercise3_color_red);
        button_red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                paint.setColor(Color.RED);
            }
        });

        final ImageButton button_green = (ImageButton) findViewById(R.id.activity_exercise3_color_green);
        button_green.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                paint.setColor(Color.GREEN);
            }
        });

        final ImageButton button_blue = (ImageButton) findViewById(R.id.activity_exercise3_color_blue);
        button_blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                paint.setColor(Color.BLUE);
            }
        });


        findViewById(R.id.activity_exercise3_arrow_up).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ExerciseThreeActivity.this.drawUp();
                return true;
            }
        });

        findViewById(R.id.activity_exercise3_arrow_down).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ExerciseThreeActivity.this.drawDown();
                return true;
            }
        });

        findViewById(R.id.activity_exercise3_arrow_left).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ExerciseThreeActivity.this.drawLeft();
                return true;
            }
        });

        findViewById(R.id.activity_exercise3_arrow_right).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ExerciseThreeActivity.this.drawRight();
                return true;
            }
        });

        findViewById(R.id.activity_exercise3_button_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExerciseThreeActivity.this.resetCanvas();
            }
        });

        //Spinner Brush Size
        Spinner spinner = findViewById(R.id.activity_exercise3_spinner);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, brushSize);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override   //
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paint.setStrokeWidth(Integer.valueOf(brushSize[position]));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    // Start
    private void startDrawing() {
        this.canvas.drawPoint(0, 0, this.paint);
    }


    // Reset
    private void resetCanvas() {
        this.canvas.drawColor(Color.WHITE);
        this.current_X = this.current_Y = 0;
        this.startDrawing();
    }

    private void drawLine(Canvas canvas, int xIncrement, int yIncrement) {
        this.canvas.drawLine(current_X, current_Y, current_X += xIncrement, current_Y += yIncrement, this.paint);
    }
}



