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

public class CommandType extends AppCompatActivity {

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
                    startActivity(new Intent(CommandType.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(CommandType.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(CommandType.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(CommandType.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(CommandType.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(CommandType.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(CommandType.this, CommandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(CommandType.this, MainActivity.class));}
                if (title.equals("menus")){
                    startActivity(new Intent(CommandType.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });

    }

    public void carte_menu(View view) {

        Intent c = new Intent(CommandType.this, Carte.class);
        startActivity(c);
    }

    public void retour(View view){
        Intent entrees = new Intent(CommandType.this, Apero.class);
        startActivity(entrees);
    }

    public void menus(View view){
        Intent menus = new Intent(CommandType.this, Menus.class);
        startActivity(menus);

    }

    public void coup_de_pouce(View view){
        Intent pouce = new Intent(CommandType.this, Pouce_sucre_sale.class);
        startActivity(pouce);
    }
}
