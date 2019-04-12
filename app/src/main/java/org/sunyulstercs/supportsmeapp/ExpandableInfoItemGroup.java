package org.sunyulstercs.supportsmeapp;

import android.os.Bundle;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class ExpandableInfoItemGroup extends ExpandableGroup<InfoItem>
{
    private InfoItem infoItem;
    private String title;

    public ExpandableInfoItemGroup(String title, List<InfoItem> items)
    {
        super(title, items);
    }
    @Override
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }




}
