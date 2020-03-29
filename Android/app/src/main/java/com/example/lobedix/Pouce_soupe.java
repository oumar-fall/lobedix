package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_soupe extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_soupe);
        image = (ImageView) findViewById(R.id.pouce_soupe);
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


    public void PasSoupe(View view){

        Intent pasSoupe = new Intent(Pouce_soupe.this, Ingredients_ratatouille.class);
        startActivity(pasSoupe);
    }

    public void Soupe(View view){

        Intent soupe = new Intent(Pouce_soupe.this, Ingredients_soupe.class);
        startActivity(soupe);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasSoupe = new Intent(Pouce_soupe.this, Ingredients_ratatouille.class);
                startActivity(pasSoupe);

                message = "Une ratatouille pour raviver vos souvenirs d'enfance !";
                break;
            case RIGHT_TO_LEFT:
                Intent soupe = new Intent(Pouce_soupe.this, Ingredients_soupe.class);
                startActivity(soupe);
                message = "Soupe des légumes du soleil pour illuminer votre assiette !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
