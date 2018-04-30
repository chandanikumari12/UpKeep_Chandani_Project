package com.example.wel.upkeep.repair_adapter;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
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


import com.example.wel.upkeep.R;

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
        holder.setChecked(holder.mItem.isSelected());
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