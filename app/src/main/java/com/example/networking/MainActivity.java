package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    RecyclerView recyclerView;
    private Button getData;
    private Button clearData;
    private List<Mountain> itemslist;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemslist = new ArrayList<>();
        myAdapter = new MyAdapter(itemslist);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData = findViewById(R.id.get_data);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JsonTask(MainActivity.this).execute(JSON_URL);
            }
        });

        new JsonFile(this, this).execute(JSON_FILE);
    }





    @Override
    public void onPostExecute(String json) {
        Log.d("TEST", "onPostExecute: " + json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>(){}.getType();
        ArrayList<Mountain> tmpList = gson.fromJson(json, type);
        Log.d("TEST", "onPostExecute: " + tmpList.toString());
        myAdapter.setitemslist(tmpList);
        myAdapter.notifyDataSetChanged();
        Log.d("MainActivity", json);
    }

}
