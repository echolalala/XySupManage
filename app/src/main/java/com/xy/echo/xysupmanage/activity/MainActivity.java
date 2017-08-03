package com.xy.echo.xysupmanage.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.xy.echo.xysupmanage.fragment.OrderFragment;
import com.xy.echo.xysupmanage.fragment.ProfitFragment;
import com.xy.echo.xysupmanage.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private OrderFragment orderFragment;
    private ProfitFragment profitFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();

        if (id == R.id.nav_camera) {
            hideFragement(fragmentTransaction);
            if(orderFragment==null){
                orderFragment=new OrderFragment();
                fragmentTransaction.add(R.id.frame_main,orderFragment);
            }else{
                fragmentTransaction.show(orderFragment);
            }


        } else if (id == R.id.nav_gallery) {
            hideFragement(fragmentTransaction);
            if(profitFragment==null){
                profitFragment=new ProfitFragment();
                fragmentTransaction.add(R.id.frame_main,profitFragment);
            }else{
                fragmentTransaction.show(profitFragment);
            }



        } else if (id == R.id.nav_slideshow) {
            hideFragement(fragmentTransaction);
        } else if (id == R.id.nav_manage) {
            hideFragement(fragmentTransaction);
        } else if (id == R.id.nav_share) {
            hideFragement(fragmentTransaction);
        } else if (id == R.id.nav_send) {
            hideFragement(fragmentTransaction);
        }

        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private  void  hideFragement(FragmentTransaction fragmentTransaction){
        if(orderFragment!=null){
            fragmentTransaction.hide(orderFragment);
        }
        if(profitFragment!=null){
            fragmentTransaction.hide(profitFragment);
        }
    }
}
