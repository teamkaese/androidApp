package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class AddItemActivity extends AppCompatActivity {



    public EditText NameInput;
    public EditText DescriptionInput;
    public String ITEM_ID;
    public TextView dateview;

    //Variables
    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        //UI
        NameInput = findViewById(R.id.addItem_Name);
        DescriptionInput = findViewById(R.id.addItem_Description);
        TextView ITEM_TEXT = findViewById(R.id.item_id_field);
        final Button ScanButton = findViewById(R.id.addItem_scan_button);
        final Button CalendarButton = findViewById(R.id.calendarbutton);
        dateview = findViewById(R.id.addItem_date);


        //getITEM-ID
        Bundle extras = getIntent().getExtras();
        ITEM_ID = extras.getString("ITEM_ID"); //Item ID from QR Code Scan

        //put ITEM-ID in a Textview
        ITEM_TEXT.setText("Item ID: " + ITEM_ID); //set TextView-Text to Item ID


        ScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    SetData();

                    Intent addItemIntent = new Intent(AddItemActivity.this, StorageScanActivity.class);
                    startActivity(addItemIntent);


            }
        }); //Scan Storage Location Button

        CalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_WEEK);
                int month = c.get(Calendar.DAY_OF_MONTH);
                int year = c.get(Calendar.DAY_OF_YEAR);

                dpd = new DatePickerDialog(AddItemActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateview.setText(i + "/" + (i1 + 1) + "/" + i2);
                    }
                }, day, month, year);

                dpd.show();
            }
        });
    }

    public void SetData()
    {
        GlobalVar.Description = DescriptionInput.getText().toString();
        GlobalVar.Name = NameInput.getText().toString();
        GlobalVar.ITEM_ID = ITEM_ID;
        GlobalVar.ExpirationDay = dateview.getText().toString();
    } //Save the data from the formula



}
