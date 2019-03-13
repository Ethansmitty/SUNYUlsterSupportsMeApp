package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] listItems;
    private String [][] catData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras(); //Get data passed to activity with Intent
        if (extras != null) {
            //Getting multidimensional array from resource file
            int catDataID = extras.getInt("CategoryData");
            catData = ResourceHelper.resourceIDTo2DStringArray(catDataID, getApplicationContext());

            listItems = ResourceHelper.getFirstElementsOf2DStringArray(catData); //ListItems is a String array which will be displayed in RecyclerView

            getSupportActionBar().setTitle(extras.getString("ActivityName")); //Setting toolbar title based on which category this is

            recyclerView = findViewById(R.id.infoListView); //Set up recyclerview
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new InfoRecyclerAdapter(listItems, catData, getApplicationContext());
            recyclerView.setAdapter(adapter);
        }
    }


    public void onItemClick(View v)
    {
        TextView tv = (TextView) v;
        String[] newList = (String[]) tv.getTag();
        if (newList != null) {
            Intent intent = new Intent(this, InfoDetailActivity.class);
            intent.putExtra("ListItems", newList);
            intent.putExtra("ActivityName", newList[0]);
            startActivity(intent);
        }
    }
}
