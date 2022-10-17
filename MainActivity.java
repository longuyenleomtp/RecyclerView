package com.example.btrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ComputerAdapter adapter;
    ArrayList<Computer> computers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.computersList);

        computers = new ArrayList<Computer>();

        for (int i = 1; i <= 50; i++) {
            computers.add(new Computer("Computer Name"+i , 13000000 + (i % 2)));
        }

        adapter = new ComputerAdapter(computers, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}