package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;


public class FindItemActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);

        //Variables
        //datatype from Server

        final EditText NameText = findViewById(R.id.searchItem_Name);
        Button SearchButton = findViewById(R.id.searchItem_button);
        Button ExitButton = findViewById(R.id.searchItem_exit);


        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SendToServer(NameText.getText().toString());

                new Thread(new Runnable(){

                    @Override

                    public void run() {

                        try {

                        Socket client = new Socket("10.200.22.148", 64000);  //connect to server

                        PrintWriter printwriter = new PrintWriter(client.getOutputStream(), true);



                        printwriter.write(NameText.getText().toString());  //write the message to output stream
                        printwriter.flush();
                        printwriter.close();
                        client.close();   //closing the connection


                        } catch (UnknownHostException e) {
                         e.printStackTrace();

                        } catch (IOException e) {
                         e.printStackTrace();

                        }


                    }

                }).start();
            }
        });
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(FindItemActivity.this, MenuActivity.class);
                startActivity(addItemIntent);
                finish();
            }
        });
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
