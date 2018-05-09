package com.example.wel.upkeep.repair_adapter;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.wel.upkeep.Message1;
import com.example.wel.upkeep.R;

import java.util.List;

/**
 * Created by 103 on 4/21/2018.
 */

public class Recycler_Repair_contact extends RecyclerView.Adapter<Recycler_Repair_contact.MyViewHolder>
{
    private List<Message1> moviesList;
    Context activity1;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView username;
        //   WebView webview;


        ImageView message_icon,phone_icon;
        public MyViewHolder(View view)
        {
            super(view);
            username = (TextView) view.findViewById(R.id.username);

            message_icon =(ImageView)view.findViewById(R.id.message_icon);
            phone_icon =(ImageView)view.findViewById(R.id.phone_icon);

        }

    }

    public Recycler_Repair_contact(Context activity, List<Message1> moviesList)
    {
        this.moviesList = moviesList;
        activity1 = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_devo_story_text, parent, false);
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                notifyDataSetChanged();
            }
        });
        context = parent.getContext();

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        final Message1 movie = moviesList.get(position);

    }

    @Override
    public int getItemCount()
    {
        return moviesList.size();
    }
}
