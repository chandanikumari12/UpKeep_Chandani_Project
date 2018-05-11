package com.example.wel.upkeep.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wel.upkeep.Message1;
import com.example.wel.upkeep.R;
import com.example.wel.upkeep.repair_adapter.Recycler_LandLoard_Contact;

import java.util.List;

public abstract class Banking_Adapter extends RecyclerView.Adapter<Banking_Adapter.MyViewHolder>
{
    private List<Message1> moviesList;
    Context activity1;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        /*LinearLayout linearlayout_repair_contact;
        ImageView repair_image;*/
        public MyViewHolder(View itemView)
        {
            super(itemView);
           /* linearlayout_repair_contact = (LinearLayout)itemView.findViewById(R.id.linearlayout_repair_contact);
            repair_image = (ImageView) itemView.findViewById(R.id.repair_image);*/
        }
    }

    @Override
    public Banking_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.banking_list_recycle, parent, false);
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                notifyDataSetChanged();
            }
        });
        activity1 = parent.getContext();

        return new Banking_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Banking_Adapter.MyViewHolder holder, int position)
    {
    }

    @Override
    public int getItemCount() {
        return  moviesList.size();
    }

    public Banking_Adapter(Context activity, List<Message1> moviesList)
    {
        this.moviesList = moviesList;
        activity1 = activity;
    }
}

