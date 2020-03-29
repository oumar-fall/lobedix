package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_chaud_froid extends AppCompatActivity {
    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_chaud_froid);
        image = (ImageView) findViewById(R.id.chaud);
        swipeDetector = new SwipeGestureDetector(this);
        image.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                swipeDetector.onTouchEvent(event);
                return(true);
            }
        });

    }

    public ImageView getImage(){
        return(image);
    }


    public void Chaud(View view){

        Intent chaud = new Intent(Pouce_chaud_froid.this, Pouce_vegetarien.class);
        startActivity(chaud);
    }

    public void Froid(View view){

        Intent froid = new Intent(Pouce_chaud_froid.this, Pouce_froid_exotique.class);
        startActivity(froid);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent chaud = new Intent(Pouce_chaud_froid.this, Pouce_vegetarien.class);
                startActivity(chaud);

                message = "En avant pour un plat bien chaud !";
                break;
            case RIGHT_TO_LEFT:
                Intent froid = new Intent(Pouce_chaud_froid.this, Pouce_froid_exotique.class);
                startActivity(froid);
                message = "Vers les entrées et les plats d'été !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
