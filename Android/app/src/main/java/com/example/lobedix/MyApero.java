package com.example.lobedix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MyApero extends AppCompatActivity {
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apero);


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
                    startActivity(new Intent(MyApero.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(MyApero.this, Enfant_Adulte.class));}

                if (title.equals("aperoe")){ // Ma aperoe
                    startActivity(new Intent(MyApero.this, MyApero.class));}


                if (title.equals("entrees")){
                    startActivity(new Intent(MyApero.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(MyApero.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(MyApero.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(MyApero.this, CommandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(MyApero.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(MyApero.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });

    }
    @Override
    public void onResume(){
        super.onResume();
        TextView commande = findViewById(R.id.commande);
        String c = DataHolder.getInstance().textCommande(true);
        commande.setText(c);

    }

    public void confirm(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Validation de l'aperitif");
        builder.setMessage("Etes-vous sûr.e de vouloir confirmer votre aperitif ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Oui",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MyApero.this, "Votre aperitif est en cours de préparation.", Toast.LENGTH_SHORT).show();
                        DataHolder.getInstance().cleanListeApero();
                        startActivity(new Intent(MyApero.this, CommandType.class));
                    }
                });

        builder.setNegativeButton("Non",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void retour(View view){
        Intent menus = new Intent(MyApero.this, ChoixApero.class);
        startActivity(menus);
    }
}
