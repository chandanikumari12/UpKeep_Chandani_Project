package com.example.wel.upkeep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Tenant_GetStarted extends AppCompatActivity {
    LinearLayout lin_connect_landlord,my_proprty,lin_termscondition;
    TextView text_tenant_complete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tenant__get_started);

        lin_connect_landlord=(LinearLayout)findViewById(R.id.lin_connect_landlord);
        my_proprty=(LinearLayout)findViewById(R.id.my_proprty);
        lin_termscondition=(LinearLayout)findViewById(R.id.lin_termscondition);

        text_tenant_complete=(TextView)findViewById(R.id.text_tenant_complete);

    }
}
