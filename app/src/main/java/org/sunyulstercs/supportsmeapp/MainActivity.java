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
        Intent intent = new Intent(this, InfoActivity.class);

        switch(view.getId())
        {
            case R.id.campusResourceButton :

                intent.putExtra("CategoryData", R.array.resourcesArrayArray);
                intent.putExtra("CategoryImage", R.drawable.building);
                intent.putExtra("ActivityName", getResources().getString(R.string.campusResourcesButtonDesc));
                break;

            case R.id.financialButton :
                intent.putExtra("CategoryData", R.array.financialArrayArray);
                intent.putExtra("CategoryImage", R.drawable.dollar_sign);
                intent.putExtra("ActivityName", getResources().getString(R.string.financialButtonDesc));
                break;

            case R.id.socialMediaButton :
                intent.putExtra("CategoryData", R.array.socialArrayArray);
                intent.putExtra("CategoryImage", R.drawable.u);
                intent.putExtra("ActivityName", getResources().getString(R.string.socialMediaButtonDesc));
                break;

            case R.id.campusLifeButton:
                intent.putExtra("CategoryData", R.array.campusLifeArrayArray);
                intent.putExtra("CategoryImage", R.drawable.team_lift);
                intent.putExtra("ActivityName", getResources().getString(R.string.campusLifeButtonDesc));
                break;

            case R.id.officesButton :
                intent.putExtra("CategoryData", R.array.officesArrayArray);
                intent.putExtra("CategoryImage", R.drawable.info);
                intent.putExtra("ActivityName", getResources().getString(R.string.officesButtonDesc));
                break;

            case R.id.libraryButton :
                intent.putExtra("CategoryData", R.array.libraryArrayArray);
                intent.putExtra("CategoryImage", R.drawable.book);
                intent.putExtra("ActivityName", getResources().getString(R.string.libraryButtonDesc));
                break;

            case R.id.studentLifeButton :
                intent.putExtra("CategoryData", R.array.studentLifeArrayArray);
                intent.putExtra("CategoryImage", R.drawable.grad_hat);
                intent.putExtra("ActivityName", getResources().getString(R.string.studentLifeButtonDesc));
                break;

            case R.id.scheduleButton :
                intent.putExtra("CategoryData", R.array.scheduleInfoArrayArray);
                intent.putExtra("CategoryImage", R.drawable.calendar);
                intent.putExtra("ActivityName", getResources().getString(R.string.scheduleButtonDesc));
                break;

            case R.id.transportationButton :
                intent.putExtra("CategoryData", R.array.transportArrayArray);
                intent.putExtra("CategoryImage", R.drawable.bus);
                intent.putExtra("ActivityName", getResources().getString(R.string.transportationButtonDesc));
                break;
        }
        Log.d(view.toString(), "Starting activity...");
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //If activity is in the stack somewhere, reuse it.
        startActivity(intent);
    }
}
