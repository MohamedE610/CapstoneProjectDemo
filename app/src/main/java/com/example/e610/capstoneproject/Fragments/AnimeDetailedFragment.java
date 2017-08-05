package com.example.e610.capstoneproject.Fragments;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e610.capstoneproject.Data.AnimeContract;
import com.example.e610.capstoneproject.Models.Anime.Attributes;
import com.example.e610.capstoneproject.Models.Anime.Datum;
import com.exampleAnime.e610.capstoneproject.R;
import com.google.gson.Gson;


/**
 * Created by E610 on 8/3/2017.
 */
public class AnimeDetailedFragment extends Fragment {

    Datum anime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view =inflater.inflate(R.layout.fragment_detailed,container,false);

        TextView textView1=(TextView)view.findViewById(R.id.story);
        TextView textView2=(TextView)view.findViewById(R.id.rating);
        TextView textView3=(TextView)view.findViewById(R.id.charaters);
        TextView textView4=(TextView)view.findViewById(R.id.links);

        Bundle bundle=getArguments();
        anime=(Datum) bundle.getSerializable("dat");
        textView1.setText("No Story available Now");
        //textView2.setText(String.valueOf(attributes.ratingRank));
        textView2.setText("1");
        textView3.setText("Person X \n Person Y \n Person Z");
        textView4.setText("NO Links Available");

        ImageView imageView=(ImageView)view.findViewById(R.id.img1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                markAsFavorite();
            }
        });

        return view;
    }

    public void markAsFavorite() {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                    ContentValues movieValues = new ContentValues();
                    movieValues.put(AnimeContract.FavouriteAnimeEntry.COLUMN_anime_ID,
                            anime.id);
                      Gson gson=new Gson();
                      String jsonAnime=gson.toJson(anime);
                     movieValues.put(AnimeContract.FavouriteAnimeEntry.COLUMN_anime_content,
                            jsonAnime);

                    getActivity().getContentResolver().insert(
                            AnimeContract.FavouriteAnimeEntry.CONTENT_URI,
                            movieValues
                    );

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Toast.makeText(getContext(),"Anime Saved",Toast.LENGTH_SHORT).show();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}
 /*public void markAsFavorite() {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                if (!isFavorite()) {
                    ContentValues movieValues = new ContentValues();
                    movieValues.put(SeriesContract.SeriesEntry.COLUMN_SERIES_ID,
                            seriesModel.getId());
                    movieValues.put(SeriesContract.SeriesEntry.COLUMN_SERIES_TITLE,
                            seriesModel.getTitle());
                    movieValues.put(SeriesContract.SeriesEntry.COLUMN_SERIES_POSTER_PATH,
                            seriesModel.getPoster_ImageUrl());
                    movieValues.put(SeriesContract.SeriesEntry.COLUMN_SERIES_OVERVIEW,
                            seriesModel.getOverview());
                    movieValues.put(SeriesContract.SeriesEntry.COLUMN_SERIES_VOTE_AVERAGE,
                            seriesModel.getVote_average());
                    movieValues.put(SeriesContract.SeriesEntry.COLUMN_SERIES_RELEASE_DATE,
                            seriesModel.getRelease_Date());

                    getActivity().getContentResolver().insert(
                            SeriesContract.SeriesEntry.CONTENT_URI,
                            movieValues
                    );
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Favourite.setImageResource(R.drawable.staron);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void removeFromFavorites() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                if (isFavorite()) {
                    getActivity().getContentResolver().delete(SeriesContract.SeriesEntry.CONTENT_URI,
                            SeriesContract.SeriesEntry.COLUMN_SERIES_ID + " = " + seriesModel.getId(), null);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Favourite.setImageResource(R.drawable.staroff);

            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    private boolean isFavorite() {
        Cursor movieCursor = getActivity().getContentResolver().query(
                SeriesContract.SeriesEntry.CONTENT_URI,
                new String[]{SeriesContract.SeriesEntry.COLUMN_SERIES_ID},
                SeriesContract.SeriesEntry.COLUMN_SERIES_ID + " = " + seriesModel.getId(),
                null,
                null);

        if (movieCursor != null && movieCursor.moveToFirst()) {
            movieCursor.close();
            return true;
        } else {
            return false;
        }
    }
*/