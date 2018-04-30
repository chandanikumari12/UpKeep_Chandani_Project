package com.example.wel.upkeep;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Signup extends AppCompatActivity {
    TextView text_one, text_twobtn, text_three, text_four;
    EditText edit_one, edit_two, edit_three, edit_four;
    LinearLayout lin_one;
    ImageView image_head_signup;
    private Object Menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__signup);


       /* getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //to set action bar in left side
        getSupportActionBar().setTitle(null);                   //to remone text which shows bydefault
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_button);  //to set icon which is given to backpress*/

        text_one = (TextView) findViewById(R.id.text_signup);
        text_twobtn = (TextView) findViewById(R.id.text_btnsignup);
        text_three = (TextView) findViewById(R.id.text_alreadyaccount);
        text_four = (TextView) findViewById(R.id.text_account);


        edit_one = (EditText) findViewById(R.id.edit_uname);
        edit_two = (EditText) findViewById(R.id.edit_eaddress);
        edit_three = (EditText) findViewById(R.id.edit_password);
        edit_four = (EditText) findViewById(R.id.edit_confpassword);

        lin_one = (LinearLayout)findViewById(R.id.allaccount);

        image_head_signup=(ImageView)findViewById(R.id.image_head_signup);


        // set font family

        Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");
        text_one.setTypeface(museosans);
        text_twobtn.setTypeface(museosans);

        Typeface museosans1 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        edit_one.setTypeface(museosans1);
        edit_two.setTypeface(museosans1);
        edit_three.setTypeface(museosans1);
        edit_four.setTypeface(museosans1);


/*
        edit_one.setOnTouchListener(new View.OnTouchListener() {     //key pad disable and enable
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edit_one.setFocusableInTouchMode(true);
                return false;
            }
        });

        edit_two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edit_two.setFocusableInTouchMode(true);
                return false;
            }
        });

        edit_three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edit_three.setFocusableInTouchMode(true);
                return false;
            }
        });

        edit_four.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edit_four.setFocusableInTouchMode(true);
                return false;
            }
        });*/
        image_head_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Signup.this, Activity_Login.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity
            }
        });
        text_twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Signup.this, Activity_Verifyemail.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity
            }
        });

        edit_four.setOnEditorActionListener(new TextView.OnEditorActionListener() {     //user pressing Enter while typing in an EditText, something like the onSubmit
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Intent intent = new Intent(Activity_Signup.this, Activity_Login.class);
                    startActivityForResult(intent, 0);
                    finish();  //Kill the activity from which you will go to next activity
                    return true;
                }
                return false;
            }
        });
        text_four.setText(R.string.account);
        text_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Signup.this, Activity_Login.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity

            }
        });


    }

    /*@Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}