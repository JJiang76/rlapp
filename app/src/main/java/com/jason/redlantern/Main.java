package com.jason.redlantern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    //FirebaseDatabase database;
    //DatabaseReference category;

    TextView headerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        boolean loggedin = intent.getBooleanExtra(Login.LOGIN_BOOL, false);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //database = FirebaseDatabase.getInstance();
        //category = database.getReference("Category");



        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }


        View headerView = navigationView.getHeaderView(0);
        headerName = headerView.findViewById(R.id.header_name);


        //headerName.setText(Common.currentUser.getName());


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit(); break;

            case R.id.nav_restaurant_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMenu()).commit(); break;

            case R.id.nav_order: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentOrder()).commit(); break;

            case R.id.nav_reservations: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentReservations()).commit(); break;

            case R.id.nav_contact: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentContact()).commit(); break;

            case R.id.nav_account:
                Intent launcher = new Intent(Main.this, Launcher.class);
                startActivity(launcher);

                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
