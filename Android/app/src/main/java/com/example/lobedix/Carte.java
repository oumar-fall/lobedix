package com.example.lobedix;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Carte extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private NavigationView view;
    private boolean commandShown = false;


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
                    startActivity(new Intent(Carte.this, CommandType.class));
                }

                if (title.equals("commande")) { // Ma commande
                    startActivity(new Intent(Carte.this, MyCommand.class));
                }

                if (title.equals("entrees")){
                    startActivity(new Intent(Carte.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(Carte.this, listePlats.class));}

                if (title.equals("desserts")) {
                    startActivity(new Intent(Carte.this, CommandType.class));
                }

                if (title.equals("coupdepouce")) {
                    startActivity(new Intent(Carte.this, CommandType.class));
                }

                if (title.equals("quitter")) {
                    startActivity(new Intent(Carte.this, MainActivity.class));
                }

                if (title.equals("menus")){
                    startActivity(new Intent(Carte.this, Menus.class));}

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

    public void desserts(View view) {

        Intent desserts = new Intent(Carte.this, listeDesserts.class);
        startActivity(desserts);
    }

    public void showCommand(View view){
        LinearLayout commandLook = findViewById(R.id.commandLook);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) commandLook.getLayoutParams();
        TextView txtShowCommand = findViewById(R.id.txtShowCommand);
        TextView txtCommand = findViewById(R.id.txtCommand);
        ImageButton showCommand = findViewById(R.id.showCommand);
        String c = DataHolder.getInstance().textCommande(false);
        txtCommand.setText(c);
        if (commandShown){
            params.setMargins(params.leftMargin, params.topMargin, -1*params.width, params.bottomMargin);
            txtShowCommand.setText(R.string.voirCommande);
            txtShowCommand.setTextColor(Color.BLACK);
            showCommand.setBackgroundResource(R.drawable.panier_black);
        }
        else {
            params.setMargins(params.leftMargin, params.topMargin, params.topMargin, params.bottomMargin);
            txtShowCommand.setText(R.string.masquerCommande);
            txtShowCommand.setTextColor(Color.WHITE);
            showCommand.setBackgroundResource(R.drawable.panier_white);

        }
        commandShown = !commandShown;
        commandLook.setLayoutParams(params);
    }

    public void gererCommande(View view){
        Intent command = new Intent(Carte.this, MyCommand.class);
        startActivity(command);
    }

    public void retour(View view){
        Intent entrees = new Intent(Carte.this, CommandType.class);
        startActivity(entrees);
    }
}

