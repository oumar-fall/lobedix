package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataHolder.getInstance().setInitialEntree();
        DataHolder.getInstance().setInitialPlat();
        DataHolder.getInstance().setInitialDessert();
        DataHolder.getInstance().setInitialMenus();
        DataHolder.getInstance().setInitialBoissons();
        DataHolder.getInstance().setInitialApero();

        DataHolder.getInstance().setListeEntree();
        DataHolder.getInstance().setListePlat();
        DataHolder.getInstance().setListeDessert();
        DataHolder.getInstance().setListeMenus();
        DataHolder.getInstance().setListeBoisson();
        DataHolder.getInstance().setListeApero();


        DataHolder.getInstance().setBelleListeEntree();
        DataHolder.getInstance().setBelleListePlat();
        DataHolder.getInstance().setBelleListeDessert();
        DataHolder.getInstance().setBelleListeMenus();
        DataHolder.getInstance().setBelleListeBoissons();
        DataHolder.getInstance().setBelleListeApero();



        DataHolder.getInstance().initNb();
        DataHolder.getInstance().setPrix();
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
