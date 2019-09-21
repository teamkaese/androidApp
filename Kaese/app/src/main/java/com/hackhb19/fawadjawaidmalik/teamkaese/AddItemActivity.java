package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddItemActivity extends AppCompatActivity {



    public EditText NameInput;
    public EditText DescriptionInput;
    public EditText StorageInput;
    public String ITEM_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        NameInput = findViewById(R.id.addItem_Name);
        DescriptionInput = findViewById(R.id.addItem_Description);
        StorageInput = findViewById(R.id.addItem_Storage);
        final Button OKButton = findViewById(R.id.addItem_OK_button);
        final Button ExitButton = findViewById(R.id.addItem_Exit_button);


        Bundle extras = getIntent().getExtras();
        ITEM_ID = extras.getString("ITEM_ID"); //Item ID from QR Code Scan

        TextView ITEM_TEXT = findViewById(R.id.item_id_field);

        ITEM_TEXT.setText("Item ID: " + ITEM_ID); //set TextView-Text to Item ID




        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(NameInput.getText().toString() == "" | DescriptionInput.getText().toString() == "")
                {
                    Toast toast = Toast.makeText(getBaseContext(), "Something is missing", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    toast.show();
                }// does not work??
                else
                {
                    SetData();
                    ServerAction();

                    Intent addItemIntent = new Intent(AddItemActivity.this, MenuActivity.class);
                    startActivity(addItemIntent);
                    finish();

                }

            }
        });
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemIntent = new Intent(AddItemActivity.this, MenuActivity.class);
                startActivity(addItemIntent);
                finish();
            }
        });




    }

    public void SetData()
    {
        GlobalVar.Description = DescriptionInput.getText().toString();
        GlobalVar.Name = NameInput.getText().toString();
        GlobalVar.ITEM_ID = ITEM_ID;
        GlobalVar.StorageID = StorageInput.getText().toString();
    }

    public void ServerAction()
    {
        //send the global variables
        //If Data was successfully sent give response


        //wait 2s that user can check response

        //Set all Global Variables empty
        GlobalVar.Description = "";
        GlobalVar.Name = "";
        GlobalVar.ITEM_ID = "";
        GlobalVar.StorageID = "";

    }

}
