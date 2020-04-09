package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class Boisson_curry extends AppCompatActivity {
    ScrollView scrollview;
    NavigationView view;
    DrawerLayout drawer;
    ImageButton menu_button;
    private boolean commandShown = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boisson_curry);

        menu_button=(ImageButton)findViewById(R.id.menu_button);

        drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
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
                    startActivity(new Intent(Boisson_curry.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Boisson_curry.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Boisson_curry.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(Boisson_curry.this, listeEntrees.class));}

                if (title.equals("plats")){ // Nos plats
                    startActivity(new Intent(Boisson_curry.this, listePlats.class));}

                if (title.equals("desserts")){ // Nos desserts
                    startActivity(new Intent(Boisson_curry.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){ // Coup de pouce
                    startActivity(new Intent(Boisson_curry.this, CommandType.class));}

                if (title.equals("quitter")){ // Quitter
                    startActivity(new Intent(Boisson_curry.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(Boisson_curry.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }


    public void addBoisson(View view){
        Integer nbBoisson = DataHolder.getInstance().getNbBoissonCurry() +1;
        Hashtable<String,Integer> d = DataHolder.getInstance().getBoisson();
        d.put("Boisson curry",nbBoisson);
        DataHolder.getInstance().setNbBoissonCurry(nbBoisson);
        Toast.makeText(this, "Vous venez de commander un verre de Crozes-Hermitage supplémentaire", Toast.LENGTH_SHORT).show();

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
        Intent command = new Intent(Boisson_curry.this, MyCommand.class);
        startActivity(command);
    }

    public void retour(View view){
        Intent entrees = new Intent(Boisson_curry.this, Dish_informations_curry.class);
        startActivity(entrees);
    }
}
