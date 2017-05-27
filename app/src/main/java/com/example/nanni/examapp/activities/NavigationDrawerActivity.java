package com.example.nanni.examapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nanni.examapp.R;
import com.example.nanni.examapp.adapters.SideMenuBaseAdapter;

public class NavigationDrawerActivity extends AppCompatActivity {
ListView mSideMenuList;
    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    TextView mToolBarTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        initView();
    }

    private void initView() {
        mSideMenuList=(ListView)findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_drawerLayout);

        setupToolbar();
        mSideMenuList.setAdapter(new SideMenuBaseAdapter());


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        mSideMenuList.setOnItemClickListener(new DrawerItemClickListener());

    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
            mDrawerLayout.closeDrawers();

        }

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();

    }
    void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolBarTitle=(TextView)findViewById(R.id.tv_toolbarTitle);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void selectItem(int position) {

        Fragment fragment=null;
        switch (position) {
            case 0:
               // fragment = new ConnectFragment();
                break;
            case 1:
                //fragment = new FixturesFragment();
                break;
            case 2:
               // fragment = new TableFragment();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mSideMenuList.setItemChecked(position, true);
            mSideMenuList.setSelection(position);
            mDrawerLayout.closeDrawer(mSideMenuList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
