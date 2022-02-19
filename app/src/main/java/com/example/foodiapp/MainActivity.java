package com.example.foodiapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.foodiapp.Fragments.PatientRecipies;
import com.example.foodiapp.Fragments.RandomRecipies;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager FM;
    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle;

                toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        FM = getSupportFragmentManager();


        if (savedInstanceState == null) {
            FM.beginTransaction().setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, RandomRecipies.class, null)
                    .commit();
        }
        navigationView.setCheckedItem(R.id.home);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_home:

            FM.beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, RandomRecipies.class, null)
                    .commit();
                break;
            case R.id.pr:
                FM.beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, PatientRecipies.class, null)
                        .commit();
                break;
            case R.id.res:
                Toast.makeText(this, "Resturants", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user:
                Toast.makeText(this, "User", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;

        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }


}