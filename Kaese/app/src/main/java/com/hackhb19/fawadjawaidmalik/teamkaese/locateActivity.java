package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class locateActivity extends AppCompatActivity {

    WebView locateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locate_activity);

        locateView = findViewById(R.id.locateweb);

        locateView.loadUrl("http://10.200.24.15:7000");
    }


    @Override
    public void onBackPressed() {

        Intent addIntent = new Intent(locateActivity.this, MenuActivity.class);
        startActivity(addIntent);
        finish();

    }
}
