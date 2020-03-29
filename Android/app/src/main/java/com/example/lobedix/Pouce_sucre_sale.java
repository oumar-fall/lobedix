package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Pouce_sucre_sale extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pouce_sucre_sale);
        image = (ImageView) findViewById(R.id.sale_sucre);
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


    public void Sucre(View view){

        Intent sucre = new Intent(Pouce_sucre_sale.this, Pouce_Sucre_healthy.class);
        startActivity(sucre);
    }

    public void Sale(View view){

        Intent sale = new Intent(Pouce_sucre_sale.this, Pouce_chaud_froid.class);
        startActivity(sale);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent sucre = new Intent(Pouce_sucre_sale.this, Pouce_Sucre_healthy.class);
                startActivity(sucre);

                message = "C'est parti pour du sucré !";
                break;
            case RIGHT_TO_LEFT:
                Intent sale = new Intent(Pouce_sucre_sale.this, Pouce_chaud_froid.class);
                startActivity(sale);
                message = "C'est parti pour du salé !";
                break;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
