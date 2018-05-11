package com.example.wel.upkeep;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import com.example.wel.upkeep.Edit_profile.EditProfileActivity;
import com.example.wel.upkeep.chat_system.chat_screen.Chat_Screen_Fragment;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    ImageView image_menu, imageSearch, image_home, image_banking, image_repair, image_chat,logout_cross,bckarrow,img_search,arrow_search,bckarrow_menu;
    TextView text_home, text_repair, text_banking, text_chat, text_home1, textmy_properties,group_name,dmanage_banking,
    dmanage_tenant,dnotification,dmy_Properties,dchat,dsetting,dterm_condition,dsupport,dsign_out,yes_text,no_text;
    LinearLayout lin_home, lin_repair, lin_banking, lin_chat, imgtxt_chat,text_image_chat,search_visible,lin_tool,linearlist,user_header;
    ActionBarDrawerToggle drawerToggle;
    NavigationView nav_view;
    FrameLayout fragment_container;
    DrawerLayout drawer_layout;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";
    private DrawerLayout drawerLayout;
    private String position;

    @SuppressLint({"NewApi", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mDrawerLayout = findViewById(R.id.drawer_layout);    //open and close nevigation drawer



        /*  mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);*/
       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        image_menu = (ImageView) findViewById(R.id.image_menu);
        imageSearch = (ImageView) findViewById(R.id.text_search);
        image_home = (ImageView) findViewById(R.id.image_home);
        image_repair = (ImageView) findViewById(R.id.image_repair);
        image_banking = (ImageView) findViewById(R.id.image_banking);
        image_chat = (ImageView) findViewById(R.id.image_chat);
        bckarrow = (ImageView) findViewById(R.id.bckarrow);
        img_search= (ImageView) findViewById(R.id.img_search);
        arrow_search=(ImageView)findViewById(R.id.arrow_search);
        bckarrow_menu=(ImageView)findViewById(R.id.bckarrow_menu);
        drawer_layout=(DrawerLayout)findViewById(R.id.drawer_layout);

        nav_view = (NavigationView) findViewById(R.id.navigation1);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        text_home = (TextView) findViewById(R.id.text_home);
        text_repair = (TextView) findViewById(R.id.test_repair);
        text_home1 = (TextView) findViewById(R.id.text_home1);
        text_banking = (TextView) findViewById(R.id.text_banking);
        dmy_Properties = (TextView) findViewById(R.id.dmy_Properties);
        group_name = (TextView) findViewById(R.id.group_name);
        dmanage_banking = (TextView) findViewById(R.id.dmanage_banking);
        dmanage_tenant = (TextView) findViewById(R.id.dmanage_tenant);
        dnotification = (TextView) findViewById(R.id.dnotification);
        dchat = (TextView) findViewById(R.id.dchat);
        text_chat=(TextView)findViewById(R.id.text_chat);
        dsetting = (TextView) findViewById(R.id.dsetting);
        dterm_condition = (TextView) findViewById(R.id.dterm_condition);
        dsupport = (TextView) findViewById(R.id.dsupport);
        dsign_out = (TextView) findViewById(R.id.dsign_out);


        /*dhome=(TextView)nav_view.findViewById(R.id.dhome);*/

        textmy_properties = (TextView) findViewById(R.id.dmy_Properties);

        lin_home = (LinearLayout) findViewById(R.id.imgtxt_home);
        lin_repair = (LinearLayout) findViewById(R.id.imgtxt_repair);
        lin_banking = (LinearLayout) findViewById(R.id.imgtxt_banking);
        lin_chat = (LinearLayout) findViewById(R.id.imgtxt_chat);
        text_image_chat = (LinearLayout) findViewById(R.id.text_image_chat);
        search_visible=(LinearLayout)findViewById(R.id.search_visible);
        lin_tool=(LinearLayout)findViewById(R.id.lin_tool);
        linearlist=(LinearLayout)findViewById(R.id.linearlist);
        user_header=(LinearLayout)findViewById(R.id.user_header);

        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);

        drawer_layout.setDrawerListener(new ActionBarDrawerToggle(this, drawer_layout,  R.string.drawer_open, R.string.drawer_close)
        {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                lin_tool.setVisibility(View.VISIBLE);
                user_header.setVisibility(View.GONE);

            }

            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                Log.i("draweropenopen","open");

                    Log.i("draweropenlft","left");
                lin_tool.setVisibility(View.GONE);
                user_header.setVisibility(View.VISIBLE);

            }
        });

        if(getIntent().getStringExtra("tag") !=null)
        {
            String str = getIntent().getStringExtra("tag");

            text_chage_string("4");                                     //to set the fragment in home page
            final ChatFragment chatFragment = new ChatFragment();
            Bundle bundle = new Bundle();
            chatFragment.setArguments(bundle);
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.replace(R.id.fragment_container, chatFragment);
            fragmenttransaction.commit();
            text_home.setText("Chat");
            text_home.setTextColor(Color.WHITE);
        }
        else
        {
            text_chage_string("1");                                     //to set the fragment in home page
            final Home_Fragment home_fragment = new Home_Fragment();
            Bundle bundle = new Bundle();
            home_fragment.setArguments(bundle);
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.replace(R.id.fragment_container, home_fragment);
            fragmenttransaction.commit();
            text_home.setText("Home");
            text_home.setTextColor(Color.WHITE);
        }
       /*linearlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listrowfragmentFragment listrowfragmentFragment = new listrowfragmentFragment();
                Bundle bundle = new Bundle();
                listrowfragmentFragment.setArguments(bundle);
                FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, listrowfragmentFragment);
                fragmenttransaction.commit();

            }
        });*/
        bckarrow_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lin_tool.setVisibility(View.VISIBLE);
                user_header.setVisibility(View.GONE);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

        arrow_search.setOnClickListener(new View.OnClickListener()   //toolbar visibility on afterclick of backpress arrow
        {
            @Override
            public void onClick(View view) {
                search_visible.setVisibility(View.GONE);
                lin_tool.setVisibility(View.VISIBLE);

            }
        });
        /*lin_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_visible.setVisibility(View.GONE);
                lin_tool.setVisibility(View.VISIBLE);
            }
        });*/
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Toast.makeText(Home_Activity.this,"Message",Toast.LENGTH_SHORT).show();
                search_visible.setVisibility(View.VISIBLE);
                lin_tool.setVisibility(View.GONE);

            }
        });
        /*NavigationView navigationView = findViewById(R.id.nav_view);*/
        image_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.i("draweropenbtnclk", "right");
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT))
                {
                    user_header.setVisibility(View.GONE);
                    lin_tool.setVisibility(View.VISIBLE);
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                }
                else
                {
                    user_header.setVisibility(View.VISIBLE);
                    lin_tool.setVisibility(View.GONE);
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        /*bckarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_Activity.this,Home_Activity.class);
                startActivity(intent);
                mDrawerLayout.closeDrawers();

            }
        });*/
        lin_home.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                text_chage_string("1");
                Home_Fragment home_fragment = new Home_Fragment();
                Bundle bundle = new Bundle();
                home_fragment.setArguments(bundle);
                FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, home_fragment);
                fragmenttransaction.commit();
                text_home.setText("Home");
                text_home.setTextColor(Color.WHITE);
            }
        });


        lin_repair.setOnClickListener(new View.OnClickListener() {
            public Object fragmentRegister;      //to call fragment

            @Override
            public void onClick(View v) {
                text_chage_string("2");
                Repair_Fragment Repair_Fragment = new Repair_Fragment();
                Bundle bundle = new Bundle();
                Repair_Fragment.setArguments(bundle);
                FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, Repair_Fragment);
                fragmenttransaction.commit();
                text_home.setText("Repair");                             //Change TextView inside Fragment
                text_home.setTextColor(Color.WHITE);

            }
        });
        lin_banking.setOnClickListener(new View.OnClickListener() {         //to call fragment
            @Override
            public void onClick(View v) {
                text_chage_string("3");
                Banking_Fragment Banking_fragment = new Banking_Fragment();
                Bundle bundle = new Bundle();
                Banking_fragment.setArguments(bundle);
                FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, Banking_fragment);
                fragmenttransaction.commit();
                text_home.setText("Banking");
                text_home.setTextColor(Color.WHITE);
            }
        });
        lin_chat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                text_chage_string("4");
              /*  ChatFragment fragment_chatting = new ChatFragment();
                Bundle bundle = new Bundle();
                fragment_chatting.setArguments(bundle);
                FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, fragment_chatting);
                fragmenttransaction.commit();*/



                text_home.setText("CHAT");
                text_home.setTextColor(Color.WHITE);
                Intent intent=new Intent(Home_Activity.this,Home_Activity.class);
                intent.putExtra("tag","Chat");
                startActivity(intent);
                finish();
            }
        });
        group_name.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("1");
            }
        });

        dmanage_banking.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("2");
            }
        });
        dmanage_tenant.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("3");
            }
        });
        dnotification.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("4");
            }
        });
        dmy_Properties.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("5");
                Intent i=new Intent(Home_Activity.this,Home_Activity.class);
                startActivity(i);
            }
        });
        text_image_chat.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("6");

                Intent intent=new Intent(Home_Activity.this,Home_Activity.class);
                intent.putExtra("tag","Chat");
                startActivity(intent);
                finish();
                    mDrawerLayout.closeDrawers();         //to close drawer
            }
        });

        dsetting.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("7");
                Intent i=new Intent(Home_Activity.this,EditProfileActivity.class);
                startActivity(i);
            }
        });
        dterm_condition.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("8");
                Intent i=new Intent(Home_Activity.this,Activity_Terms_Condition.class);
                startActivity(i);
            }
        });

        dsupport.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {

                backgroung_string("9");
                Intent i=new Intent(Home_Activity.this,Activity_Support.class);
                startActivity(i);

            }
        });

        dsign_out.setOnClickListener(new View.OnClickListener() {     //to call fragment
            @Override
            public void onClick(View v) {
                backgroung_string("10");
                showAlertDialogButtonClicked(v);
            }

            public void showAlertDialogButtonClicked(View view){           //function call and AlertDialog


                // create and show the alert dialog
                final Dialog dialog = new Dialog(Home_Activity.this);
                // AlertDialog dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.logout_popup_activity);
                yes_text=(TextView)dialog.findViewById(R.id.yes_text);
                logout_cross=(ImageView)dialog.findViewById(R.id.image_close);
                no_text=(TextView)dialog.findViewById(R.id.no_text);
                dialog.show();

                logout_cross.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View popupView) {
                        dialog.dismiss();
                    }
                });


                yes_text.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View popupView) {
                                Intent intent=new Intent(Home_Activity.this,Activity_First.class);
                                startActivity(intent);
                                finish();
                    }
                });
                no_text.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View popupView) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }


    private void text_chage_string(String str) {
        lin_home.setBackgroundColor(getResources().getColor(R.color.colorLightgray));
        image_home.setImageResource(R.drawable.home);
        text_home1.setTextColor(Color.parseColor("#59474b"));

        lin_repair.setBackgroundColor(getResources().getColor(R.color.colorLightgray));
        image_repair.setImageResource(R.drawable.repair);
        text_repair.setTextColor(Color.parseColor("#59474b"));

        lin_banking.setBackgroundColor(getResources().getColor(R.color.colorLightgray));
        image_banking.setImageResource(R.drawable.banking);
        text_banking.setTextColor(Color.parseColor("#59474b"));

        lin_chat.setBackgroundColor(getResources().getColor(R.color.colorLightgray));
        image_chat.setImageResource(R.drawable.chat);
        text_chat.setTextColor(Color.parseColor("#59474b"));

        text_chage_string1(str);


    }

    @Override
    protected void onResume() {
        super.onResume();
     /*   ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new
        RecyclerViewAdapter().MyClickListener() {
        @Override
        public void onItemClick(int position, View v) {
        Log.i(LOG_TAG, " Clicked on Item " + position);
        }
        }):*/
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index);
            results.add(index, obj);
        }
        return results;
    }


    private void text_chage_string1(String string) {
        if (string.equals("1")) {
            lin_home.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            image_home.setImageResource(R.drawable.home_active);
            text_home1.setTextColor(Color.parseColor("#FFFFFF"));

        } else if (string.equals("2")) {
            lin_repair.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            image_repair.setImageResource(R.drawable.repair_active);
            text_repair.setTextColor(Color.parseColor("#FFFFFF"));

        } else if (string.equals("3")) {
            lin_banking.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            image_banking.setImageResource(R.drawable.banking_active);
            text_banking.setTextColor(Color.parseColor("#FFFFFF"));

        } else if (string.equals("4")) {
            lin_chat.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            image_chat.setImageResource(R.mipmap.chat_active);
            text_chat.setTextColor(Color.parseColor("#FFFFFF"));
        }

    }

    private void backgroung_string(String backgroung) {
        group_name.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dmanage_banking.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dmanage_banking.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dmanage_tenant.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dnotification.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dmy_Properties.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        text_image_chat.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dsetting.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dterm_condition.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dsupport.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        dsign_out.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        backgroung_string1(backgroung);
    }

    private void backgroung_string1(String backgroung1) {
        if (backgroung1.equals("1")) {
            group_name.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("2")) {
            dmanage_banking.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

            } else if (backgroung1.equals("3")) {
            dmanage_tenant.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("4")) {
            dnotification.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("5")) {
            dmy_Properties.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("6")) {
            text_image_chat.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("7")) {
            dsetting.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("8")) {
            dterm_condition.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("9")) {
            dsupport.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));

        } else if (backgroung1.equals("10")) {
            dsign_out.setBackgroundColor(getResources().getColor(R.color.colorNevigationselect));


        }
      }

   }