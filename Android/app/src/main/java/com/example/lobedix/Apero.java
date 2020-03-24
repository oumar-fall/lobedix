package com.example.lobedix;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Apero extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apero);
        image = (ImageView) findViewById(R.id.apero);
        swipeDetector = new SwipeGestureDetector(this);
        image.setOnTouchListener(new View.OnTouchListener() {
            float x = image.getX();
            float y = image.getY();
            public boolean onTouch(View v, MotionEvent event) {
                //image.setX(x + (event.getX()-x)/10);
                //image.setY(y + (event.getY()-y)/10);
                swipeDetector.onTouchEvent(event);
                return(true);
            }
        });

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
            case LEFT_TO_RIGHT:
                Intent command = new Intent(Apero.this, commandType.class);
                startActivity(command);

                message = "Pas d'apéro !";
                break;
            case RIGHT_TO_LEFT:
                Intent choixApero = new Intent(Apero.this, ChoixApero.class);
                startActivity(choixApero);
                message = "Un petit apéro !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
