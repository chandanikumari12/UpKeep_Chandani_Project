package com.example.wel.upkeep;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Terms_Condition extends AppCompatActivity {
    TextView text_termcondition,text_heading;
    ImageView image_head_terms_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__terms__condition);
        text_termcondition=(TextView)findViewById(R.id.text_termcondition);
        image_head_terms_con=(ImageView)findViewById(R.id.image_head_terms_con);
        text_heading=(TextView)findViewById(R.id.text_heading);



        image_head_terms_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Terms_Condition.this,Home_Activity.class);
                finish();
            }
        });
        Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
        text_heading.setTypeface(museosans);

        Typeface museosans1 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        text_termcondition.setTypeface(museosans1);

    }
}
