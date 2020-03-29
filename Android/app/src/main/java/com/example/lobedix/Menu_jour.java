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
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class Menu_jour extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private ScrollView scrollview;
    private NavigationView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jour);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);


        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        scrollview = (ScrollView) findViewById(R.id.scroll);

        view = (NavigationView) findViewById(R.id.nav_view);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu

            @Override

            public boolean onNavigationItemSelected(MenuItem menuItem) {
                CharSequence title = menuItem.getTitleCondensed();

                if (title.equals("aperitif")) { // Choix apéro
                    startActivity(new Intent(Menu_jour.this, ChoixApero.class));
                }

                if (title.equals("espace")) { // Changer d'espace
                    startActivity(new Intent(Menu_jour.this, Enfant_Adulte.class));
                }

                if (title.equals("commande")) { // Ma commande
                    startActivity(new Intent(Menu_jour.this, MyCommand.class));
                }

                if (title.equals("entrees")) {
                    startActivity(new Intent(Menu_jour.this, listeEntrees.class));
                }

                if (title.equals("plats")) {
                    System.out.println("oueeeee");
                    startActivity(new Intent(Menu_jour.this, listePlats.class));
                }

                if (title.equals("desserts")) {
                    startActivity(new Intent(Menu_jour.this, listeDesserts.class));
                }

                if (title.equals("coupdepouce")) {
                    startActivity(new Intent(Menu_jour.this, commandType.class));
                }

                if (title.equals("quitter")) {
                    startActivity(new Intent(Menu_jour.this, MainActivity.class));
                }

                if (title.equals("menus")){
                    startActivity(new Intent(Menu_jour.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }


    public void addJour(View view){
        Integer nbJour = DataHolder.getInstance().getNbJour() +1;
        Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
        d.put("Jour",nbJour);
        DataHolder.getInstance().setNbJour(nbJour);
        Toast.makeText(this, "Vous venez de commander un menu du jour supplémentaire", Toast.LENGTH_SHORT).show();
    }

    public void retour(View view){
        Intent menus = new Intent(Menu_jour.this, Menus.class);
        startActivity(menus);
    }

}