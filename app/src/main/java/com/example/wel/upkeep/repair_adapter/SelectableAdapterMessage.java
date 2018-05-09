package com.example.wel.upkeep.repair_adapter;


import android.app.Activity;
import android.app.Dialog;
import android.app.MediaRouteButton;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.wel.upkeep.Message1;
import com.example.wel.upkeep.R;
import com.example.wel.upkeep.Repair_COntact_listActivity;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 103 on 11/21/2017.
 */

public class SelectableAdapterMessage extends RecyclerView.Adapter implements SelectableViewHolderMessage.OnItemSelectedListener
{
    private final List<SelectableItemMessage> mValues;
    private boolean isMultiSelectionEnabled = false;
    SelectableViewHolderMessage.OnItemSelectedListener listener;
    Context context;
    ImageView message_image,close_image;

    public SelectableAdapterMessage(SelectableViewHolderMessage.OnItemSelectedListener listener,
                                    List<Item> items, boolean isMultiSelectionEnabled)
    {
        this.listener = listener;
        this.isMultiSelectionEnabled = isMultiSelectionEnabled;
        mValues = new ArrayList<>();
        for (Item item : items)
        {
            mValues.add(new SelectableItemMessage(item, false));
        }
    }


    @Override
    public SelectableViewHolderMessage onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_message, parent, false);
        context = parent.getContext();
        return new SelectableViewHolderMessage(itemView, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {
        SelectableViewHolderMessage holder = (SelectableViewHolderMessage) viewHolder;
        SelectableItemMessage selectableItem = mValues.get(position);
        holder.mItem = selectableItem;
        holder.ismessage_new.setText(selectableItem.getType());

        if(selectableItem.getRepair_type().equals("repair_fragment"))
        {
            holder.message_image.setVisibility(View.GONE);
            holder.call_image.setVisibility(View.GONE);
        }
        else  if(selectableItem.getRepair_type().equals("add_repair"))
        {
            holder.close_image.setVisibility(View.GONE);
            holder.message_image.setVisibility(View.VISIBLE);
            holder.call_image.setVisibility(View.VISIBLE);

        }

        else  if(selectableItem.getRepair_type().equals("My_Property_Activity"))
        {
            holder.close_image.setVisibility(View.GONE);
            holder.message_image.setVisibility(View.GONE);
            holder.call_image.setVisibility(View.GONE);
        }

        holder.setChecked(holder.mItem.isSelected());
        holder.tenant_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                popup_for_repair();
            }
        });

        holder.landlord_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                popup_for_tenant();
            }
        });
    }

    private void popup_for_tenant()
    {
        final Dialog dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_tenant_repair);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        List<Message1> message1List = new ArrayList<>();
        Recycler_Repair_contact recycler_repair_contact_adapter = new Recycler_Repair_contact(context,message1List);
        RecyclerView recyclerview = (RecyclerView)dialog.findViewById(R.id.recyclerview);
        ImageView close_icon = (ImageView)dialog.findViewById(R.id.close_icon);
        close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        for(int i =0;i<5 ;i++)
        {
            Message1 Message1 = new Message1("1", "2","3","4","last");
            message1List.add(Message1);
        }
        recyclerview.setAdapter(recycler_repair_contact_adapter);
        dialog.show();
    }

    private void popup_for_repair()
    {
        final Dialog dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_tenant_landlord);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        final RecyclerView recyclerview = (RecyclerView)dialog.findViewById(R.id.recyclerview);
        ImageView close_icon = (ImageView)dialog.findViewById(R.id.close_icon);
        final ImageView repair_image = (ImageView)dialog.findViewById(R.id.repair_image);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        final List<Message1> message1List = new ArrayList<>();
        final Recycler_LandLoard_Contact recycler_landLoard_contact = new Recycler_LandLoard_Contact(context,message1List);
        close_icon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
            }
        });

        repair_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 1;i<5 ;i++)
                {
                    Message1 Message1 = new Message1("1", "2","3","4","last");
                    message1List.add(Message1);
                }
                recyclerview.setAdapter(recycler_landLoard_contact);
                repair_image.setVisibility(View.GONE);
            }
        });

        for(int i =0;i<1 ;i++)
        {
            Message1 Message1 = new Message1("1", "2","3","4","last");
            message1List.add(Message1);
        }
        recyclerview.setAdapter(recycler_landLoard_contact);
        dialog.show();
    }

    @Override
    public int getItemCount()
    {
        return mValues.size();
    }

    public List<Item> getSelectedItems()
    {
        List<Item> selectedItems = new ArrayList<>();
        for (SelectableItemMessage item : mValues)
        {
            if (item.isSelected())
            {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }

    @Override
    public int getItemViewType(int position)
    {
        if(isMultiSelectionEnabled)
        {
            return SelectableViewHolderMessage.MULTI_SELECTION;
        }
        else
        {
            return SelectableViewHolderMessage.SINGLE_SELECTION;
        }
    }

    @Override
    public void onItemSelected(SelectableItemMessage item)
    {
        if (!isMultiSelectionEnabled)
        {
            for (SelectableItemMessage selectableItem : mValues)
            {
                if (!selectableItem.equals(item) && selectableItem.isSelected())
                {
                    selectableItem.setSelected(false);
                }
                else if (selectableItem.equals(item) && item.isSelected())
                {
                    selectableItem.setSelected(true);
                }
            }
            notifyDataSetChanged();
        }
        listener.onItemSelected(item);
    }
}