package com.example.wel.upkeep.chat_system;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wel.upkeep.Message1;
import com.example.wel.upkeep.R;
import com.example.wel.upkeep.chat_system.chat_screen.Chat_Screen_Fragment;

import java.util.List;

/**
 * Created by 103 on 4/27/2018.
 */

/**
 * Created by 103 on 4/23/2018.
 */

public class RecyclerView_chat_user_adapter   extends RecyclerView.Adapter<RecyclerView_chat_user_adapter.MyViewHolder>
{

    private List<Message1> moviesList;
    Context activity1;

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linear_members;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            linear_members = (LinearLayout)itemView.findViewById(R.id.linear_members);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycle_chat_user, parent, false);

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
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final Message1 movie = moviesList.get(position);
        holder.linear_members.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Chat_Screen_Fragment home_fragment = new Chat_Screen_Fragment();
                Bundle bundle = new Bundle();
                home_fragment.setArguments(bundle);
                FragmentTransaction fragmenttransaction =((AppCompatActivity)activity1).getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container,home_fragment);
                fragmenttransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  moviesList.size();
    }

    public RecyclerView_chat_user_adapter(Context activity, List<Message1> moviesList)
    {
        this.moviesList = moviesList;
        activity1 = activity;
    }
}
