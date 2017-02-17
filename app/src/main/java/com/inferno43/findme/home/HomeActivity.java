package com.inferno43.findme.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.inferno43.findme.BaseActivity;
import com.inferno43.findme.R;
import com.inferno43.findme.dagger.Injector;
import com.inferno43.findme.view.ArcLayout;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Inject HomePresenter homePresenter;
    Context context;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    private ArcLayout concaveArc;
    private ImageView navButton;
    private TextView title;
    private ImageView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        concaveArc = (ArcLayout) findViewById(R.id.concaveArc);
        navButton = (ImageView) findViewById(R.id.nav);
        title = (TextView) findViewById(R.id.title);
        menu = (ImageView) findViewById(R.id.menu);
        enableToolBar(true);



        concaveArc.getSettings().setArcHeight(48);
        concaveArc.getSettings().setElevation(10);
        HomeFragment homeFragment = new HomeFragment();

        if (homeFragment != null ) {
            replaceFragment(getSupportFragmentManager(),homeFragment, false, null);
            new Injector(homeFragment).getHomeComponent().injectHomePresenter(this);
        }
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer.openDrawer(Gravity.LEFT,true);
                //drawer.addDrawerListener(toggle);
                //toggle.syncState();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        homePresenter.start();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
