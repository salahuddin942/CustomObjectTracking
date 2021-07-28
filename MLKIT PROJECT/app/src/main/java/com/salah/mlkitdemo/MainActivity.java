package com.salah.mlkitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import com.salah.mlkitdemo.CustomModelDetection.CustomModelDetectionActivity;


import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static DrawerLayout drawerLayout;
    private static ActionBarDrawerToggle actionBarDrawerToggle;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigationDrawer();
    }

    private void initNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener((MenuItem menuItem) -> {
                    int id = menuItem.getItemId();
                    switch (id) {



                        case R.id.object_detection_local_video:
                            switchActivity(CustomModelDetectionActivity.class);
                            return true;
                        default:
                            return false;
                    }
                }
        );
    }

    private void switchActivity(Class c) {
        Intent intent = new Intent(this, c);
        this.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}