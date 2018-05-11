package com.example.wel.upkeep;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Add_RepairActivity extends AppCompatActivity
{
    ImageView img_head_addrepair;
    Spinner types_of_repairs;
    Button add_repair_save_button;
    TextView header_text;
    LinearLayout linear_header;
    private int list;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_repair);
        types_of_repairs=(Spinner)findViewById(R.id.types_of_repairs);
        img_head_addrepair=(ImageView)findViewById(R.id.img_head_addrepair);
        add_repair_save_button=(Button)findViewById(R.id.add_repair_save_button);


        img_head_addrepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Add_RepairActivity.this,Activity_Get_Started.class);
                startActivity(i);
            }
        });
        add_repair_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Add_RepairActivity.this,Repair_COntact_listActivity.class);
                startActivity(i);
            }
        });

        ArrayList<String> categories  = new ArrayList<>();
        categories.add("Types of Repairs");
        categories.add("213");
        categories.add("312");
        categories.add("132");
        categories.add("231");
        categories.add("321");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.simple_list_spinner,categories);
        types_of_repairs.setAdapter(arrayAdapter);
    }
}
