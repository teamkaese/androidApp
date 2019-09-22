package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class DMKWebsiteActivity extends AppCompatActivity {

    public WebView chromeextension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dmkwebsite_acitivity);

        chromeextension = findViewById(R.id.webviewchrome);

        chromeextension.loadUrl("https://www.dmk.de/");
    }

    @Override
    public void onBackPressed() {

            Intent addIntent = new Intent(DMKWebsiteActivity.this, MenuActivity.class);
            startActivity(addIntent);
            finish();

    }

}
