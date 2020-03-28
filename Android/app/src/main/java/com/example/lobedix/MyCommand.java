package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MyCommand extends AppCompatActivity {
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_command);
        /* commande = findViewById(R.id.commande);
        String c = DataHolder.getInstance().textCommande();
        commande.setText(c);*/

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
                    startActivity(new Intent(MyCommand.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(MyCommand.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(MyCommand.this, MyCommand.class));}


                if (title.equals("entrees")){
                    startActivity(new Intent(MyCommand.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(MyCommand.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(MyCommand.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(MyCommand.this, commandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(MyCommand.this, MainActivity.class));}

                drawer.closeDrawers();
                return true;


            }

        });

    }
    @Override
    public void onResume(){
        super.onResume();
        TextView commande = findViewById(R.id.commande);
        String c = DataHolder.getInstance().textCommande();
        commande.setText(c);

    }
}