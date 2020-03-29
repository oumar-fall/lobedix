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
}
