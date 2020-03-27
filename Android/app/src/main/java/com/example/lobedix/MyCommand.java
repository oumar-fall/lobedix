package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyCommand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_command);
        TextView commande = findViewById(R.id.commande);
        String c = DataHolder.getInstance().textCommande();
        commande.setText(c);
    }
    @Override
    public void onResume(){
        super.onResume();
        TextView commande = findViewById(R.id.commande);
        String c = DataHolder.getInstance().textCommande();
        commande.setText(c);

    }
}
