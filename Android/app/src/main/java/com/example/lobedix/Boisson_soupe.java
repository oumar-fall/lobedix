package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.material.navigation.NavigationView;

public class Boisson_soupe extends AppCompatActivity {

    ScrollView scrollview;
    NavigationView view;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boisson_soupe);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        view=(NavigationView)findViewById(R.id.nav_view);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu

            @Override

            public boolean onNavigationItemSelected(MenuItem menuItem) {

                CharSequence title = menuItem.getTitleCondensed();

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(Boisson_soupe.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Boisson_soupe.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Boisson_soupe.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(Boisson_soupe.this, listeEntrees.class));}

                if (title.equals("plats")){ // Nos plats
                    startActivity(new Intent(Boisson_soupe.this, listePlats.class));}

                if (title.equals("desserts")){ // Nos desserts
                    startActivity(new Intent(Boisson_soupe.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){ // Coup de pouce
                    startActivity(new Intent(Boisson_soupe.this, commandType.class));}

                if (title.equals("quitter")){ // Quitter
                    startActivity(new Intent(Boisson_soupe.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(Boisson_soupe.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }


    public void addBoisson(View view){

    }

    public void retour(View view){
        Intent entrees = new Intent(Boisson_soupe.this, Dish_informations_soupe.class);
        startActivity(entrees);
    }
}
