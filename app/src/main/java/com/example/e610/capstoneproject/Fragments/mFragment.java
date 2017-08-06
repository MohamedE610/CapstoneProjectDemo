package com.example.e610.capstoneproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e610.capstoneproject.Activitys.LoginActivity;
import com.exampleAnime.e610.capstoneproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E610 on 8/6/2017.
 */
public class mFragment extends Fragment implements  TabLayout.OnTabSelectedListener
        , NavigationView.OnNavigationItemSelectedListener{



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view=inflater.inflate(R.layout.activity_navigation_drawer,container,false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity appCompatActivity=(AppCompatActivity)getActivity();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appCompatActivity.setSupportActionBar(toolbar);


        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                }
            }
        };


        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager,0);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);


        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            //Toast.makeText(MainActivity.this," ^__^ " + id,Toast.LENGTH_SHORT).show();
            displaySelectedScreen(id);

        } else if (id == R.id.nav_gallery) {
            //Toast.makeText(MainActivity.this," ^__^ " + id,Toast.LENGTH_SHORT).show();
            displaySelectedScreen(id);
        } else if (id == R.id.nav_share) {
            //Toast.makeText(MainActivity.this," ^__^ " + id,Toast.LENGTH_SHORT).show();
            signOut();
        }
        else if (id == R.id.fav_ani) {
            //Toast.makeText(MainActivity.this," ^__^ " + id,Toast.LENGTH_SHORT).show();
            displaySelectedScreen(id);
            //  reStartLoader.restartLoader();
//            String s=getFavouriteMovies(id);
            //  Toast.makeText(MainActivity.this, s ,Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.fav_man) {
           // Toast.makeText(MainActivity.this," ^__^ " + id,Toast.LENGTH_SHORT).show();
            // String s=getFavouriteMovies(id);
            // Toast.makeText(MainActivity.this, s ,Toast.LENGTH_SHORT).show();

        }



        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_camera:
                setupViewPager(viewPager,0);
                break;
            case R.id.nav_gallery:
                setupViewPager(viewPager,1);
                break;
            case R.id.fav_ani:
                setupViewPager(viewPager,2);
                break;
        }
        //replacing the fragment
        if (fragment != null) {
            /*viewPager.setVisibility(View.GONE);
            frameLayout.setVisibility(View.VISIBLE);*/
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_, fragment);
            ft.commit();
        }
       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
    }



    private void setupViewPager(ViewPager viewPager ,int i) {
        if(i==0) {

            ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

            //Most Popular Anime
            AnimeMainFragment animeMainFragment =new AnimeMainFragment();
            animeMainFragment.setUrl("https://kitsu.io/api/edge/anime?sort=popularityRank&page[limit]=20&page[offset]=0");

            //Top Upcoming Anime
            AnimeMainFragment animeMainFragment1 =new AnimeMainFragment();
            animeMainFragment1.setUrl("https://kitsu.io/api/edge/anime?sort=popularityRank&filter[status]=upcoming&page[limit]=20&page[offset]=0");

            //Top Airing Anime
            AnimeMainFragment animeMainFragment2 =new AnimeMainFragment();
            animeMainFragment2.setUrl("https://kitsu.io/api/edge/anime?sort=popularityRank,-averageRating&filter[status]=current&page[limit]=20&page[offset]=0");

            //Highest Rated Anime
            AnimeMainFragment animeMainFragment3 =new AnimeMainFragment();
            animeMainFragment3.setUrl("https://kitsu.io/api/edge/anime?sort=-averageRating&page[limit]=20&page[offset]=0");


            adapter.addFragment(animeMainFragment, "Most Popular");
            adapter.addFragment(animeMainFragment1, "Top Upcoming");
            adapter.addFragment(animeMainFragment2, "Top Airing");
            adapter.addFragment(animeMainFragment3, "Highest Rated");
            viewPager.setAdapter(adapter);
        }
        else if(i==1){

            ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

            //Most Popular Manga
            MangaMainFragment mangaMainFragment =new MangaMainFragment();
            mangaMainFragment.setUrl("https://kitsu.io/api/edge/manga?sort=popularityRank&page[limit]=20&page[offset]=0");

            //Highest Rated Manga
            MangaMainFragment mangaMainFragment1 =new MangaMainFragment();
            mangaMainFragment1.setUrl("https://kitsu.io/api/edge/manga?sort=-averageRating&page[limit]=20&page[offset]=0");

            //Top Upcoming Manga
            MangaMainFragment mangaMainFragment2 =new MangaMainFragment();
            mangaMainFragment2.setUrl("https://kitsu.io/api/edge/manga?sort=popularityRank&filter[status]=upcoming&page[limit]=20&page[offset]=0");

            //Top Publishing Manga
            MangaMainFragment mangaMainFragment3 =new MangaMainFragment();
            mangaMainFragment3.setUrl("https://kitsu.io/api/edge/manga?sort=-userCount&filter[status]=current&page[limit]=20&page[offset]=0");

            adapter.addFragment(mangaMainFragment, "Most Popular");
            adapter.addFragment(mangaMainFragment1, "Highest Rated");
            adapter.addFragment(mangaMainFragment2, "Top Upcoming");
            adapter.addFragment(mangaMainFragment3, "Top Publishing");
            viewPager.setAdapter(adapter);
        }
        else if(i==2){

            //ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

            FavouriteFragment favouriteFragment=new FavouriteFragment();
            FavouriteFragment favouriteFragment1=new FavouriteFragment();

            adapter.addFragment(favouriteFragment, "Most");
            adapter.addFragment(favouriteFragment1, "Highest");
            viewPager.setAdapter(adapter);
            //viewPager.setOffscreenPageLimit(2);
        }
    }


    /*
    class ViewPagerAdapter extends FragmentPagerAdapter {
        this line cause logic error "display fragments in view pager when i reset it in wrong way"
        */

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    //sign out method
    public void signOut() {
        auth.signOut();
        startActivity(new Intent(getActivity(),LoginActivity.class));
        getActivity().finish();
    }}
