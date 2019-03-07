package org.sunyulstercs.supportsmeapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoRecyclerAdapter extends RecyclerView.Adapter<InfoRecyclerAdapter.InfoRecyclerViewHolder>
{

    //List of stuff to display
    private ArrayList<String> infoList;

    /**
     * Constructor for adapter
     * @param infoList List of items to display
     * @param context Application context
     */
    InfoRecyclerAdapter(ArrayList<String> infoList, Context context)
    {
        this.infoList = infoList;
    }

    /**
     * @return InfoRecyclerAdapter
     */
    @Override
    public InfoRecyclerAdapter.InfoRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.info_row,parent,false);
        return new InfoRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InfoRecyclerAdapter.InfoRecyclerViewHolder holder, int position)
    {
        holder.text.setText(infoList.get(position)); //Set text for this cell from list
    }

    /**
     * @return Number of items in list
     */
    @Override
    public int getItemCount() {
        return infoList.size();
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
            text = itemView.findViewById(R.id.text_id);
        }
    }
}
