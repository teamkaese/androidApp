package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.google.zxing.Result;

import java.util.Calendar;
import java.util.regex.Pattern;

import butterknife.OnClick;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class StorageScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private boolean flashState = false;

    private ProgressDialog progressDialog;
    private String baseUrl;
    public String message;
    public Package packageDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storageadd_activity);

        ActivityCompat.requestPermissions(StorageScanActivity.this,
                new String[]{Manifest.permission.CAMERA},
                1);

        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);

        baseUrl = "http://10.200.24.15:8080/";


        Bundle extras = getIntent().getExtras();
        packageDetails = (Package) getIntent().getParcelableExtra("parcel_data");
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(final Result rawResult) {

        // show custom alert dialog
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog_storage_id);

        View v = dialog.getWindow().getDecorView();
        v.setBackgroundResource(android.R.color.transparent);

        TextView text = (TextView) dialog.findViewById(R.id.someText);
        text.setText(rawResult.getText());
        ImageView img = (ImageView) dialog.findViewById(R.id.imgOfDialog);
        img.setImageResource(R.drawable.ic_done_gr);


        Button add_button = (Button) dialog.findViewById(R.id.addButton);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SetUpPosition(rawResult.toString());

                //ServerAction();
                addData(rawResult.toString());


                Intent addItemIntent = new Intent(StorageScanActivity.this, MenuActivity.class);
                startActivity(addItemIntent);

                finish();

            }
        });

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mScannerView.resumeCameraPreview(StorageScanActivity.this);
            }
        });
        dialog.show();
    }

    public void SetUpPosition(String result)
    {
        String [] positions;


        positions = result.split(Pattern.quote("-"));
        GlobalVar.position = new Position(positions[1], positions[2]);
        GlobalVar.StorageNumber = positions[0];
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(StorageScanActivity.this, "Permission denied to camera", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    @OnClick
    void qrActivityOnClickEvents(View v) {

        switch (v.getId()) {
            /*case R.id.historyButton:
                i = new Intent(this, HistoryActivity.class);
                startActivity(i);
                break;
            case R.id.lightButton:
                if(flashState==false) {
                    v.setBackgroundResource(R.drawable.ic_flash_off);
                    Toast.makeText(getApplicationContext(), "Flashlight turned on", Toast.LENGTH_SHORT).show();
                    mScannerView.setFlash(true);
                    flashState = true;
                }else if(flashState) {
                    v.setBackgroundResource(R.drawable.ic_flash_on);
                    Toast.makeText(getApplicationContext(), "Flashlight turned off", Toast.LENGTH_SHORT).show();
                    mScannerView.setFlash(false);
                    flashState = false;
                }
                break;*/
        }

    }

    public void ServerAction()
    {
        //send the variables
        //If Data was successfully sent give response


        PackageSerializer serializer = new PackageSerializer();


        //Set all Global Variables empty
        GlobalVar.Description = "";
        GlobalVar.Name = "";
        GlobalVar.ITEM_ID = "";
        GlobalVar.position = null;
        GlobalVar.ExpirationDay = "";
        GlobalVar.StorageNumber = "";
    }


    private void addData(String storageNumber){
        //String enteredpostid = postid.getText().toString();

        progressDialog = new ProgressDialog(StorageScanActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining retrofit api service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StorageScanActivity.ApiService service = retrofit.create(StorageScanActivity.ApiService.class);

        String [] positions = storageNumber.split(Pattern.quote("-"));
        Position position = new Position(positions[1], positions[2]);
        Package userPackage = new Package(packageDetails.getId(), packageDetails.getProductCategory(), position, packageDetails.getDescription()
        ,storageNumber, packageDetails.getExpirationDay(), (Calendar.getInstance().getTime()).toString(), "riping", false);
        //Log.v("PACKAGEHERE", userPackage()
        Call<AddResponse> call = service.createPackage(userPackage);/*packageId*/
        //calling the api
        call.enqueue(new Callback<AddResponse>() {
            @Override
            public void onResponse(Call<AddResponse> call, Response<AddResponse> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Package Added", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AddResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private interface ApiService {

        @POST("api/")
        Call<AddResponse> createPackage(@Body Package userpackage);
    }


    private class AddResponse{
        @SerializedName("status")
        private String status;

        public void setStatus(String status){
            this.status = status;
        }
        public String getStatus(){
            return status;
        }

    }
    @Override
    public void onBackPressed() {
        Intent addIntent = new Intent(StorageScanActivity.this, AddItemActivity.class);
        startActivity(addIntent);



        finish();
    }


}
