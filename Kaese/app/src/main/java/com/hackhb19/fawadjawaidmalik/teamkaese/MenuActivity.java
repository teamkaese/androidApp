package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        Button addbutton = findViewById(R.id.addButton);
        Button findbutton = findViewById(R.id.searchButton);
        Button moveoutbutton = findViewById(R.id.checkOut);



        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, QRScannerActivity.class);
                startActivity(addItemIntent);



            }

        });
        findbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, FindItemActivity.class);
                startActivity(addItemIntent);
                finish();
            }
        });
        moveoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, MoveOutActivity.class);
                startActivity(addItemIntent);
                finish();
            }
        });




    }
}
