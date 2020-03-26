package com.example.lobedix;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Dish_informations_ratatouille extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private TextView avis;
    private ScrollView scrollview;
    private NavigationView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish__informations_ratatouille);

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

                //Check to see which item was being clicked and perform appropriate action
                System.out.println(menuItem.getTitleCondensed());
                CharSequence title = menuItem.getTitleCondensed();

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(Dish_informations_ratatouille.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Dish_informations_ratatouille.this, commandType.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Dish_informations_ratatouille.this, commandType.class));}

                if (title.equals("plats")){
                    System.out.println("oueeeee");
                    startActivity(new Intent(Dish_informations_ratatouille.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(Dish_informations_ratatouille.this, commandType.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(Dish_informations_ratatouille.this, commandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(Dish_informations_ratatouille.this, MainActivity.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }

    public void nutriscore(View view){

        Intent nutri = new Intent(Dish_informations_ratatouille.this, Dish_Informations_Nutri.class);
        startActivity(nutri);
    }


}
