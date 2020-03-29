package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_Chaud_Healthy extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce__chaud__healthy);
        image = (ImageView) findViewById(R.id.sale_healthy);
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


    public void PasHealthy(View view){

        Intent pasHealthy = new Intent(Pouce_Chaud_Healthy.this, Ingredients_lasagnes.class);
        startActivity(pasHealthy);
    }

    public void Healthy(View view){

        Intent healthy = new Intent(Pouce_Chaud_Healthy.this, Pouce_soupe.class);
        startActivity(healthy);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasHealthy = new Intent(Pouce_Chaud_Healthy.this, Ingredients_lasagnes.class);
                startActivity(pasHealthy);

                message = "Lasagnes Végétariennes spécialité du chef !";
                break;
            case RIGHT_TO_LEFT:
                Intent healthy = new Intent(Pouce_Chaud_Healthy.this, Pouce_soupe.class);
                startActivity(healthy);
                message = "Des légumes, et diet en plus !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}