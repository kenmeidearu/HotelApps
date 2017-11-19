package com.kenjin.hotelapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.kenjin.hotelapp.fragment.tab1Fragment;
import com.kenjin.hotelapp.fragment.tab2Fragment;
import com.kenjin.hotelapp.fragment.tab3Fragment;

/**
 * Created by kenjin on 5/27/2016.
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    String[] title = new String[]{
            "Description", "Price", "Facility"
    };
    public TabFragmentPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new tab1Fragment();
                break;
            case 1:
                fragment=new tab2Fragment();
                break;
            case 2:
                fragment=new tab3Fragment();
                break;
            default:
                fragment=null;
                break;
        }
        return  fragment;
    }

    @Override
    public  CharSequence getPageTitle(int position){
        return  title[position];
    }
    @Override
    public  int getCount(){
        return  title.length;
    }
}
