package com.example.e610.capstoneproject;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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
        DetailedFragment detailedFragment=new DetailedFragment();
        detailedFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.asd,detailedFragment).commit();
    }
}
