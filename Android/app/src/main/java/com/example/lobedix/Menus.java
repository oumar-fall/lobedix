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

import java.util.Hashtable;

public class Menus extends AppCompatActivity {

    private int nbJour = DataHolder.getInstance().getNbJour();
    private int nbVege = DataHolder.getInstance().getNbVege();
    private int nbSimple = DataHolder.getInstance().getNbSimple();
    private int nbFeuillete = DataHolder.getInstance().getNbFeuillete();
    private TextView vege;
    private TextView jour;
    private TextView simple;
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;

    /*private  TextView Jour = findViewById(R.id.Jour);
    private TextView Feuillete = findViewById(R.id.Feuillete);
    private TextView Simple = findViewById(R.id.Feuillete);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        vege = findViewById(R.id.vege);
        jour = findViewById(R.id.jour);
        simple = findViewById(R.id.simple);
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

                CharSequence title = menuItem.getTitleCondensed();

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(Menus.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(Menus.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(Menus.this, MyCommand.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(Menus.this, Menus.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(Menus.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(Menus.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(Menus.this, CommandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(Menus.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(Menus.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });

    }

    public void infosVege(View view) {

        Intent infosVege = new Intent(Menus.this, Menu_vege.class);
        startActivity(infosVege);
    }

    public void infosJour(View view) {

        Intent infosJour = new Intent(Menus.this, Menu_jour.class);
        startActivity(infosJour);
    }

    public void infosSimple(View view) {

        Intent infosSimple = new Intent(Menus.this, Menu_simple.class);
        startActivity(infosSimple);
    }

    public void addVege(View view) {
        nbVege = nbVege +1;
        vege.setText(Integer.toString(nbVege));
        Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
        d.put("Vege",nbVege);
        DataHolder.getInstance().setNbVege(nbVege);
        DataHolder.getInstance().setMenu(d);

    }
    public void removeVege(View view){
        if(nbVege>0){
            nbVege = nbVege -1;
            vege.setText(Integer.toString(nbVege));
            Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
            DataHolder.getInstance().setNbVege(nbVege);
            d.put("Vege",nbVege);
            DataHolder.getInstance().setMenu(d);
        }
    }

    public void setNbVege(){
        TextView Vege = (TextView) findViewById(R.id.vege);
        Vege.setText(String.valueOf(nbVege));
    }

    public void addJour(View view) {
        nbJour = nbJour +1;
        jour.setText(Integer.toString(nbJour));
        Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
        d.put("Jour",nbJour);
        DataHolder.getInstance().setNbJour(nbJour);
        DataHolder.getInstance().setMenu(d);

    }
    public void removeJour(View view){
        if(nbJour>0){
            nbJour = nbJour -1;
            jour.setText(Integer.toString(nbJour));
            Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
            d.put("Jour",nbJour);
            DataHolder.getInstance().setNbJour(nbJour);
            DataHolder.getInstance().setMenu(d);
        }
    }

    public void setNbJour(){
        TextView Jour = (TextView) findViewById(R.id.jour);
        Jour.setText(String.valueOf(nbJour));
    }

    public void addSimple(View view) {
        nbSimple = nbSimple +1;
        simple.setText(Integer.toString(nbSimple));
        Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
        d.put("Simple",nbSimple);
        DataHolder.getInstance().setNbSimple(nbSimple);
        DataHolder.getInstance().setMenu(d);

    }
    public void removeSimple(View view){
        if(nbSimple>0){
            nbSimple = nbSimple -1;
            simple.setText(Integer.toString(nbSimple));
            Hashtable<String,Integer> d = DataHolder.getInstance().getMenu();
            d.put("Simple",nbSimple);
            DataHolder.getInstance().setNbSimple(nbSimple);
            DataHolder.getInstance().setMenu(d);
        }
    }

    public void setNbSimple(){
        TextView Simple = (TextView) findViewById(R.id.simple);
        Simple.setText(String.valueOf(nbSimple));
    }

    @Override
    public void onResume(){
        super.onResume();
        nbFeuillete = DataHolder.getInstance().getNbFeuillete();
        nbJour = DataHolder.getInstance().getNbJour();
        nbVege = DataHolder.getInstance().getNbVege();
        nbSimple = DataHolder.getInstance().getNbSimple();
        simple.setText(Integer.toString(nbSimple));
        jour.setText(Integer.toString(nbJour));
        vege.setText(Integer.toString(nbVege));
        setNbJour();
        setNbVege();
        setNbSimple();

    }


    public void retour(View view){
        Intent menus = new Intent(Menus.this, CommandType.class);
        startActivity(menus);
    }

}
