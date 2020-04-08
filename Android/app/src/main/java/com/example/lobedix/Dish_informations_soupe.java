package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class Dish_informations_soupe extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private TextView avis;
    private ScrollView scrollview;
    private NavigationView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish__informations_soupe);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button=(ImageButton)findViewById(R.id.menu_button);


        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        avis = (TextView)findViewById(R.id.opinions);
        scrollview = (ScrollView)findViewById(R.id.scroll);

        avis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.scrollTo(0, avis.getBottom());
            }
        });

        view=(NavigationView)findViewById(R.id.nav_view);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu

            @Override

            public boolean onNavigationItemSelected(MenuItem menuItem) {

                CharSequence title = menuItem.getTitleCondensed();

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(Dish_informations_soupe.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Dish_informations_soupe.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Dish_informations_soupe.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(Dish_informations_soupe.this, listeEntrees.class));}

                if (title.equals("plats")){
                    System.out.println("oueeeee");
                    startActivity(new Intent(Dish_informations_soupe.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(Dish_informations_soupe.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(Dish_informations_soupe.this, CommandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(Dish_informations_soupe.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(Dish_informations_soupe.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }

    public void nutriscore(View view){

        Intent nutri = new Intent(Dish_informations_soupe.this, Dish_Informations_Nutri_Soupe.class);
        startActivity(nutri);
    }

    public void ingredients(View view){
        Intent ingredient = new Intent(Dish_informations_soupe.this, Ingredients_soupe.class);
        startActivity(ingredient);
    }

    public void addSoupe(View view){
        Integer nbSoupe = DataHolder.getInstance().getNbSoupe() +1;
        Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
        d.put("Soupe",nbSoupe);
        DataHolder.getInstance().setNbSoupe(nbSoupe);
        Toast.makeText(this, "Vous venez de commander une soupe de légumes du soleil supplémentaire", Toast.LENGTH_SHORT).show();
    }

    public void retour(View view){
        Intent entrees = new Intent(Dish_informations_soupe.this, listeEntrees.class);
        startActivity(entrees);
    }

    public void boisson(View view){
        Intent boisson = new Intent(Dish_informations_soupe.this, Boisson_soupe.class);
        startActivity(boisson);
    }


}
