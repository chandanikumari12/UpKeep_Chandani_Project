package com.example.wel.upkeep;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Verifyemail extends AppCompatActivity {
    TextView text_one, text_two ,text_three, text_four, text_five, text_six;
    EditText edit_one, edit_two, edit_three, edit_four, edit_five, edit_six , edit_seven , edit_eight;
    ImageView image_headverify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__verifyemail);
        text_one=(TextView)findViewById(R.id.text_btnsignup);
        text_two=(TextView)findViewById(R.id.text_resend);
        text_three=(TextView)findViewById(R.id.text_verifyaccount);
        text_four=(TextView)findViewById(R.id.text_codemail);
        text_five=(TextView)findViewById(R.id.text_vericode);
        text_six=(TextView)findViewById(R.id.text_resend);

        edit_one=(EditText)findViewById(R.id.edit_text1);
        edit_two=(EditText)findViewById(R.id.edit_text2);
        edit_three=(EditText)findViewById(R.id.edit_text3);
        edit_four=(EditText)findViewById(R.id.edit_text4);

        image_headverify=(ImageView)findViewById(R.id.image_headverify);

        Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
        text_one.setTypeface(museosans);
        text_three.setTypeface(museosans);

        Typeface museosans1 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        text_four.setTypeface(museosans1);
        edit_one.setTypeface(museosans1);
        edit_two.setTypeface(museosans1);
        edit_three.setTypeface(museosans1);
        edit_four.setTypeface(museosans1);
        text_five.setTypeface(museosans1);
        text_six.setTypeface(museosans1);

        image_headverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Verifyemail.this,Landlord_Tenant_Activity.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity

            }
        });

        edit_four.setOnEditorActionListener(new TextView.OnEditorActionListener() {     //user pressing Enter while typing in an EditText, something like the onSubmit
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Intent intent=new Intent(Activity_Verifyemail.this,Activity_Signup.class);
                    startActivityForResult(intent, 0);
                    finish();  //Kill the activity from which you will go to next activity

                    return true;
                }
                return false;
            }
        });


        text_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Verifyemail.this,Landlord_Tenant_Activity.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity

            }
        });
        text_two.setText(R.string.resend_code);
        text_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_Verifyemail.this,"Resend Code Page",Toast.LENGTH_SHORT).show();

                Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
                text_two.setTypeface(museosans);
                            }
        });


        edit_one.addTextChangedListener(new TextWatcher() {     //How to change the focus to next edit text

            public void afterTextChanged(Editable s) {

                if (s.length() ==1) {
                    edit_two.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });

        edit_two.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    edit_three.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
        edit_three.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    edit_four.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
        edit_four.addTextChangedListener(new TextWatcher() {
        public void afterTextChanged(Editable s) {
            if (s.length() == 1) {
                text_one.requestFocus();
            }

        }

        public void beforeTextChanged(CharSequence s, int start, int count,
        int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before,
        int count) {

        }
    });

    }

}
