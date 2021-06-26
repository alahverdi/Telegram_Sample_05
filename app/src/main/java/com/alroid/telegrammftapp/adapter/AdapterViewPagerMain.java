package com.alroid.telegrammftapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Map;

public class AdapterViewPagerMain extends FragmentPagerAdapter {

    Map<String, Fragment> map;

    public AdapterViewPagerMain(@NonNull FragmentManager fm, Map<String, Fragment> map) {
        super(fm);
        this.map = map;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) map.keySet().toArray()[position];
        //return getPageTitle(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return (Fragment) map.values().toArray()[position];
    }

    @Override
    public int getCount() {
        return map.size();
    }
}
