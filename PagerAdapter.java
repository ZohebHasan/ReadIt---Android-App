package com.example.readit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabCount;

    public PagerAdapter(@NonNull FragmentManager fragmentManager, int behavior) {
        super(fragmentManager,behavior);
        tabCount = behavior;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TechFragment();
            case 2:
                return new ScienceFragment();
            case 3:
                return new SportsFragment();
            case 4:
                return new HealthFragment();
            case 5:
                return new EntertainmentFragment();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
