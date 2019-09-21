package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CheeseMap extends AppCompatActivity {

    DrawRects drawRects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese_map);
        Bundle extras = getIntent().getExtras();

        String cheese = extras.getString("catt","Camenbert");

        Toast.makeText(this, cheese, Toast.LENGTH_SHORT).show();

        drawRects = new DrawRects(this,cheese);
        drawRects.setBackgroundColor(Color.WHITE);
        setContentView(drawRects);
    }
}
