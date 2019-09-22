package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    boolean doubleBackToExitPressedOnce = false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button addButton = findViewById(R.id.addPackageButton);
        Button findButton = findViewById(R.id.searchPackageButton);
        Button deleteButton = findViewById(R.id.deletePackageButton);
        Button locatebutton = findViewById(R.id.packageLocations);


        View Logo = findViewById(R.id.dmklogo);
        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, DMKWebsiteActivity.class);
                startActivity(addItemIntent);
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(MenuActivity.this, QRScannerActivity.class);
                startActivity(addItemIntent);
                finish();

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
                finish();
            }
        });//Delete package
        locatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(MenuActivity.this, locateActivity.class);
                startActivity(addIntent);
                finish();
            }
        });






    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
