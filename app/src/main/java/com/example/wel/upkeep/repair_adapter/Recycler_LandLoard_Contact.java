package com.example.wel.upkeep.repair_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.wel.upkeep.Message1;
import com.example.wel.upkeep.R;

import java.util.List;

/**
 * Created by 103 on 4/23/2018.
 */

public class Recycler_LandLoard_Contact   extends RecyclerView.Adapter<Recycler_LandLoard_Contact.MyViewHolder>
{
    private List<Message1> moviesList;
    Context activity1;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearlayout_repair_contact;
        ImageView repair_image;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            linearlayout_repair_contact = (LinearLayout)itemView.findViewById(R.id.linearlayout_repair_contact);
            repair_image = (ImageView) itemView.findViewById(R.id.repair_image);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_repair_landlord_contact, parent, false);
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                notifyDataSetChanged();
            }
        });
        activity1 = parent.getContext();

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
    }

    @Override
    public int getItemCount() {
        return  moviesList.size();
    }

    public Recycler_LandLoard_Contact(Context activity, List<Message1> moviesList)
    {
        this.moviesList = moviesList;
        activity1 = activity;
    }
}

