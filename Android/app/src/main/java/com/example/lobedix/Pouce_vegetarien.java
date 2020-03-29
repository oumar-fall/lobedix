package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_vegetarien extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_vegetarien);
        image = (ImageView) findViewById(R.id.vegetarien);
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


    public void PasVegetarien(View view){

        Intent pasVege = new Intent(Pouce_vegetarien.this, Pouce_Chaud_exotique.class);
        startActivity(pasVege);
    }

    public void Vegetarien(View view){

        Intent vege = new Intent(Pouce_vegetarien.this, Pouce_Chaud_Healthy.class);
        startActivity(vege);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasVege = new Intent(Pouce_vegetarien.this, Pouce_Chaud_exotique.class);
                startActivity(pasVege);

                message = "Les carnivores par ici !";
                break;
            case RIGHT_TO_LEFT:
                Intent vege = new Intent(Pouce_vegetarien.this, Pouce_Chaud_Healthy.class);
                startActivity(vege);
                message = "Des légumes, des légumes, des légumes !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}