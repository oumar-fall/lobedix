package com.example.lobedix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MyCommandeEnfant extends AppCompatActivity {
    private DrawerLayout drawer;
    private ImageButton menu_button;
    private NavigationView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_commande_enfant);
        Intent i = getIntent();
        String commande = i.getStringExtra("COMMANDE");
        TextView c = findViewById(R.id.commande);
        c.setText(commande);
    }

    public void retour(View view){
        Intent menus = new Intent(MyCommandeEnfant.this, Espace_Enfant2.class);
        startActivity(menus);
    }

    public void confirm(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Validation de la commande");
        builder.setMessage("Etes-vous sûr.e de vouloir confirmer votre commande ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Oui",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MyCommandeEnfant.this, "Votre commande est en cours de préparation.", Toast.LENGTH_SHORT).show();
                        DataHolder.getInstance().cleanListeDessert();
                        DataHolder.getInstance().cleanListeEntree();
                        DataHolder.getInstance().cleanListeMenu();
                        DataHolder.getInstance().cleanListePlat();
                        DataHolder.getInstance().cleanListeBoisson();
                        startActivity(new Intent(MyCommandeEnfant.this, MainActivity.class));
                    }
                });

        builder.setNegativeButton("Non",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
