package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Placeholder class, uses an old version of InfoActivity as a way to display the details. Pending an actual design, this will be removed.
 */
public class InfoDetailActivity extends AppCompatActivity
{
    private String[] listItems;
    private String [][] catData;
    private TextView categoryLabel;
    private ImageView categoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        categoryLabel = findViewById(R.id.categoryLabel);
        categoryImage = findViewById(R.id.categoryImage);

        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        */

        Bundle extras = getIntent().getExtras(); //Get data passed to activity with Intent
        if (extras != null)
        {
            listItems = extras.getStringArray("ListItems"); //ListItems is a String array which will be displayed in RecyclerView
            Object[] objectArray = (Object[]) extras.getSerializable("CategoryData");
            if(objectArray!=null) {
                catData = new String[objectArray.length][];
                for (int i = 0; i < objectArray.length; i++) {
                    catData[i] = (String[]) objectArray[i];
                }
            }


            try
            {
                //getSupportActionBar().setTitle(extras.getString("ActivityName")); //Setting toolbar title based on which category this is
                categoryLabel.setText(extras.getString("ActivityName"));
                categoryImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),extras.getInt("CategoryImage"))); //set image button
            } catch (NullPointerException | android.content.res.Resources.NotFoundException e)
            {
                Log.e(this.getLocalClassName(), "Null title/image");
            }

        }

        RecyclerView recyclerView = findViewById(R.id.infoListView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new InfoRecyclerAdapter(listItems, catData, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick(View v)
    {
        Log.d(this.getLocalClassName(),"Detail button clicked.");
    }
}
