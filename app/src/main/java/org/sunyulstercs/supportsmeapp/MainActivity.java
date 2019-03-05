package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.net.Uri;
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
            case R.id.officesButton : intent.setClass(this, InfoActivity.class);
            break;
        }
        Log.d(view.toString(), "Starting activity...");
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
