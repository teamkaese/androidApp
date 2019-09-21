package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class FindItemActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);

        //UI
        final EditText NameText = findViewById(R.id.searchItem_Name);
        Button SearchButton = findViewById(R.id.searchItem_button);



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
        }); //Search Button

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
