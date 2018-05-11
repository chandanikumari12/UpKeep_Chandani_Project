package com.example.wel.upkeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Landlord_Tenant_Activity extends AppCompatActivity {
    LinearLayout image_landlord, image_tenant;
    ImageView img_llord, img_back1, img_tanent, img_back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord__tenant_);
        image_landlord=(LinearLayout)findViewById(R.id.image_landlord);
        image_tenant=(LinearLayout)findViewById(R.id.image_tenant);
        img_llord=(ImageView)findViewById(R.id.img_llord);
        img_back1=(ImageView)findViewById(R.id.img_back1);

        image_landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Landlord_Tenant_Activity.this,Activity_Get_Started.class);
                startActivityForResult(intent, 0);

            }
        });
        image_tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Landlord_Tenant_Activity.this,Activity_Tenant_GetStarted.class);
                startActivityForResult(i, 0);
            }
        });

    }
}
