package com.example.wel.upkeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity_Support extends AppCompatActivity {
    ImageView img_header_support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__support);
        img_header_support=(ImageView)findViewById(R.id.img_header_support);
        img_header_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Support.this,Home_Activity.class);
                finish();
            }
        });
    }
}
