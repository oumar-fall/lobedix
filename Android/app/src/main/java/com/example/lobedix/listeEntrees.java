package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class listeEntrees extends AppCompatActivity {

    private int nbSoupe;
    private int nbTaboule;
    private int nbTomates;
    private int nbFeuillete;
    private TextView Taboule;
    private TextView Soupe;
    private TextView Tomates;
    private TextView Feuillete;
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;

    /*private  TextView Soupe = findViewById(R.id.Soupe);
    private TextView Feuillete = findViewById(R.id.Feuillete);
    private TextView Tomates = findViewById(R.id.Feuillete);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_entrees);
        Taboule = findViewById(R.id.Taboule);
        Soupe = findViewById(R.id.Soupe);
        Feuillete = findViewById(R.id.Feuillete);
        Tomates = findViewById(R.id.Tomates);
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
                    startActivity(new Intent(listeEntrees.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(listeEntrees.this, commandType.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(listeEntrees.this, commandType.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(listeEntrees.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(listeEntrees.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(listeEntrees.this, commandType.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(listeEntrees.this, commandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(listeEntrees.this, MainActivity.class));}

                drawer.closeDrawers();
                return true;


            }

        });

    }

    public void infosTaboule(View view) {

        Intent infosTaboule = new Intent(listeEntrees.this, Dish_informations_taboule.class);
        startActivity(infosTaboule);
    }

    public void infosSoupe(View view) {

        Intent infosSoupe = new Intent(listeEntrees.this, Dish_informations_soupe.class);
        startActivity(infosSoupe);
    }

    public void infosFeuillete(View view) {

        Intent infosFeuillete = new Intent(listeEntrees.this, Dish_informations_feuillete.class);
        startActivity(infosFeuillete);
    }

    public void infosTomates(View view) {

        Intent infosTomates = new Intent(listeEntrees.this, Dish_informations_tomates.class);
        startActivity(infosTomates);
    }

    public void addTaboule(View view) {
        nbTaboule = nbTaboule +1;
        Taboule.setText(Integer.toString(nbTaboule));

    }
    public void removeTaboule(View view){
        if(nbTaboule>0){
            nbTaboule = nbTaboule -1;
            Taboule.setText(Integer.toString(nbTaboule));
        }
    }

    public void addSoupe(View view) {
        nbSoupe = nbSoupe +1;
        Soupe.setText(Integer.toString(nbSoupe));

    }
    public void removeSoupe(View view){
        if(nbSoupe>0){
            nbSoupe = nbSoupe -1;
            Soupe.setText(Integer.toString(nbSoupe));
        }
    }

    public void addTomates(View view) {
        nbTomates = nbTomates +1;
        Tomates.setText(Integer.toString(nbTomates));

    }
    public void removeTomates(View view){
        if(nbTomates>0){
            nbTomates = nbTomates -1;
            Tomates.setText(Integer.toString(nbTomates));
        }
    }

    public void addFeuillete(View view) {
        nbFeuillete = nbFeuillete +1;
        Feuillete.setText(Integer.toString(nbFeuillete));

    }
    public void removeFeuillete(View view){
        if(nbFeuillete>0){
            nbFeuillete = nbFeuillete -1;
            Feuillete.setText(Integer.toString(nbFeuillete));
        }
    }


}
