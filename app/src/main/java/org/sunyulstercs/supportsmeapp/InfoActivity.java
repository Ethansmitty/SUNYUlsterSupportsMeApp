package org.sunyulstercs.supportsmeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity
{

    private Bundle extras;
    RecyclerView recyclerView;
    InfoItemDividerItemDecoration deco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info);
        TextView categoryLabel = findViewById(R.id.categoryLabel);
        ImageView categoryImage = findViewById(R.id.category_image);

        deco = new InfoItemDividerItemDecoration(getDrawable(R.drawable.menu_item_background));


        recyclerView = findViewById(R.id.info_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ExpandableInfoAdapter adapter = new ExpandableInfoAdapter(getItems());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(deco);

        categoryLabel.setText(extras.getString("ActivityName"));
        categoryImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),extras.getInt("CategoryImage"))); //set image button
    }

    private List<ExpandableGroup> getItems()
    {
        List<ExpandableGroup> egList = new ArrayList<>();
        extras = getIntent().getExtras();

        if (extras != null)
        {
            //Getting multidimensional array from resource file
            int catDataID = extras.getInt("CategoryData");
            String[][] catData = ResourceHelper.resourceIDTo2DStringArray(catDataID, getApplicationContext());

            for (String[] array : catData)
            {
                List<InfoItem> infoItemList = new ArrayList<>();
                infoItemList.add(new InfoItem(array));
                egList.add(new ExpandableGroup<>(infoItemList.get(0).getTitle(), infoItemList));
            }
        }
        return egList;
    }

    /*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
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
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        */
/*
        Bundle extras = getIntent().getExtras(); //Get data passed to activity with Intent
        if (extras != null) {
            //Getting multidimensional array from resource file
            int catDataID = extras.getInt("CategoryData");
            catData = ResourceHelper.resourceIDTo2DStringArray(catDataID, getApplicationContext());

            listItems = ResourceHelper.getFirstElementsOf2DStringArray(catData); //ListItems is a String array which will be displayed in RecyclerView

            //getSupportActionBar().setTitle(extras.getString("ActivityName")); //Setting toolbar title based on which category this is
            categoryLabel.setText(extras.getString("ActivityName"));

            categoryImage.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),extras.getInt("CategoryImage"))); //set image button

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
 */
}
