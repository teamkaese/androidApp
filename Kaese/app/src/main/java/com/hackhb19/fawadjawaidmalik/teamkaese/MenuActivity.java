package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button addButton = findViewById(R.id.addPackageButton);
        Button findButton = findViewById(R.id.searchPackageButton);
        Button deleteButton = findViewById(R.id.deletePackageButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, QRScannerActivity.class);
                startActivity(addItemIntent);


            }

        });
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, FindItemActivity.class);
                startActivity(addItemIntent);
                finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deleteItemIntent = new Intent(MenuActivity.this, DeletePackageActivity.class);
                startActivity(deleteItemIntent);
                //finish();
            }
        });


    }

}
