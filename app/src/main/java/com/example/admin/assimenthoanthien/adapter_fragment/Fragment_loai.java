package com.example.admin.assimenthoanthien.adapter_fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.assimenthoanthien.Fragment.Fragment_loai_chi;
import com.example.admin.assimenthoanthien.Fragment.Fragment_loai_thu;

public class Fragment_loai extends FragmentStatePagerAdapter {
    private Fragment_loai_thu fragment_loai_thu;
    private Fragment_loai_chi fragment_loai_chi;
    public Fragment_loai(FragmentManager fm) {
        super(fm);
        fragment_loai_thu = new Fragment_loai_thu();
        fragment_loai_chi = new Fragment_loai_chi();

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragment_loai_thu;
        }else if (position ==1){
            return fragment_loai_chi;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Loại Thu";
            case 1:
                return "Loại Chi";
                default:
            return null;
        }
    }
}
