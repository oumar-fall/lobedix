package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_Glace extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_glace);
        image = (ImageView) findViewById(R.id.petite_glace);
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


    public void PasGlace(View view){

        Intent pasGlace = new Intent(Pouce_Glace.this, Pouce_chocolat.class);
        startActivity(pasGlace);
    }

    public void Glace(View view){

        Intent glace = new Intent(Pouce_Glace.this, Ingredients_glace.class);
        startActivity(glace);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasGlace = new Intent(Pouce_Glace.this, Pouce_chocolat.class);
                startActivity(pasGlace);

                message = "Essayons quelque chose de moins froid !";
                break;
            case RIGHT_TO_LEFT:
                Intent glace = new Intent(Pouce_Glace.this, Ingredients_glace.class);
                startActivity(glace);
                message = "Et une glace vanille, une !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}