package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Dish_Informations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish__informations);
    }

    public void nutriscore(View view){

        Intent nutri = new Intent(Dish_Informations.this, Dish_Informations_Nutri.class);
        startActivity(nutri);
    }
}