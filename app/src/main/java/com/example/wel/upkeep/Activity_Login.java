package com.example.wel.upkeep;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import java.util.Random;

public class Activity_Login extends AppCompatActivity {
    EditText edit_one, edit_two, edit_three;
    TextView text_one, text_two, text_three, text_four, text_five, text_six, text_seven;
    ImageView image_close,image_headlogin;
    LinearLayout linear_one;
    private Object view;
    private Object showAlertDialogButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
       /* getSupportActionBar().setTitle(null);*/
        edit_one=(EditText)findViewById(R.id.edit_uname);
        edit_two=(EditText)findViewById(R.id.edit_password);

        text_one=(TextView) findViewById(R.id.text_fpassword);
        text_two=(TextView)findViewById(R.id.text_loginbtn);
        text_three=(TextView)findViewById(R.id.text_login);
        text_four=(TextView)findViewById(R.id.text_sign);
        text_five=(TextView)findViewById(R.id.text_alreadyaccount);

       // image_headlogin=(ImageView)findViewById(R.id.image_headlogin);

        linear_one= (LinearLayout) findViewById(R.id.lin_signup);

        /*edit_two.setTransformationMethod(new AsteriskPasswordTransformationMethod()); */  //To change the password text from dot(.) to asterisk(*)
        edit_two.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        text_four.setText(R.string.signup_underline);
        text_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Login.this,Activity_Signup.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity

            }
        });
     text_one.setText(R.string.forgot_password);
     text_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_Login.this,Landlord_Tenant_Activity.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity
            }
        });

        edit_two.setOnEditorActionListener(new TextView.OnEditorActionListener() {     //user pressing Enter while typing in an EditText, something like the onSubmit
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Intent intent=new Intent(Activity_Login.this,Activity_Verifyemail.class);
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
                showAlertDialogButtonClicked(v);
            }
        });
        /*image_headlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Login.this,Activity_First.class);
                startActivity(i);
            }
        });*/



        Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
        text_two.setTypeface(museosans);
        text_three.setTypeface(museosans);

        Typeface museosans1 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        text_one.setTypeface(museosans1);
        edit_one.setTypeface(museosans1);
        edit_two.setTypeface(museosans1);
        text_five.setTypeface(museosans1);
        text_four.setTypeface(museosans1);
    }


    public void showAlertDialogButtonClicked(View view){           //function call and AlertDialog

        // setup the alert builder
      AlertDialog.Builder builder = new AlertDialog.Builder(this);


        // create and show the alert dialog
        final Dialog dialog = new Dialog(this);
       // AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_pop_up);
        text_seven=(TextView)dialog.findViewById(R.id.text_okbtn);
        text_six=(TextView)dialog.findViewById(R.id.text_forgetpass);
        edit_three=(EditText)dialog.findViewById(R.id.edit_emailadd);
        image_close=(ImageView)dialog.findViewById(R.id.image_close);



        dialog.show();
        text_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        image_close.setOnClickListener(new View.OnClickListener() {      //Dismiss(to clocse the cross image)
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Typeface museosans3 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
        text_six.setTypeface(museosans3);

        Typeface museosans4 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        edit_three.setTypeface(museosans4);
        text_seven.setTypeface(museosans4);

    }

   /* private class AsteriskPasswordTransformationMethod implements TransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {

            return new PasswordCharSequence(source);
        }

        @Override
        public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {

        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }
            public char charAt(int index) {
                return '*'; // This is the important part
            }
            public int length() {
                return mSource.length(); // Return default
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    };*/
    }
