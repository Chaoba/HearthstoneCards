package cn.com.mushuichuan.heartstonecards.ui.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import java.util.ArrayList;

import cn.com.mushuichuan.heartstonecards.R;
import cn.com.mushuichuan.heartstonecards.mvp.model.Info;
import cn.com.mushuichuan.heartstonecards.ui.fragments.ListFragment;

public class MainActivity extends BaseActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        mPresenter.getInfo();

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        ArrayList<ListFragment> list = new ArrayList<>(6);

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            for (int i = 0; i < 6; i++) {
                int type = ListFragment.KEY_CLASSES;
                switch (i) {
                    case 0:
                        type = ListFragment.KEY_CLASSES;
                        break;
                    case 1:
                        type = ListFragment.KEY_SETS;
                        break;
                    case 2:
                        type = ListFragment.KEY_TYPES;
                        break;
                    case 3:
                        type = ListFragment.KEY_FACTIONS;
                        break;
                    case 4:
                        type = ListFragment.KEY_QUALITIES;
                        break;
                    case 5:
                        type = ListFragment.KEY_RACES;
                        break;
                }
                ListFragment fragment = new ListFragment();
                Bundle data = new Bundle();
                data.putInt(ListFragment.MENU_KEY, type);
                fragment.setArguments(data);
                list.add(fragment);
            }
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.menu_classses);
                case 1:
                    return getString(R.string.menu_sets);
                case 2:
                    return getString(R.string.menu_types);
                case 3:
                    return getString(R.string.menu_factions);
                case 4:
                    return getString(R.string.menu_qualities);
                case 5:
                    return getString(R.string.menu_races);
            }
            return null;
        }

        public void onUpdate(Info info) {
            for (int i = 0; i < 6; i++) {
                ListFragment f = list.get(i);
                switch (i) {
                    case 0:
                        f.setData(info.classes);
                        break;
                    case 1:
                        f.setData(info.sets);
                        break;
                    case 2:
                        f.setData(info.types);
                        break;
                    case 3:
                        f.setData(info.factions);
                        break;
                    case 4:
                        f.setData(info.qualities);
                        break;
                    case 5:
                        f.setData(info.races);
                        break;
                }
            }
        }
    }

    @Override
    public void onUpdate(Info info) {
        super.onUpdate(info);
        mSectionsPagerAdapter.onUpdate(info);
    }
}
