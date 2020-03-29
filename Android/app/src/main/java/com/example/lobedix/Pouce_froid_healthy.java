package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_froid_healthy extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_froid_healthy);
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

        Intent pasHealthy = new Intent(Pouce_froid_healthy.this, Ingredients_feuillete.class);
        startActivity(pasHealthy);
    }

    public void Healthy(View view){

        Intent healthy = new Intent(Pouce_froid_healthy.this, Ingredients_tomates.class);
        startActivity(healthy);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasHealthy = new Intent(Pouce_froid_healthy.this, Ingredients_feuillete.class);
                startActivity(pasHealthy);

                message = "Petit feuilleté pour bien démarrer !";
                break;
            case RIGHT_TO_LEFT:
                Intent healthy = new Intent(Pouce_froid_healthy.this, Ingredients_tomates.class);
                startActivity(healthy);
                message = "Une bonne salade de tomates !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}