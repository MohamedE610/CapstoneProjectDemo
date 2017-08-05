package com.example.e610.capstoneproject.Activitys;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.e610.capstoneproject.Fragments.AnimeDetailedFragment;
import com.example.e610.capstoneproject.Fragments.MangaDetailedFragment;
import com.exampleAnime.e610.capstoneproject.R;


public class DetailedActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();

        if(actionBar!=null)
             actionBar.setDisplayHomeAsUpEnabled(true);



        Bundle bundle=getIntent().getBundleExtra("data");
        String type=bundle.getString("type");
        if(type.equals("anime")) {
            AnimeDetailedFragment animeDetailedFragment = new AnimeDetailedFragment();
            animeDetailedFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.asd1, animeDetailedFragment).commit();
        }
        else {
            MangaDetailedFragment mangaDetailedFragment = new MangaDetailedFragment();
            mangaDetailedFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.asd1, mangaDetailedFragment).commit();
        }
    }
}
