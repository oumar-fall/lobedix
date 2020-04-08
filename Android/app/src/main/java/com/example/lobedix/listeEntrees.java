package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class listeEntrees extends AppCompatActivity {

    private int nbSoupe = DataHolder.getInstance().getNbSoupe();
    private int nbTaboule = DataHolder.getInstance().getNbTaboule();
    private int nbTomates = DataHolder.getInstance().getNbTomates();
    private int nbFeuillete = DataHolder.getInstance().getNbFeuillete();
    private TextView taboule;
    private TextView soupe;
    private TextView tomates;
    private TextView feuillete;
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    private SearchView searchView;
    private LinearLayout layoutTaboule;
    private LinearLayout layoutSoupe;
    private LinearLayout layoutTomates;
    private LinearLayout layoutFeuillete;
    private TextView noResults;
    private LinearLayout[] layouts;
    private String[] nom_plats;
    private int nombre_plats = 4;

    /*private  TextView Soupe = findViewById(R.id.Soupe);
    private TextView Feuillete = findViewById(R.id.Feuillete);
    private TextView Tomates = findViewById(R.id.Feuillete);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_entrees);
        taboule = findViewById(R.id.taboule);
        soupe = findViewById(R.id.soupe);
        feuillete = findViewById(R.id.feuillete);
        tomates = findViewById(R.id.tomates);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button=(ImageButton)findViewById(R.id.menu_button);
        searchView = findViewById(R.id.search_bar);
        layoutTaboule = findViewById(R.id.layout_taboule);
        layoutTomates = findViewById(R.id.layout_tomates);
        layoutFeuillete = findViewById(R.id.layout_feuillete);
        layoutSoupe = findViewById(R.id.layout_soupe);
        layouts = new LinearLayout[] {layoutTomates, layoutTaboule, layoutFeuillete, layoutSoupe};
        nom_plats = new String[] {getResources().getString(R.string.tomates), getResources().getString(R.string.taboule), getResources().getString(R.string.feuillete), getResources().getString(R.string.soupe)};
        noResults = findViewById(R.id.noResults);

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
                    startActivity(new Intent(listeEntrees.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(listeEntrees.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(listeEntrees.this, MyCommand.class));}

                if (title.equals("entrees")){
                    startActivity(new Intent(listeEntrees.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(listeEntrees.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(listeEntrees.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(listeEntrees.this, CommandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(listeEntrees.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(listeEntrees.this, Menus.class));}

                drawer.closeDrawers();
                return true;


            }

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println(newText);
                int compteur = 0;
                for (int i = 0; i < nombre_plats; i++){
                    LinearLayout.LayoutParams lparams = (LinearLayout.LayoutParams) layouts[i].getLayoutParams();

                    if (!nom_plats[i].toLowerCase().contains(newText.toLowerCase())){
                        lparams.height = 0;
                        compteur++;
                    }
                    else {
                        lparams.height = -2;
                    }
                }

                if (compteur==4){
                    noResults.setText(getResources().getString(R.string.noResults));
                }
                else {
                    noResults.setText("");
                }
                return true;
            }
        });

    }

    public void infosTaboule(View view) {

        Intent infosTaboule = new Intent(listeEntrees.this, Dish_informations_taboule.class);
        startActivity(infosTaboule);
    }

    public void infosSoupe(View view) {

        Intent infosSoupe = new Intent(listeEntrees.this, Dish_informations_soupe.class);
        startActivity(infosSoupe);
    }

    public void infosFeuillete(View view) {

        Intent infosFeuillete = new Intent(listeEntrees.this, Dish_informations_feuillete.class);
        startActivity(infosFeuillete);
    }

    public void infosTomates(View view) {

        Intent infosTomates = new Intent(listeEntrees.this, Dish_informations_tomates.class);
        startActivity(infosTomates);
    }

    public void addTaboule(View view) {
        nbTaboule = nbTaboule +1;
        taboule.setText(Integer.toString(nbTaboule));
        Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
        d.put("Taboule",nbTaboule);
        DataHolder.getInstance().setNbTaboule(nbTaboule);
        DataHolder.getInstance().setEntree(d);

    }
    public void removeTaboule(View view){
        if(nbTaboule>0){
            nbTaboule = nbTaboule -1;
            taboule.setText(Integer.toString(nbTaboule));
            Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
            DataHolder.getInstance().setNbTaboule(nbTaboule);
            d.put("Taboule",nbTaboule);
            DataHolder.getInstance().setEntree(d);
        }
    }

    public void setNbTaboule(){
        TextView taboule = (TextView) findViewById(R.id.taboule);
        taboule.setText(String.valueOf(nbTaboule));
    }

    public void addSoupe(View view) {
        nbSoupe = nbSoupe +1;
        soupe.setText(Integer.toString(nbSoupe));
        Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
        d.put("Soupe",nbSoupe);
        DataHolder.getInstance().setNbSoupe(nbSoupe);
        DataHolder.getInstance().setEntree(d);

    }
    public void removeSoupe(View view){
        if(nbSoupe>0){
            nbSoupe = nbSoupe -1;
            soupe.setText(Integer.toString(nbSoupe));
            Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
            d.put("Soupe",nbSoupe);
            DataHolder.getInstance().setNbSoupe(nbSoupe);
            DataHolder.getInstance().setEntree(d);
        }
    }

    public void setNbSoupe(){
        TextView soupe = (TextView) findViewById(R.id.soupe);
        soupe.setText(String.valueOf(nbSoupe));
    }

    public void addTomates(View view) {
        nbTomates = nbTomates +1;
        tomates.setText(Integer.toString(nbTomates));
        Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
        d.put("Tomate",nbTomates);
        DataHolder.getInstance().setNbTomates(nbTomates);
        DataHolder.getInstance().setEntree(d);

    }
    public void removeTomates(View view){
        if(nbTomates>0){
            nbTomates = nbTomates -1;
            tomates.setText(Integer.toString(nbTomates));
            Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
            d.put("Tomate",nbTomates);
            DataHolder.getInstance().setNbTomates(nbTomates);
            DataHolder.getInstance().setEntree(d);
        }
    }

    public void setNbTomates(){
        TextView tomates = (TextView) findViewById(R.id.tomates);
        tomates.setText(String.valueOf(nbTomates));
    }

    public void addFeuillete(View view) {
        nbFeuillete = nbFeuillete +1;
        feuillete.setText(Integer.toString(nbFeuillete));
        Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
        d.put("Fromage",nbFeuillete);
        DataHolder.getInstance().setNbFeuillete(nbFeuillete);
        DataHolder.getInstance().setEntree(d);

    }
    public void removeFeuillete(View view){
        if(nbFeuillete>0){
            nbFeuillete = nbFeuillete -1;
            feuillete.setText(Integer.toString(nbFeuillete));
            Hashtable<String,Integer> d = DataHolder.getInstance().getEntree();
            d.put("Fromage",nbFeuillete);
            DataHolder.getInstance().setNbFeuillete(nbFeuillete);
            DataHolder.getInstance().setEntree(d);

        }
    }

    public void setNbFeuillete(){
        TextView feuillete = (TextView) findViewById(R.id.feuillete);
        feuillete.setText(String.valueOf(nbFeuillete));
    }

    @Override
    public void onResume(){
        super.onResume();
        nbFeuillete = DataHolder.getInstance().getNbFeuillete();
        nbSoupe = DataHolder.getInstance().getNbSoupe();
        nbTaboule = DataHolder.getInstance().getNbTaboule();
        nbTomates = DataHolder.getInstance().getNbTomates();
        feuillete.setText(Integer.toString(nbFeuillete));
        tomates.setText(Integer.toString(nbTomates));
        soupe.setText(Integer.toString(nbSoupe));
        taboule.setText(Integer.toString(nbTaboule));
        setNbFeuillete();
        setNbSoupe();
        setNbTaboule();
        setNbTomates();

    }


    public void retour(View view){
        Intent entrees = new Intent(listeEntrees.this, Carte.class);
        startActivity(entrees);
    }

}
