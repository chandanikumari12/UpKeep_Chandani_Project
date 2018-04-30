package com.example.wel.upkeep;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_First extends AppCompatActivity {
    TextView text_one ,text_two ,text_three ,text_four;
    LinearLayout linear_one ,linear_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__first);
        /*getSupportActionBar().setTitle(null);*/  //To remove text of toolbar which shows bydefaut text

        text_one=(TextView)findViewById(R.id.textemail_btn);
        text_two=(TextView)findViewById(R.id.text_welcome);
        text_three=(TextView)findViewById(R.id.text_signgoogle);
        text_four=(TextView)findViewById(R.id.loginfacebook);

        linear_one=(LinearLayout)findViewById(R.id.lin_one);
        linear_two=(LinearLayout)findViewById(R.id.lin_two);

        text_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_First.this,Activity_Login.class);
                startActivityForResult(intent, 0);
                finish();  //Kill the activity from which you will go to next activity
            }
        });

        linear_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_First.this, "Sign Google", Toast.LENGTH_SHORT).show();
            }
        });

        linear_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_First.this, "Login Facebook", Toast.LENGTH_SHORT).show();
            }
        });


        Typeface museosans = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //To set Font Family
        text_two.setTypeface(museosans);
        text_one.setTypeface(museosans);

        Typeface museosans1 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        text_three.setTypeface(museosans1);
        text_four.setTypeface(museosans1);
    }
}
