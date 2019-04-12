package org.sunyulstercs.supportsmeapp;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class InfoViewHolder extends GroupViewHolder
{
    private TextView infoTitle;

    public InfoViewHolder(View itemView) {
        super(itemView);
        infoTitle = itemView.findViewById(R.id.info_title);
    }

    public void setGenreTitle(ExpandableGroup group) {
        infoTitle.setText(group.getTitle());
    }
}
