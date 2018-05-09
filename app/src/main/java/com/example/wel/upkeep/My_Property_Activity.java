package com.example.wel.upkeep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wel.upkeep.repair_adapter.Item;
import com.example.wel.upkeep.repair_adapter.SelectableAdapterMessage;
import com.example.wel.upkeep.repair_adapter.SelectableItemMessage;
import com.example.wel.upkeep.repair_adapter.SelectableViewHolderMessage;

import java.util.ArrayList;
import java.util.List;

public class My_Property_Activity extends AppCompatActivity implements SelectableViewHolderMessage.OnItemSelectedListener {
   ImageView image_headmyproperty;
RecyclerView recyclerView;
    SelectableAdapterMessage selectableAdapterMessage;
    List<Item> selectableItems = new ArrayList<>();
    private String id_value_messg;
    TextView header_text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__property_);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_repair_contact);
        image_headmyproperty=(ImageView)findViewById(R.id.image_headmyproperty);
        image_headmyproperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(My_Property_Activity.this,Activity_Get_Started.class);
                startActivity(i);
            }
        });
       // header_text = (TextView)findViewById(R.id.header_text);
       // header_text.setText("Repair Contact");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        selectableAdapterMessage = new SelectableAdapterMessage(this,selectableItems,false);
        for(int i = 0 ;i<7;i++)
        {
            Item item = new Item("id"+i, "message"+i, "createdon"+i,"isread"+i,"video"+i,getString(R.string.repair_text),"My_Property_Activity");
            if(!(selectableItems.contains(item)))
            {
                selectableItems.add(item);
            }
        }
        selectableAdapterMessage.notifyDataSetChanged();
        set_message_group();
    }

    private void set_message_group()
    {
        selectableAdapterMessage = new SelectableAdapterMessage(this,selectableItems,false);
        Log.i("response","ssselectableItems "+selectableItems);
        recyclerView.setAdapter(selectableAdapterMessage);
    }

    @Override
    public void onItemSelected(SelectableItemMessage item)
    {
        String id_value =  item.getName();
        Log.i("id_value_mesg","id "+id_value+" "+id_value_messg);
        if(id_value.equalsIgnoreCase(id_value_messg))
        {
            id_value_messg ="";
            set_message_group();
        }
        else
        {
            id_value_messg = id_value;
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
