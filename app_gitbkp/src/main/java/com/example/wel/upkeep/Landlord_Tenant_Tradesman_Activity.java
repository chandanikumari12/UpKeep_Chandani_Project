package com.example.wel.upkeep;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.wel.upkeep.Adapter.CustomPagerAdapter;

public class Landlord_Tenant_Tradesman_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord__tenant__tradesman);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

       /* if(viewPager.getCurrentItem()==2)
        {
            Intent i = new Intent(Landlord_Tenant_Tradesman_Activity.this, Activity_First.class);
            startActivity(i);
        }*/
       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Log.i("position","posrt "+position+" "+viewPager.getAdapter().getCount());
                if(position==viewPager.getAdapter().getCount()-1)
                {
                    Intent i = new Intent(Landlord_Tenant_Tradesman_Activity.this, Activity_First.class);
                    startActivity(i);
                }

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }


        });

       /* viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position)
            {
                if(position==viewPager.getAdapter().getCount()){
                    Intent i = new Intent(Landlord_Tenant_Tradesman_Activity.this, Activity_First.class);
                    startActivity(i);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });*/
    }
}
