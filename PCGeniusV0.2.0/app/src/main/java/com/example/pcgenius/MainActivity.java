package com.example.pcgenius;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import android.view.Menu;
import android.widget.FrameLayout;


import com.example.pcgenius.ui.builds.BuildsFragment;
import com.example.pcgenius.ui.home.HomeFragment;
import com.example.pcgenius.ui.parts.PartsFragment;
import com.example.pcgenius.ui.search.SearchFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    public static String Sortby="";
    public static boolean darkTheme=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Log.i("test1","working");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {
        Fragment fragment = null;

        switch (itemId) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_builds:
                fragment = new BuildsFragment();
                Log.i("nav_builds","worked");
                break;
            case R.id.nav_parts:
                fragment = new PartsFragment();
                Log.i("nav_parts","worked");
                break;
            case R.id.nav_search:
                fragment = new SearchFragment();
                Log.i("nav_search","worked");
                break;


        }
        //replacing the fragment
        if (fragment != null) {
            FrameLayout fl = findViewById(R.id.nav_host_fragment);
            fl.removeAllViews();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //calling the method displayselectedscreen and passing the id of selected menu
            displaySelectedScreen(menuItem.getItemId());
            Log.i("onnavigationitemselect","working");
            //make this method blank
            return true;

    }
}
