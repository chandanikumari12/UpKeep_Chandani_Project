package com.example.wel.upkeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_Add_Payment extends AppCompatActivity {
ImageView image_headaddprop;
Button add_payment_save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add__payment);
        image_headaddprop=(ImageView)findViewById(R.id.image_headaddprop);
        add_payment_save_button=(Button)findViewById(R.id.add_payment_save_button);
        image_headaddprop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Add_Payment.this,Activity_Get_Started.class);
                startActivity(i);
            }
        });
        add_payment_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Add_Payment.this,Activity_Get_Started.class);
                startActivity(i);
            }
        });
    }
}
