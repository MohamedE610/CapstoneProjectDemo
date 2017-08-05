package com.example.e610.capstoneproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.e610.capstoneproject.Adapters.AnimeAdapter;
import com.example.e610.capstoneproject.Activitys.DetailedActivity;
import com.example.e610.capstoneproject.Models.Anime.Attributes;
import com.example.e610.capstoneproject.Models.Anime.Datum;
import com.example.e610.capstoneproject.Models.Anime.ExampleAnime;
import com.example.e610.capstoneproject.Utils.FetchData;
import com.example.e610.capstoneproject.Utils.NetworkResponse;
import com.example.e610.capstoneproject.Utils.NetworkState;
import com.exampleAnime.e610.capstoneproject.R;
import com.google.gson.Gson;

/**
 * Created by Berlin on 8/2/2017.
 */

public class AnimeMainFragment extends Fragment implements NetworkResponse , AnimeAdapter.RecyclerViewClickListener {

    RecyclerView recyclerView;
    ExampleAnime exampleAnime;
    String url;

    public AnimeMainFragment() {
        // Required empty public constructor
    }
    public void setUrl(String url){
        this.url=url;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_two, container, false);


        StaggeredGridLayoutManager sglm =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(sglm);

        if(NetworkState.ConnectionAvailable(getContext())) {
            FetchData fetchData = new FetchData(url);
            fetchData.setNetworkResponse(this);
            fetchData.execute();
        }


        return view;
    }

    @Override
    public void OnSuccess(String JsonData) {

        Gson gson = new Gson();
        exampleAnime =gson.fromJson(JsonData, ExampleAnime.class);

        AnimeAdapter adapter=new AnimeAdapter(exampleAnime,getContext());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnFailure(boolean Failure) {

    }

    @Override
    public void ItemClicked(View v, int position) {
        Bundle bundle=new Bundle();
        Toast.makeText(getContext(),"haha",Toast.LENGTH_SHORT).show();
        Datum anime= exampleAnime.data.get(position);
        bundle.putSerializable("dat",anime);
        bundle.putString("type","anime");
        startActivity(new Intent(getActivity(),DetailedActivity.class).putExtra("data",bundle));
    }

}

