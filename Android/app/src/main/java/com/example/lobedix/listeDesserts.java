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

public class listeDesserts extends AppCompatActivity {

    private int nbSalade = DataHolder.getInstance().getNbSalade();
    private int nbMousse = DataHolder.getInstance().getNbMousse();
    private int nbCreme = DataHolder.getInstance().getNbCreme();
    private int nbGlace = DataHolder.getInstance().getNbGlace();
    private TextView mousse;
    private TextView salade;
    private TextView creme;
    private TextView glace;
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    private SearchView searchView;
    private LinearLayout layoutCreme;
    private LinearLayout layoutSalade;
    private LinearLayout layoutMousse;
    private LinearLayout layoutGlace;
    private TextView noResults;
    private LinearLayout[] layouts;
    private String[] nom_plats;
    private int nombre_plats = 4;


    /*private  TextView Salade = findViewById(R.id.Salade);
    private TextView Glace = findViewById(R.id.Glace);
    private TextView Creme = findViewById(R.id.Glace);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_desserts);
        mousse = findViewById(R.id.mousse);
        salade = findViewById(R.id.salade);
        glace = findViewById(R.id.glace);
        creme = findViewById(R.id.creme);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        searchView = findViewById(R.id.search_bar);
        layoutCreme = findViewById(R.id.layout_creme);
        layoutGlace = findViewById(R.id.layout_glace);
        layoutMousse = findViewById(R.id.layout_mousse);
        layoutSalade = findViewById(R.id.layout_salade);
        layouts = new LinearLayout[] {layoutGlace, layoutCreme, layoutMousse, layoutSalade};
        nom_plats = new String[] {getResources().getString(R.string.glace), getResources().getString(R.string.creme), getResources().getString(R.string.mousse), getResources().getString(R.string.salade)};
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
                    startActivity(new Intent(listeDesserts.this, ChoixApero.class));
                }

                if (title.equals("espace")) { // Changer d'espace
                    startActivity(new Intent(listeDesserts.this, Enfant_Adulte.class));
                }

                if (title.equals("commande")) { // Ma commande
                    startActivity(new Intent(listeDesserts.this, MyCommand.class));
                }

                if (title.equals("entrees")) {
                    startActivity(new Intent(listeDesserts.this, listeEntrees.class));
                }

                if (title.equals("plats")) {
                    startActivity(new Intent(listeDesserts.this, listePlats.class));
                }

                if (title.equals("desserts")) {
                    startActivity(new Intent(listeDesserts.this, listeDesserts.class));
                }

                if (title.equals("coupdepouce")) {
                    startActivity(new Intent(listeDesserts.this, CommandType.class));
                }

                if (title.equals("quitter")) {
                    startActivity(new Intent(listeDesserts.this, MainActivity.class));
                }

                if (title.equals("menus")) {
                    startActivity(new Intent(listeDesserts.this, Menus.class));
                }

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

    public void infosMousse(View view) {

        Intent infosMousse = new Intent(listeDesserts.this, Dish_informations_mousse.class);
        startActivity(infosMousse);
    }

    public void infosSalade(View view) {

        Intent infosSalade = new Intent(listeDesserts.this, Dish_informations_salade.class);
        startActivity(infosSalade);
    }

    public void infosGlace(View view) {

        Intent infosGlace = new Intent(listeDesserts.this, Dish_informations_glace.class);
        startActivity(infosGlace);
    }

    public void infosCreme(View view) {

        Intent infosCreme = new Intent(listeDesserts.this, Dish_informations_creme.class);
        startActivity(infosCreme);
    }

    public void addMousse(View view) {
        nbMousse = nbMousse +1;
        mousse.setText(Integer.toString(nbMousse));
        Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
        d.put("Mousse",nbMousse);
        DataHolder.getInstance().setNbMousse(nbMousse);
        DataHolder.getInstance().setDessert(d);

    }

    public void removeMousse(View view){
        if(nbMousse>0){
            nbMousse = nbMousse -1;
            mousse.setText(Integer.toString(nbMousse));
            Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
            DataHolder.getInstance().setNbMousse(nbMousse);
            d.put("Mousse",nbMousse);
            DataHolder.getInstance().setDessert(d);
        }
    }

    public void setNbMousse(){
        TextView mousse = (TextView) findViewById(R.id.mousse);
        mousse.setText(String.valueOf(nbMousse));
    }

    public void addSalade(View view) {
        nbSalade = nbSalade +1;
        salade.setText(Integer.toString(nbSalade));
        Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
        d.put("Salade",nbSalade);
        DataHolder.getInstance().setNbSalade(nbSalade);
        DataHolder.getInstance().setDessert(d);

    }
    public void removeSalade(View view){
        if(nbSalade>0){
            nbSalade = nbSalade -1;
            salade.setText(Integer.toString(nbSalade));
            Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
            d.put("Salade",nbSalade);
            DataHolder.getInstance().setNbSalade(nbSalade);
            DataHolder.getInstance().setDessert(d);
        }
    }

    public void setNbSalade(){
        TextView salade = (TextView) findViewById(R.id.salade);
        salade.setText(String.valueOf(nbSalade));
    }

    public void addCreme(View view) {
        nbCreme = nbCreme +1;
        creme.setText(Integer.toString(nbCreme));
        Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
        d.put("Creme",nbCreme);
        DataHolder.getInstance().setNbCreme(nbCreme);
        DataHolder.getInstance().setDessert(d);
    }

    public void removeCreme(View view){
        if(nbCreme>0){
            nbCreme = nbCreme -1;
            creme.setText(Integer.toString(nbCreme));
            Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
            d.put("Creme",nbCreme);
            DataHolder.getInstance().setNbCreme(nbCreme);
            DataHolder.getInstance().setDessert(d);
        }
    }

    public void setNbCreme(){
        TextView creme = (TextView) findViewById(R.id.creme);
        creme.setText(String.valueOf(nbCreme));
    }

    public void addGlace(View view) {
        nbGlace = nbGlace +1;
        glace.setText(Integer.toString(nbGlace));
        Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
        d.put("Glace",nbGlace);
        DataHolder.getInstance().setNbGlace(nbGlace);
        DataHolder.getInstance().setDessert(d);

    }
    public void removeGlace(View view){
        if(nbGlace>0){
            nbGlace = nbGlace -1;
            glace.setText(Integer.toString(nbGlace));
            Hashtable<String,Integer> d = DataHolder.getInstance().getDessert();
            d.put("Glace",nbGlace);
            DataHolder.getInstance().setNbGlace(nbGlace);
            DataHolder.getInstance().setDessert(d);

        }
    }

    public void setNbGlace(){
        TextView glace = (TextView) findViewById(R.id.glace);
        glace.setText(String.valueOf(nbGlace));
    }

    @Override
    public void onResume(){
        super.onResume();
        nbCreme = DataHolder.getInstance().getNbCreme();
        nbMousse = DataHolder.getInstance().getNbMousse();
        nbSalade = DataHolder.getInstance().getNbSalade();
        nbGlace = DataHolder.getInstance().getNbGlace();
        creme.setText(Integer.toString(nbCreme));
        mousse.setText(Integer.toString(nbMousse));
        salade.setText(Integer.toString(nbSalade));
        glace.setText(Integer.toString(nbGlace));
        setNbCreme();
        setNbMousse();
        setNbSalade();
        setNbGlace();

    }

    public void retour(View view){
        Intent entrees = new Intent(listeDesserts.this, Carte.class);
        startActivity(entrees);
    }






}
