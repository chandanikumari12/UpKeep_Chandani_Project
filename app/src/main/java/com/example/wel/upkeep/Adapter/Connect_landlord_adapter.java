package com.example.wel.upkeep.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wel.upkeep.Message1;
import com.example.wel.upkeep.R;
import com.example.wel.upkeep.chat_system.RecyclerView_chat_user_adapter;
import com.example.wel.upkeep.chat_system.chat_screen.Chat_Screen_Fragment;

import java.util.List;

public class Connect_landlord_adapter extends RecyclerView.Adapter<Connect_landlord_adapter.MyViewHolder>
{
    private List<Movie> moviesList;
    Context activity1;

    public Connect_landlord_adapter(List<Movie> movieList)
    {
        this.moviesList = movieList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearlist_connect;
        public ImageView click_circle;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            linearlist_connect = (LinearLayout)itemView.findViewById(R.id.linearlist_connect);
            click_circle=(ImageView)itemView.findViewById(R.id.click_circle);
        }
    }
    @Override
    public Connect_landlord_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_connect_landlord_item, parent, false);

        /*itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                notifyDataSetChanged();
            }
        });*/
        activity1 = parent.getContext();

        return new Connect_landlord_adapter.MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final Connect_landlord_adapter.MyViewHolder holder, int position)
    {
        final Movie movie = moviesList.get(position);

        /*holder.linearlist_connect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Chat_Screen_Fragment home_fragment = new Chat_Screen_Fragment();
                Bundle bundle = new Bundle();
                home_fragment.setArguments(bundle);
                FragmentTransaction fragmenttransaction =((AppCompatActivity)activity1).getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.frame_contain,home_fragment);
                fragmenttransaction.commit();
            }
        });*/

        holder.click_circle.setOnClickListener(new View.OnClickListener()
        {//to call fragment
            @Override
            public void onClick(View v)
            {
                backgroung_string("1",holder.click_circle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  moviesList.size();
    }

    public Connect_landlord_adapter(Context activity, List<Movie> moviesList)
    {
        this.moviesList = moviesList;
        activity1 = activity;
    }

    private void backgroung_string(String backgroung,ImageView imageView)
    {

        imageView.setImageResource(R.mipmap.click_circle);

        backgroung_string1(backgroung,imageView);
    }
    private void backgroung_string1(String backgroung1, ImageView imageView)
    {
        if (backgroung1.equals("1"))
        {

            imageView.setImageResource(R.mipmap.click_active);
        }
        }
}

