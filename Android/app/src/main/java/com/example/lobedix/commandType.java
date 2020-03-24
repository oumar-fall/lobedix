package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class commandType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_type);
    }

    public void carte(View view) {

        Intent carte = new Intent(commandType.this, Dish_Informations.class);
        startActivity(carte);
    }
}
