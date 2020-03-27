package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class Dish_Informations_Nutri extends AppCompatActivity {


    DrawerLayout drawer;
    NavigationView view;
    ImageButton menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish__informations__nutri);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button=(ImageButton)findViewById(R.id.menu_button);

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        view=(NavigationView)findViewById(R.id.nav_view);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu

            @Override

            public boolean onNavigationItemSelected(MenuItem menuItem) {

                CharSequence title = menuItem.getTitleCondensed();

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(Dish_Informations_Nutri.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Dish_Informations_Nutri.this,Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Dish_Informations_Nutri.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(Dish_Informations_Nutri.this, listeEntrees.class));}

                if (title.equals("plats")){ // Nos plats
                    startActivity(new Intent(Dish_Informations_Nutri.this, listePlats.class));}

                if (title.equals("desserts")){ // Nos desserts
                    startActivity(new Intent(Dish_Informations_Nutri.this, commandType.class));}

                if (title.equals("coupdepouce")){ // Coup de pouce
                    startActivity(new Intent(Dish_Informations_Nutri.this, commandType.class));}

                if (title.equals("quitter")){ // Quitter
                    startActivity(new Intent(Dish_Informations_Nutri.this, MainActivity.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }
}
