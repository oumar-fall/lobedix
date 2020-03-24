package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Apero extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apero);

        swipeDetector = new SwipeGestureDetector(this);
    }

    public boolean dispatchTouchEvent(MotionEvent event){
        return swipeDetector.onTouchEvent(event);
    }

    public void NoApero(View view){

        Intent command = new Intent(Apero.this, commandType.class);
        startActivity(command);
    }

    public void Apero(View view){

        Intent choixApero = new Intent(Apero.this, ChoixApero.class);
        startActivity(choixApero);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case RIGHT_TO_LEFT:
                Intent command = new Intent(Apero.this, commandType.class);
                startActivity(command);
                message = "Right to left swipe";
                break;
            case LEFT_TO_RIGHT:
                Intent choixApero = new Intent(Apero.this, ChoixApero.class);
                startActivity(choixApero);
                message = "Left to Right swipe";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
