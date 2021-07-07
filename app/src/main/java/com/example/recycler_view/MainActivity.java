package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    MyListAdapter adapter;
    RecyclerView recyclerView;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        data.add("apple");
        data.add("banana");
        data.add("cherry");

        adapter = new MyListAdapter(this, data);
        recyclerView = findViewById(R.id.fruitList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        et = findViewById(R.id.etFruit);
    }

    public void onAdd(View v) {
        String newfruit = et.getText().toString();
        data.add(newfruit);
        adapter.notifyDataSetChanged();
    }
}