package com.hackhb19.fawadjawaidmalik.teamkaese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FoundProductActivity extends AppCompatActivity implements FoundItemAdapter.ItemClickListener{

    FoundItemAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foundproduct_activity);

        Bundle extras = getIntent().getExtras();
        ArrayList<Product> products = (ArrayList<Product>) extras.getSerializable("ERGEBNIS");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FoundItemAdapter(this, products);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



        for(Product p : products){
            System.out.println(p.getProductCategory());
        }

    }

        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        }

    @Override
    public void onBackPressed() {
        Intent addIntent = new Intent(FoundProductActivity.this, FindItemActivity.class);
        startActivity(addIntent);



        finish();
    }

}
