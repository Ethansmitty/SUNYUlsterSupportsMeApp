package org.sunyulstercs.supportsmeapp;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

class ExpandableDetailViewHolder extends ChildViewHolder
{
    //TODO: This is where you add new stuff, like "More Info" buttons
    private TextView infoDesc;

    ExpandableDetailViewHolder(View view)
    {
        super(view);
        infoDesc = view.findViewById(R.id.info_desc);
    }

    void OnBind(InfoItem info)
    {
        infoDesc.setText(info.getDesc());

    }

}
