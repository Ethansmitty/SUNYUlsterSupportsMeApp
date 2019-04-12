package org.sunyulstercs.supportsmeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class InfoRecyclerAdapter extends RecyclerView.Adapter<InfoRecyclerAdapter.InfoRecyclerViewHolder>
{

    //List of stuff to display
    private String[] infoList;
    private String[][] catList;

    /**
     * Constructor for adapter
     * @param infoList List of items to display
     * @param catList Array of all the category's data, to be selected and passed.
     * @param context Application context
     */
    InfoRecyclerAdapter(String[] infoList, String[][] catList, Context context)
    {
        this.infoList = infoList;
        this.catList = catList;
    }

    /**
     * @return InfoRecyclerAdapter
     */
    @NonNull
    @Override
    public InfoRecyclerAdapter.InfoRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.info_row,parent,false);
        return new InfoRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoRecyclerAdapter.InfoRecyclerViewHolder holder, int position)
    {
        holder.text.setText(infoList[position]); //Set text for this cell from list.
        if (catList != null)
        {
            holder.text.setTag(catList[position]);
        }

    }

    /**
     * @return Number of items in list
     */
    @Override
    public int getItemCount() {
        return infoList.length;
    }

    /**
     * Holds the layout for every RecyclerView cell
     */
    class InfoRecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView text;
        InfoRecyclerViewHolder(View itemView)
        {
            super(itemView);
            text = itemView.findViewById(R.id.info_title);
        }
    }
}
