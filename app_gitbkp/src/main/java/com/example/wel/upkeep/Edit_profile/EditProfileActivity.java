package com.example.wel.upkeep.Edit_profile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wel.upkeep.Activity_Support;
import com.example.wel.upkeep.CommonMethod;
import com.example.wel.upkeep.Home_Activity;
import com.example.wel.upkeep.R;


public class EditProfileActivity extends AppCompatActivity
{
    ImageView image_head_edit,female_image,male_image;
    TextView text_btnsave,male_button,female_button;
    LinearLayout female_linear,male_linear;
  /*  CommonMethod commonMethod ;*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        image_head_edit=(ImageView)findViewById(R.id.image_head_edit);
        text_btnsave=(TextView)findViewById(R.id.text_btnsave);
        female_linear=(LinearLayout)findViewById(R.id.female_linear);
        male_linear=(LinearLayout)findViewById(R.id.male_linear);
        male_image=(ImageView)findViewById(R.id.male_image);
        female_image=(ImageView)findViewById(R.id.female_image);
        male_button=(TextView)findViewById(R.id.male_button);
        female_button=(TextView)findViewById(R.id.female_button);
       /* commonMethod  = new CommonMethod(this);*/
        image_head_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //commonMethod.click_back_button();
                Intent i=new Intent(EditProfileActivity.this,Home_Activity.class);
                finish();
            }
        });
        text_btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //commonMethod.click_back_button();
                Intent i=new Intent(EditProfileActivity.this,Home_Activity.class);
                finish();
            }
        });
        female_linear.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("1");
            }
        });
        male_linear.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("2");
            }
        });
    }
    private void backgroung_string(String backgroung) {
        female_image.setImageResource(R.mipmap.fem);
        female_button.setTextColor(Color.parseColor("#99a2b3"));

        male_image.setImageResource(R.mipmap.male);
        male_button.setTextColor(Color.parseColor("#99a2b3"));

        backgroung_string1(backgroung);
    }
        private void backgroung_string1(String backgroung1) {
            if (backgroung1.equals("1")) {
                female_image.setImageResource(R.mipmap.female_active);
                female_button.setTextColor(Color.parseColor("#59474b"));


            } else if (backgroung1.equals("2")) {
                male_image.setImageResource(R.mipmap.male_active);
                male_button.setTextColor(Color.parseColor("#59474b"));
            }
        }
}