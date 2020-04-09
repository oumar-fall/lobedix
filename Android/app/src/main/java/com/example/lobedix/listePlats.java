package com.example.lobedix;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Hashtable;

public class listePlats extends AppCompatActivity {

    private int nbSpaghetti = DataHolder.getInstance().getNbSpaghetti();
    private int nbLasagnes = DataHolder.getInstance().getNbLasagnes();
    private int nbCurry = DataHolder.getInstance().getNbCurry();
    private int nbRatatouille = DataHolder.getInstance().getNbRatatouille();
    private TextView lasagnes;
    private TextView spaghetti;
    private TextView curry;
    private TextView ratatouille;
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    private SearchView searchView;
    private LinearLayout layoutLasagnes;
    private LinearLayout layoutCurry;
    private LinearLayout layoutSpaghetti;
    private LinearLayout layoutRatatouille;
    private TextView noResults;
    private LinearLayout[] layouts;
    private String[] nom_plats;
    private int nombre_plats = 4;

    private boolean commandShown = false;

    /*private  TextView spaghetti = findViewById(R.id.spaghetti);
    private TextView ratatouille = findViewById(R.id.ratatouille);
    private TextView curry = findViewById(R.id.ratatouille);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_plats);
        lasagnes = findViewById(R.id.lasagnes);
        spaghetti = findViewById(R.id.spaghetti);
        ratatouille = findViewById(R.id.ratatouille);
        curry = findViewById(R.id.curry);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button=(ImageButton)findViewById(R.id.menu_button);
        searchView = findViewById(R.id.search_bar);
        layoutLasagnes = findViewById(R.id.layout_lasagnes);
        layoutSpaghetti = findViewById(R.id.layout_spaghetti);
        layoutRatatouille = findViewById(R.id.layout_ratatouille);
        layoutCurry = findViewById(R.id.layout_curry);
        layouts = new LinearLayout[] {layoutSpaghetti, layoutLasagnes, layoutRatatouille, layoutCurry};
        nom_plats = new String[] {getResources().getString(R.string.spaghetti), getResources().getString(R.string.lasagnes), getResources().getString(R.string.ratatouille), getResources().getString(R.string.pouletCurry)};
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

                //Check to see which item was being clicked and perform appropriate action
                System.out.println(menuItem.getTitleCondensed());
                CharSequence title = menuItem.getTitleCondensed();

                if(title.equals("aperitif")){ // Choix apéro
                    startActivity(new Intent(listePlats.this, ChoixApero.class));}

                if (title.equals("espace")){ // Changer d'espace
                    startActivity(new Intent(listePlats.this, Enfant_Adulte.class));}

                if (title.equals("commande")){ // Ma commande
                    startActivity(new Intent(listePlats.this, MyCommand.class));}


                if (title.equals("entrees")){
                    startActivity(new Intent(listePlats.this, listeEntrees.class));}

                if (title.equals("plats")){
                    startActivity(new Intent(listePlats.this, listePlats.class));}

                if (title.equals("desserts")){
                    startActivity(new Intent(listePlats.this, listeDesserts.class));}

                if (title.equals("coupdepouce")){
                    startActivity(new Intent(listePlats.this, CommandType.class));}

                if (title.equals("quitter")){
                    startActivity(new Intent(listePlats.this, MainActivity.class));}

                if (title.equals("menus")){
                    startActivity(new Intent(listePlats.this, Menus.class));}

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

    public void infosLasagnes(View view) {

        Intent infosLasagnes = new Intent(listePlats.this, Dish_informations_lasagnes.class);
        startActivity(infosLasagnes);
    }

    public void infosSpaghetti(View view) {

        Intent infosSpaghetti = new Intent(listePlats.this, Dish_informations_spaghetti.class);
        startActivity(infosSpaghetti);
    }

    public void infosRatatouille(View view) {

        Intent infosRatatouille = new Intent(listePlats.this, Dish_informations_ratatouille.class);
        startActivity(infosRatatouille);
    }

    public void infosCurry(View view) {

        Intent infosCurry = new Intent(listePlats.this, Dish_informations_curry.class);
        startActivity(infosCurry);
    }

    public void addLasagnes(View view) {
        nbLasagnes = nbLasagnes +1;
        lasagnes.setText(Integer.toString(nbLasagnes));
        Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
        d.put("Lasagnes",nbLasagnes);
        DataHolder.getInstance().setPlat(d);
        DataHolder.getInstance().setNbLasagnes(nbLasagnes);

    }
    public void removeLasagnes(View view){
        if(nbLasagnes>0){
            nbLasagnes = nbLasagnes -1;
            lasagnes.setText(Integer.toString(nbLasagnes));
            Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
            d.put("Lasagnes",nbLasagnes);
            DataHolder.getInstance().setPlat(d);
            DataHolder.getInstance().setNbLasagnes(nbLasagnes);
        }
    }

    public void setNbLasagnes(){
        TextView lasagnes = (TextView) findViewById(R.id.lasagnes);
        lasagnes.setText(String.valueOf(nbLasagnes));
    }

    public void addSpaghetti(View view) {
        nbSpaghetti = nbSpaghetti +1;
        spaghetti.setText(Integer.toString(nbSpaghetti));
        Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
        d.put("Spaghetti",nbSpaghetti);
        DataHolder.getInstance().setPlat(d);
        DataHolder.getInstance().setNbSpaghetti(nbSpaghetti);

    }
    public void removeSpaghetti(View view){
        if(nbSpaghetti>0){
            nbSpaghetti = nbSpaghetti -1;
            spaghetti.setText(Integer.toString(nbSpaghetti));
            Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
            d.put("Spaghetti",nbSpaghetti);
            DataHolder.getInstance().setPlat(d);
            DataHolder.getInstance().setNbSpaghetti(nbSpaghetti);
        }
    }

    public void setNbSpaghetti(){
        TextView spaghetti = (TextView) findViewById(R.id.spaghetti);
        spaghetti.setText(String.valueOf(nbSpaghetti));
    }

    public void addCurry(View view) {
        nbCurry = nbCurry +1;
        curry.setText(Integer.toString(nbCurry));
        Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
        d.put("Curry",nbCurry);
        DataHolder.getInstance().setPlat(d);
        DataHolder.getInstance().setNbCurry(nbCurry);

    }
    public void removeCurry(View view){
        if(nbCurry>0){
            nbCurry = nbCurry -1;
            curry.setText(Integer.toString(nbCurry));
            Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
            d.put("Curry",nbCurry);
            DataHolder.getInstance().setPlat(d);
            DataHolder.getInstance().setNbCurry(nbCurry);

        }
    }

    public void setNbCurry(){
        TextView curry = (TextView) findViewById(R.id.curry);
        curry.setText(String.valueOf(nbCurry));
    }

    public void addRatatouille(View view) {
        nbRatatouille = nbRatatouille +1;
        ratatouille.setText(Integer.toString(nbRatatouille));
        Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
        d.put("Ratatouille",nbRatatouille);
        DataHolder.getInstance().setPlat(d);
        DataHolder.getInstance().setNbRatatouille(nbRatatouille);


    }
    public void removeRatatouille(View view){
        if(nbRatatouille>0){
            nbRatatouille = nbRatatouille -1;
            ratatouille.setText(Integer.toString(nbRatatouille));
            Hashtable<String,Integer> d = DataHolder.getInstance().getPlat();
            d.put("Ratatouille",nbRatatouille);
            DataHolder.getInstance().setPlat(d);
            DataHolder.getInstance().setNbRatatouille(nbRatatouille);

        }
    }

    public void setNbRatatouille(){
        TextView ratatouille = (TextView) findViewById(R.id.ratatouille);
        ratatouille.setText(String.valueOf(nbRatatouille));
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
        Intent command = new Intent(listePlats.this, MyCommand.class);
        startActivity(command);
    }


    @Override
    public void onResume(){
        super.onResume();
        nbSpaghetti = DataHolder.getInstance().getNbSpaghetti();
        nbLasagnes = DataHolder.getInstance().getNbLasagnes();
        nbCurry = DataHolder.getInstance().getNbCurry();
        nbRatatouille = DataHolder.getInstance().getNbRatatouille();
        spaghetti.setText(Integer.toString(nbSpaghetti));
        ratatouille.setText(Integer.toString(nbRatatouille));
        lasagnes.setText(Integer.toString(nbLasagnes));
        curry.setText(Integer.toString(nbCurry));
        setNbCurry();
        setNbLasagnes();
        setNbRatatouille();
        setNbSpaghetti();

    }

    public void retour(View view){
        Intent entrees = new Intent(listePlats.this, Carte.class);
        startActivity(entrees);
    }
}
