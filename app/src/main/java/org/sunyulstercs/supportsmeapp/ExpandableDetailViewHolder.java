package org.sunyulstercs.supportsmeapp;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ExpandableDetailViewHolder extends ChildViewHolder
{
    private TextView infoTitle;
    private TextView infoDesc;

    public ExpandableDetailViewHolder(View view)
    {
        super(view);
        infoTitle = view.findViewById(R.id.info_title);
        infoDesc = view.findViewById(R.id.info_desc);
    }

    public void OnBind(InfoItem info)
    {
        infoTitle.setText(info.getTitle());
        infoDesc.setText(info.getDesc());

    }

}
