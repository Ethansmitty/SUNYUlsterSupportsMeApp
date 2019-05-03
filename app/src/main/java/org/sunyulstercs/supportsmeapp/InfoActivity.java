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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info);
        TextView categoryLabel = findViewById(R.id.categoryLabel);
        ImageView categoryImage = findViewById(R.id.department_icon);

        recyclerView = findViewById(R.id.info_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ExpandableInfoAdapter adapter = new ExpandableInfoAdapter(getItems());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
}
