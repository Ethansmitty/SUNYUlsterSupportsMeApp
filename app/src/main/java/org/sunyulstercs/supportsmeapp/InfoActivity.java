package org.sunyulstercs.supportsmeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras(); //Get data passed to activity with Intent
        if (extras != null) {
            array = extras.getStringArray("ListItems"); //ListItems is a String array which will be displayed in RecyclerView


            String s = extras.getString("ActivityName"); //Setting toolbar title based on which category this is
            getSupportActionBar().setTitle(s);
        }

        //TODO: Make the buttons link to other pages
        recyclerView = findViewById(R.id.infoListView); //Set up recyclerview
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new InfoRecyclerAdapter(array, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }


    public void onItemClick(View v) {
        TextView tv = (TextView) v;
        switch (tv.getText().toString())
        {

        }


    }
}
