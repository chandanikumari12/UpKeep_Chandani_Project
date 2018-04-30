package com.example.wel.upkeep;

import android.content.Intent;
import android.graphics.Typeface;
import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Get_Started extends AppCompatActivity {
    TextView text_btncompleted,text_myprop,text_repaircontacts,textlin_banking,text_termsconditions,text_getstarted;
    LinearLayout my_proprty,repair_contact,banking,lin_termscondition;
    CheckBox checkbox_check;
    ImageView myprop_image,image_circle,image_repaire,circle1,image_banking,image_backbutton,image_headland_get;
    private TwoStatePreference checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__get__started);
        text_btncompleted=(TextView)findViewById(R.id.text_btncompleted);
        text_myprop=(TextView)findViewById(R.id.text_myprop);
        text_repaircontacts=(TextView)findViewById(R.id.text_repaircontacts);
        textlin_banking=(TextView)findViewById(R.id.textlin_banking);
        text_termsconditions=(TextView)findViewById(R.id.text_termsconditions);
        text_getstarted=(TextView)findViewById(R.id.text_getstarted);

        my_proprty=(LinearLayout) findViewById(R.id.my_proprty);
        repair_contact=(LinearLayout)findViewById(R.id.repair_contact);
        banking=(LinearLayout)findViewById(R.id.banking);
        lin_termscondition=(LinearLayout)findViewById(R.id.lin_termscondition);

        checkbox_check=(CheckBox)findViewById(R.id.checkbox_check);

        myprop_image=(ImageView)findViewById(R.id.myprop_image);
        image_circle=(ImageView)findViewById(R.id.image_circle);
        circle1=(ImageView)findViewById(R.id.circle1);
        image_repaire=(ImageView)findViewById(R.id.image_repaire);
        image_banking=(ImageView)findViewById(R.id.image_banking);
        image_backbutton=(ImageView)findViewById(R.id.image_backbutton);
        image_headland_get=(ImageView)findViewById(R.id.image_headland_get);

        Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
        text_getstarted.setTypeface(museosans);
        text_btncompleted.setTypeface(museosans);

        Typeface museosans1 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        text_myprop.setTypeface(museosans1);
        text_repaircontacts.setTypeface(museosans1);
        textlin_banking.setTypeface(museosans1);
        text_termsconditions.setTypeface(museosans1);

        image_headland_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Get_Started.this,Landlord_Tenant_Activity.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        /*SpannableString spannable = new SpannableString(Html.fromHtml(" I AGREE TO THE <u>TERMS & CONDITIONS</u>"));   //to set underline in between text
        text_termsconditions.setText(spannable);*/

        text_termsconditions.setOnClickListener(new View.OnClickListener() {      //On the text click checkbox should be checked.
            @Override
            public void onClick(View view) {

                if(checkbox_check.isChecked())
                {
                    checkbox_check.setChecked(false);
                }
                else
                    {
                        checkbox_check.setChecked(true);
                    }
            }
        });
        text_termsconditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Get_Started.this,Activity_Terms_Condition.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        text_btncompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activity_Get_Started.this,Home_Activity.class);
                startActivity(i);
                Toast.makeText(Activity_Get_Started.this,"Button Complete",Toast.LENGTH_SHORT).show();
            }
        });
        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Get_Started.this,Activity_Terms_Condition.class);
                startActivity(i);
            }
        });
        my_proprty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Get_Started.this,Activity_Add_Property.class);
                startActivity(i);
            }
        });


    }
}
