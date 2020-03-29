package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class Boisson_glace extends AppCompatActivity {

    ScrollView scrollview;
    NavigationView view;
    DrawerLayout drawer;
    ImageButton menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boisson_glace);

        menu_button=(ImageButton)findViewById(R.id.menu_button);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
                    startActivity(new Intent(Boisson_glace.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Boisson_glace.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Boisson_glace.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(Boisson_glace.this, listeEntrees.class));}

                if (title.equals("plats")){ // Nos plats
                    startActivity(new Intent(Boisson_glace.this, listePlats.class));}

                if (title.equals("desserts")){ // Nos desserts
                    startActivity(new Intent(Boisson_glace.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){ // Coup de pouce
                    startActivity(new Intent(Boisson_glace.this, commandType.class));}

                if (title.equals("quitter")){ // Quitter
                    startActivity(new Intent(Boisson_glace.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(Boisson_glace.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });

}


    public void addBoisson(View view){
        Integer nbBoisson = DataHolder.getInstance().getNbBoissonGlace() +1;
        Hashtable<String,Integer> d = DataHolder.getInstance().getBoisson();
        d.put("Boisson glace",nbBoisson);
        DataHolder.getInstance().setNbBoissonGlace(nbBoisson);
        Toast.makeText(this, "Vous venez de commander un verre de VMuscat Petit Grain Saint Jean de Minervois supplémentaire", Toast.LENGTH_SHORT).show();

    }

    public void retour(View view){
        Intent entrees = new Intent(Boisson_glace.this, Dish_informations_glace.class);
        startActivity(entrees);
    }
}
