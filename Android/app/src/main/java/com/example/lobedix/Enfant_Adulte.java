package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Enfant_Adulte extends AppCompatActivity {

    private SwipeGestureDetector swipeDetector;
    private ImageView image = null;
    private TextView txt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfant__adulte);
        image = (ImageView) findViewById(R.id.enf_ad);
        txt = (TextView) findViewById(R.id.enf_ad_txt);
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

    public TextView getText(){
        return(txt);
    }

    public void adulte(View view){

        Intent enfant_adulte = new Intent(Enfant_Adulte.this, Apero.class);
        startActivity(enfant_adulte);
    }

    public void enfant(View view){
        Intent enfant = new Intent(Enfant_Adulte.this, Espace_Enfant2.class);
        startActivity(enfant);
    }

    public void onSwipe(SwipeGestureDetector.Swipe_Direction direction){
        Intent here = new Intent(Enfant_Adulte.this, Enfant_Adulte.class);
        startActivity(here);
        String message = "";
        switch(direction) {
            case LEFT_TO_RIGHT:
                Intent enfant = new Intent(Enfant_Adulte.this, Espace_Enfant2.class);
                startActivity(enfant);
                message = "Menu enfant !";
                break;
            case RIGHT_TO_LEFT:
                Intent adulte = new Intent(Enfant_Adulte.this, Apero.class);
                startActivity(adulte);
                message = "Menu adulte !";
                break;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
