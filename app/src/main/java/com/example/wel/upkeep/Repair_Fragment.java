package com.example.wel.upkeep;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wel.upkeep.repair_adapter.Item;
import com.example.wel.upkeep.repair_adapter.SelectableAdapterMessage;
import com.example.wel.upkeep.repair_adapter.SelectableItemMessage;
import com.example.wel.upkeep.repair_adapter.SelectableViewHolderMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Repair_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Repair_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Repair_Fragment extends Fragment implements SelectableViewHolderMessage.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String id_value_messg;

    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerview;
    SelectableAdapterMessage selectableAdapterMessage;
    List<Item> selectableItems = new ArrayList<>();
    public Repair_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Repair_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Repair_Fragment newInstance(String param1, String param2) {
        Repair_Fragment fragment = new Repair_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.repair_fragment, container, false);
        recyclerview = (RecyclerView)rootview.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager recylerviewmanager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(recylerviewmanager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        selectableAdapterMessage = new SelectableAdapterMessage(this,selectableItems,false);
        //recylerview.setAdapter(seleectableAdapter);

        for(int i = 0 ;i<7;i++)
        {
            Item item = new Item("id"+i, "message"+i, "createdon"+i,"isread"+i,"video"+i,getString(R.string.repair_text));
            if(!(selectableItems.contains(item)))
            {
                selectableItems.add(item);
            }
        }
        selectableAdapterMessage.notifyDataSetChanged();
        set_message_group();
        return rootview;
    }

    private void set_message_group() {
        selectableAdapterMessage = new SelectableAdapterMessage(this,selectableItems,false);
        Log.i("response","ssselectableItems "+selectableItems);
        recyclerview.setAdapter(selectableAdapterMessage);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(SelectableItemMessage item) {
        String id_value =  item.getName();
        Log.i("id_value_mesg","id "+id_value+" "+id_value_messg);
        if(id_value.equalsIgnoreCase(id_value_messg))
        {
            id_value_messg ="";

        }
        else
        {
            id_value_messg = id_value;
            set_message_group();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
