package com.example.wel.upkeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wel.upkeep.Tenant.Connect_Landlord_Activity;

public class Activity_Tenant_GetStarted extends AppCompatActivity {
    LinearLayout lin_connect_landlord,my_proprty,lin_termscondition,Lin_payment;
    ImageView image_headland_get;
    TextView text_tenant_complete,text_termsconditions,text_btncompleted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tenant__get_started);

        lin_connect_landlord=(LinearLayout)findViewById(R.id.lin_connect_landlord);
        my_proprty=(LinearLayout)findViewById(R.id.my_proprty);
        lin_termscondition=(LinearLayout)findViewById(R.id.lin_termscondition);
        image_headland_get=(ImageView)findViewById(R.id.image_headland_get);
        text_tenant_complete=(TextView)findViewById(R.id.text_tenant_complete);
        text_termsconditions=(TextView)findViewById(R.id.text_termsconditions);
        text_btncompleted=(TextView)findViewById(R.id.text_btncompleted);

        Lin_payment=(LinearLayout)findViewById(R.id.Lin_payment);
        image_headland_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Tenant_GetStarted.this,Landlord_Tenant_Activity.class);
                startActivity(i);
            }
        });
        text_termsconditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Activity_Tenant_GetStarted.this,Activity_Terms_Condition.class);
                startActivity(i);
            }
        });
        Lin_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Activity_Tenant_GetStarted.this,Activity_Add_Payment.class);
                startActivity(i);
            }
        });
        text_btncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Tenant_GetStarted.this, Connect_Landlord_Activity.class);
                startActivity(i);
            }
        });
    }
}
