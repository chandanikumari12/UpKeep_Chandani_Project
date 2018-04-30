
package com.example.wel.upkeep.Adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wel.upkeep.DataObject;
import com.example.wel.upkeep.Home_Activity;
import com.example.wel.upkeep.R;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView
        .Adapter<RecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<DataObject> mDataset;
    static  Context context;
    private static MyClickListener myClickListener;
    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;

        public DataObjectHolder(final View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.text_string);
            Log.i(LOG_TAG, "Adding Listener");

            label.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dtr = label.getText().toString();
                    Toast.makeText(context,"you click here",Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View v) {
            //myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_textview, parent, false);
         context = parent.getContext();
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.label.setText(mDataset.get(position).getmText1());
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}



