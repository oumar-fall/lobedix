package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class listePlats extends AppCompatActivity {

    private int nbSpaghetti;
    private int nbLasagnes;
    private int nbCurry;
    private int nbRatatouille;
    private TextView lasagnes;
    private TextView spaghetti;
    private TextView curry;
    private TextView ratatouille;
    private DrawerLayout drawer;
    private ImageButton menu_button;

    /*private  TextView spaghetti = findViewById(R.id.spaghetti);
    private TextView ratatouille = findViewById(R.id.ratatouille);
    private TextView curry = findViewById(R.id.ratatouille);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_plats);
        lasagnes = findViewById(R.id.Textlasagnes);
        spaghetti = findViewById(R.id.spaghetti);
        ratatouille = findViewById(R.id.ratatouille);
        curry = findViewById(R.id.curry);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_button=(ImageButton)findViewById(R.id.menu_button);

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
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

    }
    public void removeLasagnes(View view){
        if(nbLasagnes>0){
            nbLasagnes = nbLasagnes -1;
            lasagnes.setText(Integer.toString(nbLasagnes));
        }
    }

    public void addSpaghetti(View view) {
        nbSpaghetti = nbSpaghetti +1;
        spaghetti.setText(Integer.toString(nbSpaghetti));

    }
    public void removeSpaghetti(View view){
        if(nbSpaghetti>0){
            nbSpaghetti = nbSpaghetti -1;
            spaghetti.setText(Integer.toString(nbSpaghetti));
        }
    }

    public void addCurry(View view) {
        nbCurry = nbCurry +1;
        curry.setText(Integer.toString(nbCurry));

    }
    public void removeCurry(View view){
        if(nbCurry>0){
            nbCurry = nbCurry -1;
            curry.setText(Integer.toString(nbCurry));
        }
    }

    public void addRatatouille(View view) {
        nbRatatouille = nbRatatouille +1;
        ratatouille.setText(Integer.toString(nbRatatouille));

    }
    public void removeRatatouille(View view){
        if(nbRatatouille>0){
            nbRatatouille = nbRatatouille -1;
            ratatouille.setText(Integer.toString(nbRatatouille));
        }
    }


}
