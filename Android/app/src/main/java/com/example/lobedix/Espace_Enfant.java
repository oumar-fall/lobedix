package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Espace_Enfant extends AppCompatActivity {
    TouchListener touchListener1;
    TouchListener touchListener2;
    TouchListener touchListener3;
    TouchListener touchListener4;
    TouchListener touchListener5;
    TouchListener touchListener6;
    TouchListener touchListener7;
    TouchListener touchListener8;
    ImageView salade ;
    ImageView carottes ;
    ImageView steak;
    ImageView pates ;
    ImageView glace ;
    ImageView crepe ;
    ImageView coca;
    ImageView orange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace__enfant);

        salade = findViewById(R.id.salade);
        carottes = findViewById(R.id.carottes);
        steak = findViewById(R.id.steak);
        pates = findViewById(R.id.pates);
        glace = findViewById(R.id.glace);
        crepe = findViewById(R.id.crepe);
        coca = findViewById(R.id.coca);
        orange = findViewById(R.id.orange);

        run();
        System.out.println("dans le on Create");
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int h = metrics.heightPixels;
        int w  = metrics.widthPixels;

        TextView explication = new TextView(Espace_Enfant.this);
        explication.setText("Déplace les plats que tu veux manger dans la case correspondante");
        explication.setWidth(w);
        explication.setGravity(Gravity.CENTER);
        explication.setX(0);
        explication.setY(h-600);

        TextView entree = new TextView(Espace_Enfant.this);
        entree.setText("Entrée");
        entree.setWidth(300);
        entree.setHeight(300);
        int x =w/2 - 300;
        int y = h/2 - 300;
        entree.setX(x);
        entree.setY(y);
        entree.setBackgroundResource(R.drawable.my_border);
        entree.setGravity(Gravity.CENTER);

        TextView plat = new TextView(Espace_Enfant.this);
        plat.setText("Plat");
        plat.setWidth(300);
        plat.setHeight(300);
        int xp =w/2;
        plat.setX(xp);
        plat.setY(y);
        plat.setBackgroundResource(R.drawable.my_border);
        plat.setGravity(Gravity.CENTER);

        TextView dessert = new TextView(Espace_Enfant.this);
        dessert.setText("Dessert");
        dessert.setWidth(300);
        dessert.setHeight(300);
        int yd  =h/2;
        dessert.setX(x);
        dessert.setY(yd);
        dessert.setBackgroundResource(R.drawable.my_border);
        dessert.setGravity(Gravity.CENTER);

        TextView boisson = new TextView(Espace_Enfant.this);
        boisson.setText("Boisson");
        boisson.setWidth(300);
        boisson.setHeight(300);
        boisson.setX(xp);
        boisson.setY(yd);
        boisson.setBackgroundResource(R.drawable.my_border);
        boisson.setGravity(Gravity.CENTER);


        RelativeLayout linearLayout = findViewById(R.id.layout);


        linearLayout.addView(entree);
        linearLayout.addView(plat);
        linearLayout.addView(dessert);
        linearLayout.addView(boisson);
        linearLayout.addView(explication);


        ImageView entree2 = findViewById(R.id.salade);
        Random r = new Random();
        int posX= r.nextInt(w);
        int posY = r.nextInt(h/2-600);
        entree2.setX(posX);
        entree2.setY(posY);

        ImageView entree1 = findViewById(R.id.carottes);
        Random r1 = new Random();
        int posX1= r1.nextInt(w);
        int posY1 = r1.nextInt(h/2-600);
        entree1.setX(posX1);
        entree1.setY(posY1);

        ImageView plat2 = findViewById(R.id.steak);
        Random r2 = new Random();
        int posX2= r2.nextInt(w);
        int posY2 = r2.nextInt(h/2-600);
        plat2.setX(posX2);
        plat2.setY(posY2);

        ImageView plat1 = findViewById(R.id.pates);
        Random r3 = new Random();
        int posX3= r3.nextInt(w);
        int posY3 = r3.nextInt(h/2-600);
        plat1.setX(posX3);
        plat1.setY(posY3);

        ImageView dessert2 = findViewById(R.id.glace);
        Random r4 = new Random();
        int posX4= r4.nextInt(w);
        int posY4 = r4.nextInt(h/2-600);
        dessert2.setX(posX4);
        dessert2.setY(posY4);

        ImageView dessert1 = findViewById(R.id.crepe);
        Random r5 = new Random();
        int posX5= r5.nextInt(w);
        int posY5 = r5.nextInt(h/2-600);
        dessert1.setX(posX5);
        dessert1.setY(posY5);

        ImageView boisson2 = findViewById(R.id.coca);
        Random r6 = new Random();
        int posX6= r6.nextInt(w);
        int posY6 = r6.nextInt(h/2-600);
        boisson2.setX(posX6);
        boisson2.setY(posY6);

        ImageView boisson1 = findViewById(R.id.orange);
        Random r7 = new Random();
        int posX7= r7.nextInt(w);
        int posY7 = r7.nextInt(h/2-600);
        boisson1.setX(posX7);
        boisson1.setY(posY7);

    }

    public void run() {
        touchListener1 = new TouchListener();
        ImageView entree2 = findViewById(R.id.salade);
        entree2.setOnTouchListener(touchListener1);
        touchListener2 = new TouchListener();
        touchListener3 = new TouchListener();
        touchListener4 = new TouchListener();
        touchListener5 = new TouchListener();
        touchListener6 = new TouchListener();
        touchListener7 = new TouchListener();
        touchListener8 = new TouchListener();
        ImageView entree1 = findViewById(R.id.carottes);
        entree1.setOnTouchListener(touchListener2);
        ImageView plat1 = findViewById(R.id.pates);
        plat1.setOnTouchListener(touchListener3);
        ImageView plat2 = findViewById(R.id.steak);
        plat2.setOnTouchListener(touchListener4);
        ImageView dessert1 = findViewById(R.id.crepe);
        dessert1.setOnTouchListener(touchListener5);
        ImageView dessert2 = findViewById(R.id.glace);
        dessert2.setOnTouchListener(touchListener6);
        ImageView boisson1 = findViewById(R.id.orange);
        boisson1.setOnTouchListener(touchListener7);
        ImageView boisson2 = findViewById(R.id.coca);
        boisson2.setOnTouchListener(touchListener8);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageView imge = findViewById(R.id.salade);
        System.out.println("couocou");
        System.out.println(touchListener1.getActualX());
    }
    public void print(View view){
        ImageView imge = findViewById(R.id.salade);
        System.out.println("couocou");
        System.out.println(touchListener1.getActualX());

        /*LinearLayout t = findViewById(R.id.text);
        System.out.println("wesh");
        System.out.println(t.getLeft());*/

        System.out.println("Yoyoyo");
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

       System.out.println(metrics.heightPixels);
       System.out.println(metrics.widthPixels);
    }

    public void commander(View view){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int h = metrics.heightPixels;
        int w  = metrics.widthPixels;
        int tolerance = 50;
        int limiteXEntreeMin = w/2 -300  - tolerance;
        int limiteXEntreeMax = w/2 -300 + tolerance;
        int limiteYEntreeMin = h/2 -300 - tolerance;
        int limiteYEntreeMax = h/2 -300 + tolerance;
        int compteur = 0; // pour compter le nombre de plats commandés
        String commande ="";

        if (limiteXEntreeMin<carottes.getX() && carottes.getX()<limiteXEntreeMax && limiteYEntreeMin<carottes.getY() && carottes.getY()<limiteYEntreeMax ){
            commande = commande + "Carottes" + "\n";
            compteur = compteur +1;
        }
        if (limiteXEntreeMin<salade.getX() && salade.getX()<limiteXEntreeMax && limiteYEntreeMin<salade.getY() && salade.getY()<limiteYEntreeMax ){
            commande = commande + "Salade" + "\n";
            compteur = compteur +1;
        }

        int limiteXPlatMin = w/2   - tolerance;
        int limiteXPlatMax = w/2  + tolerance;
        int limiteYPlatMin = h/2 -300 - tolerance;
        int limiteYPlatMax = h/2 -300 + tolerance;


        if (limiteXPlatMin<steak.getX() && steak.getX()<limiteXPlatMax && limiteYPlatMin<steak.getY() && steak.getY()<limiteYPlatMax ){
            commande = commande + "Steak haché" + "\n";
            compteur = compteur +1;
        }

        if (limiteXPlatMin<pates.getX() && pates.getX()<limiteXPlatMax && limiteYPlatMin<pates.getY() && pates.getY()<limiteYPlatMax ){
            commande = commande + "Pates au jambon" + "\n";
            compteur = compteur +1;
        }
        int limiteXDessertMin = w/2 -300  - tolerance;
        int limiteXDessertMax = w/2  - 300 + tolerance;
        int limiteYDessertMin = h/2  - tolerance;
        int limiteYDessertMax = h/2  + tolerance;
        if (limiteXDessertMin<glace.getX() && glace.getX()<limiteXDessertMax && limiteYDessertMin<glace.getY() && glace.getY()<limiteYDessertMax ){
            commande = commande + "Glace" + "\n";
            compteur = compteur +1;
        }

        if (limiteXDessertMin<crepe.getX() && crepe.getX()<limiteXDessertMax && limiteYDessertMin<crepe.getY() && crepe.getY()<limiteYDessertMax ){
            commande = commande + "Crepe" + "\n";
            compteur = compteur +1;
        }
        int limiteXBoissonMin = w/2  - tolerance;
        int limiteXBoissonMax = w/2   + tolerance;
        int limiteYBoissonMin = h/2  - tolerance;
        int limiteYBoissonMax = h/2  + tolerance;

        if (limiteXBoissonMin<coca.getX() && coca.getX()<limiteXBoissonMax && limiteYBoissonMin<coca.getY() && coca.getY()<limiteYBoissonMax ){
            commande = commande + "Coca" + "\n";
            compteur = compteur +1;
        }

        if (limiteXBoissonMin<orange.getX() && orange.getX()<limiteXBoissonMax && limiteYBoissonMin<orange.getY() && orange.getY()<limiteYBoissonMax ){
            commande = commande + "Jus d'orange" + "\n";
            compteur = compteur +1;
        }

        System.out.println(commande);
        if(compteur!=4){
            Toast.makeText(this, "Tu n'as pas correctement placé tes plats ! Réessaye ou demande à tes parents de commander pour toi", Toast.LENGTH_LONG).show();
        }
        if(compteur ==4){
            commande = commande + "TOTAL : 8€";
            Intent commande_enfant = new Intent(Espace_Enfant.this, MyCommandeEnfant.class);
            commande_enfant.putExtra("COMMANDE", commande);
            startActivity(commande_enfant);
        }

    }
}
