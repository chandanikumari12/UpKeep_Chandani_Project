package com.example.wel.upkeep.Tenant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wel.upkeep.Adapter.Connect_landlord_adapter;
import com.example.wel.upkeep.Adapter.Movie;
import com.example.wel.upkeep.Adapter.MoviesAdapter;
import com.example.wel.upkeep.R;

import java.util.ArrayList;
import java.util.List;

public class Connect_Landlord_Activity extends AppCompatActivity {

        private List<Movie> movieList = new ArrayList<>();
        private RecyclerView recyclerView;
        private Connect_landlord_adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect__landlord_);

        recyclerView = (RecyclerView) findViewById(R.id.list_recycle);
        /*Movie movie = new Movie("sret223343","sret223343","sret223343");
        movieList.add(movie); movie = new Movie("sret223343","sret223343","sret223343");
        movieList.add(movie); movie = new Movie("sret223343","sret223343","sret223343");
        movieList.add(movie); movie = new Movie("sret223343","sret223343","sret223343");
        movieList.add(movie); movie = new Movie("sret223343","sret223343","sret223343");
        movieList.add(movie); movie = new Movie("sret223343","sret223343","sret223343");
        movieList.add(movie);*/

        int i;
        for(i=0; i<=10; i++)
        {
         Movie movie = new Movie("sret223343","sret223343","sret223343");
            movieList.add(movie);
        }


        mAdapter = new Connect_landlord_adapter(movieList);
       RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    }

