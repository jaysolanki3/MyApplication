package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
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

        loadJsonFromAssets();
        radioButtonItems = specitem.getList();

        specificationAdapter = new SpecificationAdapter(radioButtonItems,allItems);
        recyclerView.setAdapter(specificationAdapter);
    }

    private void loadJsonFromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("item_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            Type listType = new TypeToken<List<SpecificationGroup>>() {}.getType();
            allItems =  gson.fromJson(json, listType);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
