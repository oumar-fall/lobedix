package com.example.lobedix;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Espace_Enfant2 extends AppCompatActivity {
    TouchListener2 touchListener1;
    TouchListener2 touchListener2;
    TouchListener2 touchListener3;
    TouchListener2 touchListener4;
    TouchListener2 touchListener5;
    TouchListener2 touchListener6;
    TouchListener2 touchListener7;
    TouchListener2 touchListener8;
    ImageView salade ;
    ImageView carottes ;
    ImageView steak;
    ImageView pates ;
    ImageView glace ;
    ImageView crepe ;
    ImageView coca;
    ImageView orange;
    FrameLayout positionsPuzzle;
    FrameLayout layout = null;

    int tolerance = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_enfant2);

        layout = findViewById(R.id.global_layout);

        salade = findViewById(R.id.salade);
        carottes = findViewById(R.id.carottes);
        steak = findViewById(R.id.steak);
        pates = findViewById(R.id.pates);
        glace = findViewById(R.id.glace);
        crepe = findViewById(R.id.crepe);
        coca = findViewById(R.id.coca);
        orange = findViewById(R.id.orange);

        positionsPuzzle = findViewById(R.id.positions_puzzle);
        run();
    }

    public class TouchListener2 implements View.OnTouchListener {
        private float xDelta;
        private float yDelta;

        public float getActualX() {
            return actualX;
        }

        public void setActualX(float actualX) {
            this.actualX = actualX;
        }

        public float getActualY() {
            return actualY;
        }

        public void setActualY(float actualY) {
            this.actualY = actualY;
        }

        private float actualX;
        private float actualY;

        private char type = 'p';

        public TouchListener2(char t){
            super();
            type = t;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x = motionEvent.getRawX();
            float y = motionEvent.getRawY();
            RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    view.bringToFront();
                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (layout.getWidth()-view.getWidth() > x-xDelta && x - xDelta > 0){
                        lParams.leftMargin = (int) (x - xDelta);
                        actualX = (int) (x - xDelta);
                    }
                    if (layout.getHeight()-view.getHeight() > y-yDelta && y-yDelta > 0){
                        lParams.topMargin = (int) (y - yDelta);
                        actualY =  (int) (y - yDelta);
                    }
                    view.setLayoutParams(lParams);
                    break;
                case MotionEvent.ACTION_UP:

                    if (type=='e' && positionsPuzzle.getX()-tolerance < actualX && actualX< positionsPuzzle.getX() + tolerance && positionsPuzzle.getY()-tolerance < actualY && carottes.getY()< actualY + tolerance){
                        lParams.leftMargin = (int) positionsPuzzle.getX();
                        lParams.topMargin = (int) positionsPuzzle.getY();
                        actualX = (int) positionsPuzzle.getX();
                        actualY =  (int) positionsPuzzle.getY();
                        view.setLayoutParams(lParams);
                        break;
                    }


                    if (type == 'p' && positionsPuzzle.getX()+ positionsPuzzle.getWidth()-tolerance<actualX+view.getWidth() && positionsPuzzle.getX()+ positionsPuzzle.getWidth()+tolerance>actualX+view.getWidth() && positionsPuzzle.getY()-tolerance<actualY && actualY<positionsPuzzle.getY()+tolerance ){
                        lParams.leftMargin = (int) positionsPuzzle.getX()+ positionsPuzzle.getWidth()-view.getWidth();
                        lParams.topMargin = (int) positionsPuzzle.getY();
                        actualX = (int) positionsPuzzle.getX()+ positionsPuzzle.getWidth()-view.getWidth();
                        actualY =  (int) positionsPuzzle.getY();
                        view.setLayoutParams(lParams);
                        break;
                    }


                    if (type == 'd' && actualX<positionsPuzzle.getX()+tolerance && actualX>positionsPuzzle.getX()-tolerance  && positionsPuzzle.getY()+positionsPuzzle.getHeight()-tolerance < actualY+view.getHeight()  && positionsPuzzle.getY()+positionsPuzzle.getHeight()+tolerance>actualY+view.getHeight() ){
                        lParams.leftMargin = (int) positionsPuzzle.getX();
                        lParams.topMargin = (int) positionsPuzzle.getY()+positionsPuzzle.getHeight()-view.getHeight();
                        actualX = (int) positionsPuzzle.getX();
                        actualY =  (int) positionsPuzzle.getY()+positionsPuzzle.getHeight()-view.getHeight();
                        view.setLayoutParams(lParams);
                        break;
                    }


                    if (type == 'b' && positionsPuzzle.getX()+ positionsPuzzle.getWidth()-tolerance<actualX+view.getWidth() && positionsPuzzle.getX()+ positionsPuzzle.getWidth()+tolerance>actualX+view.getWidth() && positionsPuzzle.getY()+positionsPuzzle.getHeight()-tolerance < actualY+view.getHeight()  && positionsPuzzle.getY()+positionsPuzzle.getHeight()+tolerance>actualY+view.getHeight()){
                        lParams.leftMargin = (int) positionsPuzzle.getX()+ positionsPuzzle.getWidth()-view.getWidth();
                        lParams.topMargin = (int) positionsPuzzle.getY()+positionsPuzzle.getHeight()-view.getHeight();
                        actualX = (int) positionsPuzzle.getX()+ positionsPuzzle.getWidth()-view.getWidth();
                        actualY =  (int) positionsPuzzle.getY()+positionsPuzzle.getHeight()-view.getHeight();
                        view.setLayoutParams(lParams);
                        break;
                    }

            }

            return true;
        }
    }

    public void run() {
        touchListener1 = new TouchListener2('e');
        touchListener2 = new TouchListener2('e');
        touchListener3 = new TouchListener2('p');
        touchListener4 = new TouchListener2('p');
        touchListener5 = new TouchListener2('d');
        touchListener6 = new TouchListener2('d');
        touchListener7 = new TouchListener2('b');
        touchListener8 = new TouchListener2('b');
        salade.setOnTouchListener(touchListener1);
        carottes.setOnTouchListener(touchListener2);
        pates.setOnTouchListener(touchListener3);
        steak.setOnTouchListener(touchListener4);
        crepe.setOnTouchListener(touchListener5);
        glace.setOnTouchListener(touchListener6);
        orange.setOnTouchListener(touchListener7);
        coca.setOnTouchListener(touchListener8);
    }


    public void commander(View view){
        int compteur = 0; // pour compter le nombre de plats commandés
        String commande ="";

        if (positionsPuzzle.getX()-tolerance < carottes.getX() && carottes.getX()< positionsPuzzle.getX() + tolerance && positionsPuzzle.getY()-tolerance < carottes.getY() && carottes.getY()< positionsPuzzle.getY() + tolerance){
            commande += "Carottes\n";
            compteur++;
        }
        if (positionsPuzzle.getX()-tolerance < salade.getX() && salade.getX()< positionsPuzzle.getX() + tolerance && positionsPuzzle.getY()-tolerance < salade.getY() && salade.getY()< positionsPuzzle.getY() + tolerance){
            commande += "Salade\n";
            compteur++;
        }

        if (positionsPuzzle.getX()+ positionsPuzzle.getWidth()-tolerance<pates.getX()+pates.getWidth() && positionsPuzzle.getX()+ positionsPuzzle.getWidth()+tolerance>pates.getX()+pates.getWidth() && positionsPuzzle.getY()-tolerance<pates.getY() && pates.getY()<positionsPuzzle.getY()+tolerance ){
            commande = commande + "Pates au jambon" + "\n";
            compteur = compteur +1;
        }
        if (positionsPuzzle.getX()+ positionsPuzzle.getWidth()-tolerance<steak.getX()+steak.getWidth() && positionsPuzzle.getX()+ positionsPuzzle.getWidth()+tolerance>steak.getX()+steak.getWidth() && positionsPuzzle.getY()-tolerance<steak.getY() && steak.getY()<positionsPuzzle.getY()+tolerance ){
            commande = commande + "Steak Haché" + "\n";
            compteur = compteur +1;
        }

        if (glace.getX()<positionsPuzzle.getX()+tolerance && glace.getX()>positionsPuzzle.getX()-tolerance  && positionsPuzzle.getY()+positionsPuzzle.getHeight()-tolerance < glace.getY()+glace.getHeight()  && positionsPuzzle.getY()+positionsPuzzle.getHeight()+tolerance>glace.getY()+glace.getHeight() ){
            commande = commande + "Glace" + "\n";
            compteur = compteur +1;
        }
        if (crepe.getX()<positionsPuzzle.getX()+tolerance && crepe.getX()>positionsPuzzle.getX()-tolerance  && positionsPuzzle.getY()+positionsPuzzle.getHeight()-tolerance < crepe.getY()+crepe.getHeight()  && positionsPuzzle.getY()+positionsPuzzle.getHeight()+tolerance>crepe.getY()+crepe.getHeight() ){
            commande = commande + "Crepe" + "\n";
            compteur = compteur +1;
        }

        if (positionsPuzzle.getX()+ positionsPuzzle.getWidth()-tolerance<coca.getX()+coca.getWidth() && positionsPuzzle.getX()+ positionsPuzzle.getWidth()+tolerance>coca.getX()+coca.getWidth() && positionsPuzzle.getY()+positionsPuzzle.getHeight()-tolerance < coca.getY()+coca.getHeight()  && positionsPuzzle.getY()+positionsPuzzle.getHeight()+tolerance>coca.getY()+coca.getHeight()){
            commande = commande + "Coca" + "\n";
            compteur = compteur +1;
        }
        if (positionsPuzzle.getX()+ positionsPuzzle.getWidth()-tolerance<orange.getX()+orange.getWidth() && positionsPuzzle.getX()+ positionsPuzzle.getWidth()+tolerance>orange.getX()+orange.getWidth() && positionsPuzzle.getY()+positionsPuzzle.getHeight()-tolerance < orange.getY()+orange.getHeight()  && positionsPuzzle.getY()+positionsPuzzle.getHeight()+tolerance>orange.getY()+orange.getHeight()){
            commande = commande + "Jus d'orange" + "\n";
            compteur = compteur +1;
        }

        System.out.println(commande);
        if(compteur<4){
            Toast.makeText(this, "Tu n'as pas fini de compléter ton menu! Réessaye ou demande à tes parents de commander pour toi", Toast.LENGTH_LONG).show();
        }
        if(compteur>4){
            Toast.makeText(this, "Tu as commandé deux fois la même partie du menu! Réessaye ou demande à tes parents de commander pour toi", Toast.LENGTH_LONG).show();
        }
        if(compteur ==4){
            commande = commande + "TOTAL : 8€";
            Intent commande_enfant = new Intent(Espace_Enfant2.this, MyCommandeEnfant.class);
            commande_enfant.putExtra("COMMANDE", commande);
            startActivity(commande_enfant);
        }

    }
}
