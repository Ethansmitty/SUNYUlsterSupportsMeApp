package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);

        switch(view.getId())
        {
            case R.id.campusResourceButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.resourcesList));
                intent.putExtra("ActivityName", getResources().getString(R.string.campusResourcesButtonDesc));
                break;

            case R.id.financialButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.financialList));
                intent.putExtra("ActivityName", getResources().getString(R.string.financialButtonDesc));
                break;

            case R.id.socialMediaButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.socialList));
                intent.putExtra("ActivityName", getResources().getString(R.string.socialMediaButtonDesc));
                break;

            case R.id.campusLifeButton:
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.campusLifeList));
                intent.putExtra("ActivityName", getResources().getString(R.string.campusLifeButtonDesc));
                break;

            case R.id.officesButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.officesList));
                intent.putExtra("ActivityName", getResources().getString(R.string.officesButtonDesc));
                break;

            case R.id.libraryButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.libraryList));
                intent.putExtra("ActivityName", getResources().getString(R.string.libraryButtonDesc));
                break;

            case R.id.studentLifeButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.studentLifeList));
                intent.putExtra("ActivityName", getResources().getString(R.string.studentLifeButtonDesc));
                break;

            case R.id.scheduleButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.scheduleInfoList));
                intent.putExtra("ActivityName", getResources().getString(R.string.scheduleButtonDesc));
                break;

            case R.id.transportationButton :
                intent.setClass(this, InfoActivity.class);
                intent.putExtra("ListItems", getResources().getStringArray(R.array.transportList));
                intent.putExtra("ActivityName", getResources().getString(R.string.transportationButtonDesc));
                break;
        }
        Log.d(view.toString(), "Starting activity...");
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //If activity is in the stack somewhere, reuse it.
        startActivity(intent);
    }
}
