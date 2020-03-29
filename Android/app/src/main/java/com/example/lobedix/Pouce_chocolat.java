package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_chocolat extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_chocolat);
        image = (ImageView) findViewById(R.id.chocolat);
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


    public void PasChocolat(View view){

        Intent pasChocolat = new Intent(Pouce_chocolat.this, Dish_informations_creme.class);
        startActivity(pasChocolat);
    }

    public void Chocolat(View view){

        Intent chocolat = new Intent(Pouce_chocolat.this, Dish_informations_mousse.class);
        startActivity(chocolat);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent pasChocolat = new Intent(Pouce_chocolat.this, Dish_informations_creme.class);
                startActivity(pasChocolat);

                message = "Il ne reste plus que la crème alors !";
                break;
            case RIGHT_TO_LEFT:
                Intent chocolat = new Intent(Pouce_chocolat.this, Dish_informations_mousse.class);
                startActivity(chocolat);
                message = "Une petite mousse pour vous ravir !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}