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

public class ChoixApero extends AppCompatActivity {
    private int nbVinRouge = DataHolder.getInstance().getNbVinRouge();
    private int nbVinBlanc = DataHolder.getInstance().getNbVinBlanc();
    private int nbBiere = DataHolder.getInstance().getNbBiere();
    private int nbEauPetillante = DataHolder.getInstance().getNbEauPetillante();
    private TextView vinBlanc;
    private TextView vinRouge;
    private TextView biere;
    private TextView eauPetillante;
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    private SearchView searchView;
    private LinearLayout layoutVinRouge;
    private LinearLayout layoutVinBlanc;
    private LinearLayout layoutBiere;
    private LinearLayout layoutEauPetillante;
    private TextView noResults;
    private LinearLayout[] layouts;
    private String[] nom_plats;
    private int nombre_plats = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_apero);
        vinBlanc = findViewById(R.id.vinBlanc);
        vinRouge = findViewById(R.id.vinRouge);
        eauPetillante = findViewById(R.id.eauPetillante);
        biere = findViewById(R.id.biere);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        searchView = findViewById(R.id.search_bar);
        layoutVinRouge = findViewById(R.id.layout_vinRouge);
        layoutEauPetillante = findViewById(R.id.layout_eauPetillante);
        layoutBiere = findViewById(R.id.layout_biere);
        layoutVinBlanc = findViewById(R.id.layout_vinBlanc);
        layouts = new LinearLayout[] {layoutEauPetillante, layoutVinRouge, layoutBiere, layoutVinBlanc};
        nom_plats = new String[] {getResources().getString(R.string.eauPetillante), getResources().getString(R.string.vinRouge), getResources().getString(R.string.biere), getResources().getString(R.string.vinBlanc)};
        noResults = findViewById(R.id.noResults);

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        view = (NavigationView) findViewById(R.id.nav_view);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu

            @Override

            public boolean onNavigationItemSelected(MenuItem menuItem) {

                CharSequence title = menuItem.getTitleCondensed();

                if (title.equals("aperitif")) { // Choix apéro
                    startActivity(new Intent(ChoixApero.this, ChoixApero.class));
                }

                if (title.equals("espace")) { // Changer d'espace
                    startActivity(new Intent(ChoixApero.this, Enfant_Adulte.class));
                }

                if (title.equals("commande")) { // Ma commande
                    startActivity(new Intent(ChoixApero.this, MyApero.class));
                }

                if (title.equals("entrees")) {
                    startActivity(new Intent(ChoixApero.this, listeEntrees.class));
                }

                if (title.equals("plats")) { // Nos plats
                    startActivity(new Intent(ChoixApero.this, listePlats.class));
                }

                if (title.equals("desserts")){ // Nos desserts
                    startActivity(new Intent(ChoixApero.this, listeDesserts.class));}

                if (title.equals("desserts")) { // Nos desserts
                    startActivity(new Intent(ChoixApero.this, CommandType.class));
                }

                if (title.equals("coupdepouce")) { // Coup de pouce
                    startActivity(new Intent(ChoixApero.this, CommandType.class));
                }

                if (title.equals("quitter")) { // Quitter
                    startActivity(new Intent(ChoixApero.this, MainActivity.class));
                }

                if (title.equals("menus")){
                    startActivity(new Intent(ChoixApero.this, Menus.class));}

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

    public void addVinBlanc(View view) {
        nbVinBlanc = nbVinBlanc +1;
        vinBlanc.setText(Integer.toString(nbVinBlanc));
        Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
        d.put("VinBlanc",nbVinBlanc);
        DataHolder.getInstance().setApero(d);
        DataHolder.getInstance().setNbVinBlanc(nbVinBlanc);

    }
    public void removeVinBlanc(View view){
        if(nbVinBlanc>0){
            nbVinBlanc = nbVinBlanc -1;
            vinBlanc.setText(Integer.toString(nbVinBlanc));
            Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
            d.put("VinBlanc",nbVinBlanc);
            DataHolder.getInstance().setApero(d);
            DataHolder.getInstance().setNbVinBlanc(nbVinBlanc);
        }
    }

    public void setNbVinBlanc(){
        TextView vinBlanc = (TextView) findViewById(R.id.vinBlanc);
        vinBlanc.setText(String.valueOf(nbVinBlanc));
    }

    public void addVinRouge(View view) {
        nbVinRouge = nbVinRouge +1;
        vinRouge.setText(Integer.toString(nbVinRouge));
        Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
        d.put("VinRouge",nbVinRouge);
        DataHolder.getInstance().setApero(d);
        DataHolder.getInstance().setNbVinRouge(nbVinRouge);

    }
    public void removeVinRouge(View view){
        if(nbVinRouge>0){
            nbVinRouge = nbVinRouge -1;
            vinRouge.setText(Integer.toString(nbVinRouge));
            Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
            d.put("VinRouge",nbVinRouge);
            DataHolder.getInstance().setApero(d);
            DataHolder.getInstance().setNbVinRouge(nbVinRouge);
        }
    }

    public void setNbVinRouge(){
        TextView vinRouge = (TextView) findViewById(R.id.vinRouge);
        vinRouge.setText(String.valueOf(nbVinRouge));
    }

    public void addBiere(View view) {
        nbBiere = nbBiere +1;
        biere.setText(Integer.toString(nbBiere));
        Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
        d.put("Biere",nbBiere);
        DataHolder.getInstance().setApero(d);
        DataHolder.getInstance().setNbBiere(nbBiere);

    }
    public void removeBiere(View view){
        if(nbBiere>0){
            nbBiere = nbBiere -1;
            biere.setText(Integer.toString(nbBiere));
            Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
            d.put("Biere",nbBiere);
            DataHolder.getInstance().setApero(d);
            DataHolder.getInstance().setNbBiere(nbBiere);

        }
    }

    public void setNbBiere(){
        TextView biere = (TextView) findViewById(R.id.biere);
        biere.setText(String.valueOf(nbBiere));
    }

    public void addEauPetillante(View view) {
        nbEauPetillante = nbEauPetillante +1;
        eauPetillante.setText(Integer.toString(nbEauPetillante));
        Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
        d.put("EauPetillante",nbEauPetillante);
        DataHolder.getInstance().setApero(d);
        DataHolder.getInstance().setNbEauPetillante(nbEauPetillante);


    }
    public void removeEauPetillante(View view){
        if(nbEauPetillante>0){
            nbEauPetillante = nbEauPetillante -1;
            eauPetillante.setText(Integer.toString(nbEauPetillante));
            Hashtable<String,Integer> d = DataHolder.getInstance().getApero();
            d.put("EauPetillante",nbEauPetillante);
            DataHolder.getInstance().setApero(d);
            DataHolder.getInstance().setNbEauPetillante(nbEauPetillante);

        }
    }

    public void setNbEauPetillante(){
        TextView eauPetillante = (TextView) findViewById(R.id.eauPetillante);
        eauPetillante.setText(String.valueOf(nbEauPetillante));
    }


    @Override
    public void onResume(){
        super.onResume();
        nbVinRouge = DataHolder.getInstance().getNbVinRouge();
        nbVinBlanc = DataHolder.getInstance().getNbVinBlanc();
        nbBiere = DataHolder.getInstance().getNbBiere();
        nbEauPetillante = DataHolder.getInstance().getNbEauPetillante();
        vinRouge.setText(Integer.toString(nbVinRouge));
        eauPetillante.setText(Integer.toString(nbEauPetillante));
        vinBlanc.setText(Integer.toString(nbVinBlanc));
        biere.setText(Integer.toString(nbBiere));
        setNbBiere();
        setNbVinBlanc();
        setNbEauPetillante();
        setNbVinRouge();

    }

    public void commander(View view){
        Intent myApero = new Intent(ChoixApero.this, MyApero.class);
        startActivity(myApero);
    }

    public void continuerCommande(View view){
        Intent commandType = new Intent(ChoixApero.this, CommandType.class);
        startActivity(commandType);
    }

    public void retour(View view){
        Intent entrees = new Intent(ChoixApero.this, Apero.class);
        startActivity(entrees);
    }
}