package com.arbutus.upkeep.chat_system;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arbutus.upkeep.R;
import com.arbutus.upkeep.repair_adapter.Message1;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment
{
    RecyclerView recyclerview_chat_user;
    List<Message1> message1List = new ArrayList<>();
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerview_chat_user = (RecyclerView)rootview.findViewById(R.id.recyclerview_chat_user);
        RecyclerView_chat_user_adapter recyclerView_chat_user_adapter = new RecyclerView_chat_user_adapter(getActivity(),message1List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview_chat_user.setLayoutManager(linearLayoutManager);
        recyclerview_chat_user.setItemAnimator(new DefaultItemAnimator());
        Log.i("chat_screne_recyc","Receyegdgdfg");
        for(int i =0;i<15 ;i++)
        {
            Message1 Message1 = new Message1("1", "2","3","4","last");
            message1List.add(Message1);
        }
        recyclerview_chat_user.setAdapter(recyclerView_chat_user_adapter);
        return rootview;
    }
}
