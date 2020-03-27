package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import com.google.android.material.navigation.NavigationView;

public class Carte extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private NavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);

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

                //Check to see which item was being clicked and perform appropriate action
                System.out.println(menuItem.getTitleCondensed());
                CharSequence title = menuItem.getTitleCondensed();

                if (title.equals("aperitif")) { // Choix apéro
                    startActivity(new Intent(Carte.this, ChoixApero.class));
                }

                if (title.equals("espace")) { // Changer d'espace
                    startActivity(new Intent(Carte.this, commandType.class));
                }

                if (title.equals("commande")) { // Ma commande
                    startActivity(new Intent(Carte.this, MyCommand.class));
                }

                if (title.equals("entrees")){
                    startActivity(new Intent(Carte.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(Carte.this, listePlats.class));}

                if (title.equals("desserts")) {
                    startActivity(new Intent(Carte.this, commandType.class));
                }

                if (title.equals("coupdepouce")) {
                    startActivity(new Intent(Carte.this, commandType.class));
                }

                if (title.equals("quitter")) {
                    startActivity(new Intent(Carte.this, MainActivity.class));
                }

                drawer.closeDrawers();
                return true;

            }
        });

    }

    public void entrees(View view) {

        Intent entrees = new Intent(Carte.this, listeEntrees.class);
        startActivity(entrees);
    }

    public void plats(View view) {

        Intent plats = new Intent(Carte.this, listePlats.class);
        startActivity(plats);
    }
}

