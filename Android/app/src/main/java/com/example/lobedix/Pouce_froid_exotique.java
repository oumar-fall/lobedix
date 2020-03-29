package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_froid_exotique extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_froid_exotique);
        image = (ImageView) findViewById(R.id.froid_exotique);
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


    public void PasExotique(View view){

        Intent pasExotique = new Intent(Pouce_froid_exotique.this, Pouce_froid_healthy.class);
        startActivity(pasExotique);
    }

    public void Exotique(View view){

        Intent exotique = new Intent(Pouce_froid_exotique.this, Ingredients_taboule.class);
        startActivity(exotique);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasExotique = new Intent(Pouce_froid_exotique.this, Pouce_froid_healthy.class);
                startActivity(pasExotique);

                message = "Restons sur des plats français !";
                break;
            case RIGHT_TO_LEFT:
                Intent exotique = new Intent(Pouce_froid_exotique.this, Ingredients_taboule.class);
                startActivity(exotique);
                message = "Direction l'orient avec ce petit taboulet !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}