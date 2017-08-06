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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e610.capstoneproject.Data.AnimeContract;
import com.example.e610.capstoneproject.Models.Anime.Datum;
import com.exampleAnime.e610.capstoneproject.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


/**
 * Created by E610 on 8/3/2017.
 */
public class AnimeDetailedFragment extends Fragment {

    Datum anime;
    ImageView cover;
    TextView title;
    TextView startDate;
    TextView rating;
    RatingBar ratingBar;
    ImageView favourite;
    ImageView startWatch;
    ImageView completed;
    TextView overview;
    TextView ageGuide;
    TextView status;
    TextView epNum;//append
    TextView epDuration;//append
    ImageView trailer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view =inflater.inflate(R.layout.fragment_anime_detail,container,false);

        title=(TextView)view.findViewById(R.id.title_txt);
        startDate=(TextView)view.findViewById(R.id.start_date_txt);
        rating=(TextView)view.findViewById(R.id.rating_txt);
        overview=(TextView)view.findViewById(R.id.overview);
        ageGuide=(TextView)view.findViewById(R.id.age_guide);
        status=(TextView)view.findViewById(R.id.status);
        epNum=(TextView)view.findViewById(R.id.ep_num);
        epDuration=(TextView)view.findViewById(R.id.ep_duration);

        ratingBar=(RatingBar)view.findViewById(R.id.rating_bar);

        cover=(ImageView)view.findViewById(R.id.cover);
        favourite=(ImageView)view.findViewById(R.id.favourite_img);
        completed=(ImageView)view.findViewById(R.id.completed_img);
        startWatch=(ImageView)view.findViewById(R.id.start_watch_img);

        Bundle bundle=getArguments();
        anime=(Datum) bundle.getSerializable("dat");

        title.setText(anime.attributes.canonicalTitle);
        startDate.setText(anime.attributes.startDate);
        overview.setText(anime.attributes.synopsis);
        ageGuide.setText(anime.attributes.ageRatingGuide);
        status.setText(anime.attributes.status);
        epNum.append(String.valueOf(anime.attributes.episodeCount));
        epDuration.append(String.valueOf(anime.attributes.episodeLength));

        ratingBar.setRating(Float.valueOf(anime.attributes.averageRating)/20);

        Picasso.with(getActivity()).load(anime.attributes.coverImage.original).placeholder(R.drawable.asd)
                .error(R.drawable.asd).into(cover);


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