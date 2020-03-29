package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Boisson_ratatouille extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boisson_ratatouille);
    }

    public void addBoisson(View view){

    }

    public void retour(View view){
        Intent entrees = new Intent(Boisson_ratatouille.this, Dish_informations_ratatouille.class);
        startActivity(entrees);
    }
}
