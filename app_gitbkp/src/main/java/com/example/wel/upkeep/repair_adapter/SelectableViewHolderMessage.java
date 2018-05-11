package com.example.wel.upkeep.repair_adapter;

import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wel.upkeep.Activity_Get_Started;
import com.example.wel.upkeep.R;


/**
 * Created by 103 on 12/21/2017.
 */


/**
 * Created by 103 on 11/21/2017.
 */

public class SelectableViewHolderMessage extends RecyclerView.ViewHolder
{
    public static final int MULTI_SELECTION = 2;
    public static final int SINGLE_SELECTION = 1;
    //CheckedTextView textView;

  /*  RadioButton textView;
    ImageView group_image;

    TextView checked_groupname;
    LinearLayout linearlayout;*/
  SelectableItemMessage mItem;


    TextView ismessage_new;
    LinearLayout linear_members,messgae_linear,linear_layout;
    ImageView world_image,close_image;

    OnItemSelectedListener itemSelectedListener;
    public ImageView message_image,back_image_button;
    public ImageView call_image;
    public ImageView tenant_image;
    public ImageView landlord_image;
    public ImageView cross_image;
    private Item selectableItem;

    public SelectableViewHolderMessage(View view, OnItemSelectedListener listener)
    {
        super(view);
        itemSelectedListener = listener;
        //textView = (CheckedTextView) view.findViewById(R.id.checked_text_item);


        ismessage_new = (TextView) view.findViewById(R.id.ismessage_new);

        world_image = (ImageView) view.findViewById(R.id.world_image);
        call_image = (ImageView) view.findViewById(R.id.call_image);
        message_image = (ImageView) view.findViewById(R.id.message_image);
        close_image = (ImageView) view.findViewById(R.id.cross_image);
        linear_members = (LinearLayout) view.findViewById(R.id.linear_members);
        messgae_linear = (LinearLayout) view.findViewById(R.id.messgae_linear);
        linear_layout = (LinearLayout) view.findViewById(R.id.linear_layout);
        tenant_image=(ImageView)view.findViewById(R.id.tenant_image);
        landlord_image=(ImageView)view.findViewById(R.id.landlord_image);
        back_image_button=(ImageView)view.findViewById(R.id.back_image_button);

        linear_members.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("isnewmessage","isclick");
                if (mItem.isSelected() && getItemViewType() == MULTI_SELECTION)
                {
                    setChecked(false);
                }
                else
                {
                    setChecked(true);
                }
                itemSelectedListener.onItemSelected(mItem);
            }
        });
    }

    public void setChecked(boolean value)
    {
        if (mItem.getRepair_type().equals("add_repair")){
            close_image.setImageResource(R.mipmap.white_arrow_close);
            messgae_linear.setVisibility(View.GONE);
        }
          else{
        if (value)
        {
            messgae_linear.setVisibility(View.VISIBLE);
            close_image.setImageResource(R.mipmap.white_arrow_open);
           // linear_layout.setPadding(10,10,0,0);
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            {
                close_image.setImageResource(R.mipmap.white_arrow_close);
                messgae_linear.setVisibility(View.GONE);
                //linear_layout.setPadding(0,15,0,15);
            }
        }
        }
        mItem.setSelected(value);
        //textView.setChecked(value);
    }

    public interface OnItemSelectedListener
    {
        void onItemSelected(SelectableItemMessage item);
    }
}