package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Enfant_Adulte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfant__adulte);
    }

    public void adulte(View view){

        Intent enfant_adulte = new Intent(Enfant_Adulte.this, Apero.class);
        startActivity(enfant_adulte);
    }
}
