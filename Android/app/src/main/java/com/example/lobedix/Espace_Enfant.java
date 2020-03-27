package com.example.lobedix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Espace_Enfant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace__enfant);
        run();
    }

    public void run() {
        TouchListener touchListener = new TouchListener();
        ImageView lasagnes = findViewById(R.id.imageView);
        lasagnes.setOnTouchListener(touchListener);

    }
}
