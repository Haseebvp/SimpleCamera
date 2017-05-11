package com.galleryapp.galleryapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import fragments.CameraFragment;
import fragments.GridFragment;

public class HomePage extends AppCompatActivity {
    Toolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
               StartCamera();

            }
        });
        StartGrid();
    }

    private void StartGrid(){
        toolbar.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rootlayout, GridFragment.newInstance(), "Grid")
                .commit();
    }

    private void StartCamera(){
        toolbar.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rootlayout, CameraFragment.newInstance(), "Camera")
                .addToBackStack("Grid")
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        toolbar.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
    }


}
