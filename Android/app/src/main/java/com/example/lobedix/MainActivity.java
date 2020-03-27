package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataHolder.getInstance().setInitialEntree();
        DataHolder.getInstance().setInitialPlat();
        DataHolder.getInstance().setListeEntree();
        DataHolder.getInstance().setListePlat();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return (true);
    }

    public void accueil(View view){

        Intent enfant_adulte = new Intent(MainActivity.this, Enfant_Adulte.class);
        startActivity(enfant_adulte);
    }
}
