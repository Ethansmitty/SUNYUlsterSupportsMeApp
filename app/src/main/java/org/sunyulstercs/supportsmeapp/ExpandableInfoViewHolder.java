package org.sunyulstercs.supportsmeapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class ExpandableInfoViewHolder extends GroupViewHolder
{
    private TextView infoTitle;
    private ImageView infoImage;

    ExpandableInfoViewHolder(View itemView) {
        super(itemView);
        infoTitle = itemView.findViewById(R.id.info_title);
        infoImage  = itemView.findViewById(R.id.info_item_image);
    }

    void setInfoTitle(String title) {
        infoTitle.setText(title);
    }

    @Override
    public void expand() {
        super.expand();
        Context context = infoTitle.getContext();
        Drawable background = context.getDrawable(R.drawable.menu_item_background_selected);
        infoTitle.setBackground(background);
        infoImage.setBackground(background);
    }

    @Override
    public void collapse() {
        super.collapse();
        Context context = infoTitle.getContext();
        Drawable background = context.getDrawable(R.drawable.menu_item_background);
        infoTitle.setBackground(background);
        infoImage.setBackground(background);
    }

}
