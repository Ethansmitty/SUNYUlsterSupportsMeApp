package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 *
 * Use the {@link navFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navFragment extends Fragment implements View.OnClickListener {

    private ImageButton homeButton, profileButton, locationButton;
    public navFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment navFragment.
     */
    public static navFragment newInstance() {
        navFragment fragment = new navFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav, container, false);

        homeButton = view.findViewById(R.id.homeButton);
        locationButton = view.findViewById(R.id.locationButton);
        profileButton = view.findViewById(R.id.profileButton);

        homeButton.setOnClickListener(this);
        locationButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.homeButton :
                Intent homeIntent = new Intent(this.getContext(), MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                break;

            case R.id.locationButton :
                Intent mapIntent = new Intent(this.getContext(), MapActivity.class);
                mapIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(mapIntent);
                break;

            case R.id.profileButton :
                //TODO Do something
                break;
        }
    }

}
