package com.example.wel.upkeep;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wel.upkeep.Adapter.Banking_Adapter;
import com.example.wel.upkeep.dummy.DummyContent;
import com.example.wel.upkeep.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class Banking_Fragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Banking_Fragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static Banking_Fragment newInstance(int columnCount) {
        Banking_Fragment fragment = new Banking_Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banking_, container, false);
    Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_banking);
        // Set the adapter
       /* if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }*/
         List<Message1> message1List = new java.util.ArrayList<>();
       Banking_Adapter banking_adapter = new Banking_Adapter(context, message1List) {
       };

            for(int i = 1;i<5 ;i++)
                {
                    Message1 Message1 = new Message1("1", "2","3","4","last");
                    message1List.add(Message1);
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new android.support.v7.widget.DefaultItemAnimator());

            recyclerView.setAdapter(banking_adapter);

        return view;
    }



    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
