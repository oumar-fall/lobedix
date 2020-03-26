package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Dish_Informations extends AppCompatActivity {

    ImageButton menu_button;
    DrawerLayout drawer;
    TextView avis;
    ScrollView scrollview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish__informations);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button=(ImageButton)findViewById(R.id.menu_button);


        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        avis = (TextView)findViewById(R.id.opinions);
        scrollview = (ScrollView)findViewById(R.id.scroll);

        avis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.scrollTo(0, avis.getBottom());
            }
        });
    }

    public void nutriscore(View view){

        Intent nutri = new Intent(Dish_Informations.this, Dish_Informations_Nutri.class);
        startActivity(nutri);
    }


}
