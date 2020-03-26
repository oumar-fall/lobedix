package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    }

    public void infosLasagnes(View view) {

        Intent infosLasagnes = new Intent(listePlats.this, Dish_Informations.class);
        startActivity(infosLasagnes);
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
