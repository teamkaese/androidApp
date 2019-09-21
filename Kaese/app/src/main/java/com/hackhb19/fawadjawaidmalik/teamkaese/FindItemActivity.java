package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindItemActivity extends AppCompatActivity {


    Spinner spin;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);

        //Variables
        //datatype from Server

        final EditText NameText = findViewById(R.id.searchItem_Name);
        Button SearchButton = findViewById(R.id.searchItem_button);
        //spin = (Spinner) findViewById(R.id.spinner1);



        // new Thread(new Runnable(){
//
        //    @Override
        //     public void run() {
        //     try {
        //        setSpin(Product.getCategorys());
        //    }catch(Exception e){
        //        e.printStackTrace();
        //    }
        //    }

        // }).start();


        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SendToServer(NameText.getText().toString());

                new Thread(new Runnable(){

                    @Override

                    public void run() {

                        try {
                            System.out.println(Product.getAllProducts().size());
                            System.out.println(Product.getProductsByCategory("Maasdammer").iterator().next().getProductCategory());

                            ArrayList<Product> ergebniss = Product.getProductsByCategory(NameText.getText().toString());



                            Intent addItemIntent = new Intent(FindItemActivity.this, FoundProductActivity.class);
                            addItemIntent.putExtra("ERGEBNIS", ergebniss);
                            startActivity(addItemIntent);

                        }catch(Exception e){
                            e.printStackTrace();
                        }


                    }

                }).start();
            }
        });




    }

    // public void setSpin(ArrayList<String> list){
    //     ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(FindItemActivity.this, android.R.layout.simple_spinner_item, list);
    //     dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    //     spin.setAdapter(dataAdapter);
    //}



}