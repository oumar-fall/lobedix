package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class listePlats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_plats);
    }

    public void infosLasagnes(View view) {

        Intent infosLasagnes = new Intent(listePlats.this, Dish_Informations.class);
        startActivity(infosLasagnes);
    }
}
