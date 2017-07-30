package com.example.e610.capstoneproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.e610.capstoneproject.Adapters.RecipeAdapter;
import com.example.e610.capstoneproject.Models.Example;
import com.example.e610.capstoneproject.Utils.FetchData;
import com.example.e610.capstoneproject.Utils.NetworkResponse;
import com.example.e610.capstoneproject.Utils.NetworkState;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements NetworkResponse{

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(NetworkState.ConnectionAvailable(this)) {
            FetchData fetchData = new FetchData();
            fetchData.setNetworkResponse(this);
            fetchData.execute();
        }
    }

    @Override
    public void OnSuccess(String JsonData) {

        Gson gson = new Gson();
        Example example=gson.fromJson(JsonData, Example.class);

        RecipeAdapter adapter=new RecipeAdapter(example,this);
        StaggeredGridLayoutManager sglm =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(sglm);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnFailure(boolean Failure) {

    }
}
