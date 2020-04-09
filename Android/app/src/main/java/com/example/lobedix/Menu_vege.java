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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class Menu_vege extends AppCompatActivity {

    private ImageButton menu_button;
    private DrawerLayout drawer;
    private TextView avis;
    private ScrollView scrollview;
    private NavigationView view;
    private boolean commandShown = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_vege);

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
                    startActivity(new Intent(Menu_vege.this, ChoixApero.class));
                }

                if (title.equals("espace")) { // Changer d'espace
                    startActivity(new Intent(Menu_vege.this, Enfant_Adulte.class));
                }

                if (title.equals("commande")) { // Ma commande
                    startActivity(new Intent(Menu_vege.this, MyCommand.class));
                }

                if (title.equals("entrees")) {
                    startActivity(new Intent(Menu_vege.this, listeEntrees.class));
                }

                if (title.equals("plats")) {
                    System.out.println("oueeeee");
                    startActivity(new Intent(Menu_vege.this, listePlats.class));
                }

                if (title.equals("desserts")) {
                    startActivity(new Intent(Menu_vege.this, listeDesserts.class));
                }

                if (title.equals("coupdepouce")) {
                    startActivity(new Intent(Menu_vege.this, CommandType.class));
                }

                if (title.equals("quitter")) {
                    startActivity(new Intent(Menu_vege.this, MainActivity.class));
                }

                if (title.equals("menus")){
                    startActivity(new Intent(Menu_vege.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });
    }


    public void addVege(View view){
        Integer nbVege = DataHolder.getInstance().getNbVege() +1;
        Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
        d.put("Vege",nbVege);
        DataHolder.getInstance().setNbVege(nbVege);
        Toast.makeText(this, "Vous venez de commander un menu végétarien supplémentaire", Toast.LENGTH_SHORT).show();
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
        Intent command = new Intent(Menu_vege.this, MyCommand.class);
        startActivity(command);
    }

    public void retour(View view){
        Intent menus = new Intent(Menu_vege.this, Menus.class);
        startActivity(menus);
    }

}
