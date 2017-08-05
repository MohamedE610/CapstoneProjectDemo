package com.example.e610.capstoneproject.Fragments;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e610.capstoneproject.Activitys.MainActivity;
import com.example.e610.capstoneproject.Adapters.AnimeAdapter;
import com.example.e610.capstoneproject.Activitys.DetailedActivity;
import com.example.e610.capstoneproject.Adapters.MangaAdapter;
import com.example.e610.capstoneproject.Data.AnimeContract;
import com.example.e610.capstoneproject.Models.Anime.Attributes;
import com.example.e610.capstoneproject.Models.Anime.Datum;
import com.example.e610.capstoneproject.Models.Anime.ExampleAnime;
import com.example.e610.capstoneproject.Utils.NetworkResponse;
import com.exampleAnime.e610.capstoneproject.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Berlin on 8/2/2017.
 */

public class FavouriteFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>,
        AnimeAdapter.RecyclerViewClickListener  {

    RecyclerView recyclerView;
    ExampleAnime exampleAnime;
    AnimeAdapter animeAdapter;
    View view;
    private String target;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    StaggeredGridLayoutManager sglm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_two, container, false);

        return view;
    }



    @Override
    public void ItemClicked(View v, int position) {
        Bundle bundle = new Bundle();
        Toast.makeText(getContext(), "haha", Toast.LENGTH_SHORT).show();
        Datum anime = exampleAnime.data.get(position);
        bundle.putSerializable("dat", anime);
        bundle.putString("type", "anime");
        startActivity(new Intent(getActivity(), DetailedActivity.class).putExtra("data", bundle));
    }

    public static final int LOADER_ID = 101;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
      getLoaderManager().initLoader(LOADER_ID, null, this);
        //flag = 0;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), AnimeContract.FavouriteAnimeEntry.CONTENT_URI, null,
                null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, final Cursor data) {
        exampleAnime=new ExampleAnime();
        exampleAnime.data=new ArrayList<>();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                while (data.moveToNext()){
                    String animeJson=data.getString(AnimeContract.FavouriteAnimeEntry.COL_anime_content);
                    Gson gson=new Gson();
                    Datum anime =gson.fromJson(animeJson,Datum.class);
                    exampleAnime.data.add(anime);
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                animeAdapter=new AnimeAdapter(exampleAnime,getContext());
                animeAdapter.setClickListener((AnimeAdapter.RecyclerViewClickListener) f);
                recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
                sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
                recyclerView.setLayoutManager(sglm);
                recyclerView.setAdapter(animeAdapter);
                super.onPostExecute(aVoid);
            }

        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

   Fragment f=this;

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}

