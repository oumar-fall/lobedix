package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_Sucre_healthy extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_sucre_healthy);
        image = (ImageView) findViewById(R.id.healthy_sucre);
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

    public ImageView getImage(){
        return(image);
    }


    public void NoHealthy(View view){

        Intent nohealthy = new Intent(Pouce_Sucre_healthy.this, Pouce_Glace.class);
        startActivity(nohealthy);
    }

    public void Healthy(View view){

        Intent healthy = new Intent(Pouce_Sucre_healthy.this, Ingredients_salade.class);
        startActivity(healthy);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent nohealthy = new Intent(Pouce_Sucre_healthy.this, Pouce_Glace.class);
                startActivity(nohealthy);

                message = "C'est parti pour du bon gras !";
                break;
            case RIGHT_TO_LEFT:
                Intent healthy = new Intent(Pouce_Sucre_healthy.this, Ingredients_salade.class);
                startActivity(healthy);
                message = "Salade de fruits !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}