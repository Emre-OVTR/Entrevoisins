package com.openclassrooms.entrevoisins.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.openclassrooms.entrevoisins.ui.favorite_neighbours_list.FavoriteNeighboursFragment;
import com.openclassrooms.entrevoisins.ui.neighbours_list.NeighbourFragment;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NeighbourFragment.newInstance();
            case 1:
                return FavoriteNeighboursFragment.newInstance();
            default:
                return null;
        }
        }


    @Override
    public int getCount() {
        return 2;
    }
}