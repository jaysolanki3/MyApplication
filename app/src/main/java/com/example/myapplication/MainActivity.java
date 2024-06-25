package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SpecificationAdapter specificationAdapter;
    private List<SpecificationGroup> allItems;
    private List<SpecificationGroup> newDetails1 = new ArrayList<>();
    private List<SpecificationItem> radioButtonItems;
    public SpecificationGroup specitem;
    Integer price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        radioButtonItems =new ArrayList<>();
        allItems = loadJsonFromAssets();


        for(SpecificationGroup group : allItems){
            for (SpecificationItem item : group.getList()){
                radioButtonItems.add(item);
                Log.e("fetched data", item.getName().toString());
            }
        }
        Log.e("Radiobuttonsize", String.valueOf(allItems.size()));


        for (SpecificationGroup item2 : allItems) {
            if (item2.getModifierName().equalsIgnoreCase("1 BHK") || item2.getModifierName().equalsIgnoreCase("Flat")) {
                newDetails1.add(item2);
            }
        }
        specificationAdapter = new SpecificationAdapter(getApplicationContext(),newDetails1,radioButtonItems, this::updateDetailList);
        recyclerView.setAdapter(specificationAdapter);
    }

    private void updateDetailList(SpecificationGroup group,String modifier, Integer price1) {
        if (modifier == "1 BHK") {
            price1 = 999;
            price = price1;
            String btn = "ADD TO CART ₹" + price1 + ".00";
            //addtocart.setText(btn);
            List<SpecificationGroup> newDetails = new ArrayList<>();
            for (SpecificationGroup item2 : allItems) {
                if (item2.getModifierName().equalsIgnoreCase("1 BHK") || item2.getModifierName().equalsIgnoreCase("Flat")) {
                    newDetails.add(item2);
                }
            }
            specificationAdapter.updateItems(newDetails);
        } else {
            price = price1;
            String btn = "ADD TO CART ₹" + price1 + ".00";
            //addtocart.setText(btn);
            Log.e("price", btn);
            List<SpecificationGroup> newDetails = new ArrayList<>();
            for (SpecificationGroup item2 : allItems) {
                if (item2.getModifierName().equalsIgnoreCase(modifier) || item2.getModifierName().equalsIgnoreCase("Flat")) {
                    newDetails.add(item2);
                }
            }
            specificationAdapter.updateItems(newDetails);
        }
    }

    private List<SpecificationGroup> loadJsonFromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("item_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SpecificationGroup>>() {}.getType();
        return  gson.fromJson(json, listType);
    }
}
