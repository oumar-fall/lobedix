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

public class commandType extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private NavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_type);

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

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(commandType.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(commandType.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(commandType.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(commandType.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(commandType.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(commandType.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(commandType.this, commandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(commandType.this, MainActivity.class));}

                drawer.closeDrawers();
                return true;


            }

        });

    }

    public void carte_menu(View view) {

        Intent c = new Intent(commandType.this, Carte.class);
        startActivity(c);
    }

    public void retour(View view){
        Intent entrees = new Intent(commandType.this, Apero.class);
        startActivity(entrees);
    }
}
