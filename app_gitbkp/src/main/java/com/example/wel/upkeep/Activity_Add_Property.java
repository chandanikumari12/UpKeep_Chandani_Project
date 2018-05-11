package com.example.wel.upkeep;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Activity_Add_Property extends AppCompatActivity {
    EditText edit_property_name,edit_total_room,edit_property_capacity,edit_address1,edit_address2,edit_state,edit_city,edit_postcode;
    TextView text_btnadd_property,text_addprop;
    ImageView image_down2,image_down1,image_headaddprop;
    Spinner spinner,spinner1;
    LinearLayout lin_img_add;
    RelativeLayout relative1,relative2,relative3,relative,relative4;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add__property);

        edit_property_name=(EditText)findViewById(R.id.edit_property_name);
        edit_total_room=(EditText)findViewById(R.id.edit_total_room);
        edit_address1=(EditText)findViewById(R.id.edit_address1);
        edit_address2=(EditText)findViewById(R.id.edit_address2);
        edit_city=(EditText)findViewById(R.id.edit_city);
        edit_postcode=(EditText)findViewById(R.id.edit_postcode);

        text_btnadd_property=(TextView)findViewById(R.id.text_btnadd_property);
        text_addprop=(TextView)findViewById(R.id.text_addprop);

        image_headaddprop=(ImageView)findViewById(R.id.image_headaddprop);

        Typeface museosans3 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_semibold.ttf");   //Set Font Family
        text_addprop.setTypeface(museosans3);

        Typeface museosans4 = Typeface.createFromAsset(getResources().getAssets(), "fonts/nunito_regular.ttf");
        edit_property_name.setTypeface(museosans4);
        edit_total_room.setTypeface(museosans4);
        edit_address1.setTypeface(museosans4);
        edit_address2.setTypeface(museosans4);
        edit_city.setTypeface(museosans4);
        edit_postcode.setTypeface(museosans4);
        text_btnadd_property.setTypeface(museosans4);

        lin_img_add=(LinearLayout)findViewById(R.id.lin_img_add);

        relative1=(RelativeLayout)findViewById(R.id.relative1);

        relative2=(RelativeLayout)findViewById(R.id.relative2);

        relative3=(RelativeLayout)findViewById(R.id.relative3);
        relative=(RelativeLayout)findViewById(R.id.relative);
        relative4=(RelativeLayout)findViewById(R.id.relative4);

        spinner=(Spinner)findViewById(R.id.spinner);       //Spinner  use
        spinner1=(Spinner)findViewById(R.id.spinner1);

        List<String> list = new ArrayList<String>();
        list.add("Property Capacity");
        list.add("Property Capacity1");
        list.add("Property Capacity2");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.notifyDataSetChanged();
        spinner.setAdapter(dataAdapter);

        List<String> list1 = new ArrayList<String>();
        list1.add("State");
        list1.add("Sales");
        list1.add("Others");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter1.notifyDataSetChanged();
        spinner1.setAdapter(dataAdapter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) spinner.getSelectedView()).setTextColor(Color.GRAY);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) spinner1.getSelectedView()).setTextColor(Color.GRAY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        image_headaddprop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Add_Property.this,Activity_Get_Started.class);
                startActivity(intent);
            }
        });
        relative.setOnClickListener(new View.OnClickListener() {       //select image from gallery multiple imeges
            @Override
            public void onClick(View view) {                                                          //center_horizontal

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);


            }
        });
        text_btnadd_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Activity_Add_Property.this,My_Property_Activity.class);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.image_display1);
            ImageView imageView1 = (ImageView) findViewById(R.id.image_display2);
            ImageView imageView2 = (ImageView) findViewById(R.id.image_display3);
            ImageView imageView3 = (ImageView) findViewById(R.id.image_display4);
            Bitmap bmp = null;
            try {
                bmp = getBitmapFromUri(selectedImage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (relative1.getVisibility() == View.VISIBLE) {
                // Its visible
                if (relative2.getVisibility() == View.VISIBLE) {
                    // Its visible
                    if (relative3.getVisibility() == View.VISIBLE) {
                        // Its visible
                    if (relative4.getVisibility()==View.VISIBLE) {
                    }
                    else
                        {
                            relative4.setVisibility(View.VISIBLE);
                            imageView3.setImageBitmap(bmp);
                            relative.setVisibility(View.GONE);
                            }
                        }
                    else {
                        relative3.setVisibility(View.VISIBLE);
                        imageView2.setImageBitmap(bmp);
                    }
                }
                else {
                    relative2.setVisibility(View.VISIBLE);
                    imageView1.setImageBitmap(bmp);
                }
            }
            else
                {
                relative1.setVisibility(View.VISIBLE);
                    imageView.setImageBitmap(bmp);
            }

         }


    }



    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }


}

