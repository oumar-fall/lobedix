package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Apero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apero);
    }

    public void apero(View view){

        Intent dish_information = new Intent(Apero.this, Dish_Informations.class);
        startActivity(dish_information);
    }
}
