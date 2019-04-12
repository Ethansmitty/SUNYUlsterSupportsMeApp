package org.sunyulstercs.supportsmeapp;

import android.os.Bundle;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class InfoItemGroup extends ExpandableGroup<Bundle>
{
    private Bundle bundle;
    private String title;

    public  InfoItemGroup(String title, List<Bundle> bundles)
    {
        super(title, bundles);
    }
    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
