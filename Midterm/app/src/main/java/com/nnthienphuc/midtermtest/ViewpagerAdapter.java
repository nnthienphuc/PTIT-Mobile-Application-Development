package com.nnthienphuc.midtermtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
