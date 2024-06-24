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
    private List<SpecificationItem> radioButtonItems;
    private SpecificationGroup specitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        radioButtonItems =new ArrayList<>();
        allItems = loadJsonFromAssets();


        Log.e("fetched data", allItems.get(0).toString());


        specificationAdapter = new SpecificationAdapter(allItems);
        recyclerView.setAdapter(specificationAdapter);
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
