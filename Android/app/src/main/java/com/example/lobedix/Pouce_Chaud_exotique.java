package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_Chaud_exotique extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce__chaud_exotique);
        image = (ImageView) findViewById(R.id.chaud_exotique);
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

        Intent pasExotique = new Intent(Pouce_Chaud_exotique.this, Ingredients_spaghetti.class);
        startActivity(pasExotique);
    }

    public void Exotique(View view){

        Intent exotique = new Intent(Pouce_Chaud_exotique.this, Ingredients_curry.class);
        startActivity(exotique);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasExotique = new Intent(Pouce_Chaud_exotique.this, Ingredients_spaghetti.class);
                startActivity(pasExotique);

                message = "Classique indémodable : spaghetti bolognaises !";
                break;
            case RIGHT_TO_LEFT:
                Intent exotique = new Intent(Pouce_Chaud_exotique.this, Ingredients_curry.class);
                startActivity(exotique);
                message = "Parfum d'Asie avec ce poulet curry !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
