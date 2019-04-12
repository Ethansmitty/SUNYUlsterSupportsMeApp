package org.sunyulstercs.supportsmeapp;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class ExpandableInfoViewHolder extends GroupViewHolder
{
    private TextView infoTitle;

    public ExpandableInfoViewHolder(View itemView) {
        super(itemView);
        infoTitle = itemView.findViewById(R.id.info_title);
    }

    public void setInfoTitle(ExpandableGroup group) {
        infoTitle.setText(group.getTitle());
    }
}
