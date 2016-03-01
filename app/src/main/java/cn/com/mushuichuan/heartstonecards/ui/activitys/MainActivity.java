package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.ui.fragments.ListFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.menu_classses);
        showFragment(new ListFragment());
        setTitle(R.string.menu_classses);
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
        int id = item.getItemId();
        ListFragment fragment = new ListFragment();
        int type = ListFragment.KEY_CLASSES;
        if (id == R.id.menu_classses) {
            type = ListFragment.KEY_CLASSES;
            setTitle(R.string.menu_classses);
        } else if (id == R.id.menu_factions) {
            type = ListFragment.KEY_FACTIONS;
            setTitle(R.string.menu_factions);
        } else if (id == R.id.menu_qualities) {
            type = ListFragment.KEY_QUALITIES;
            setTitle(R.string.menu_qualities);
        } else if (id == R.id.menu_races) {
            type = ListFragment.KEY_RACES;
            setTitle(R.string.menu_races);
        } else if (id == R.id.menu_sets) {
            type = ListFragment.KEY_SETS;
            setTitle(R.string.menu_sets);
        } else if (id == R.id.menu_types) {
            type = ListFragment.KEY_TYPES;
            setTitle(R.string.menu_types);
        }
        Bundle data = new Bundle();
        data.putInt(ListFragment.MENU_KEY, type);
        fragment.setArguments(data);
        showFragment(fragment);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void showFragment(Fragment f) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction addTransaction = manager.beginTransaction();
        addTransaction.replace(R.id.body, f);
        addTransaction.commit();
        mPresenter.getInfo();
    }
}
