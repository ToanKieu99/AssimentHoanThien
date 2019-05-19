package com.example.admin.assimenthoanthien.adapter_fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.assimenthoanthien.Fragment.Fragment_khoan_chi;
import com.example.admin.assimenthoanthien.Fragment.Fragment_khoan_thu;
import com.example.admin.assimenthoanthien.Fragment.Fragment_loai_thu;

public class Fragment_Khoan extends FragmentStatePagerAdapter {
    private Fragment_khoan_thu fragmentKhoan;
    private Fragment_khoan_chi fragmentKhoanChi;

    public Fragment_Khoan(FragmentManager fm) {
        super(fm);
        fragmentKhoan = new Fragment_khoan_thu();
        fragmentKhoanChi = new Fragment_khoan_chi();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragmentKhoan;
        }else if (position ==1){
            return fragmentKhoanChi;
        }else {
            //TODO nothing
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
        switch (position){
            case 0:
                return "Khoản Thu";
            case 1:
                return "Khoản Chi";

                default:
                    return null;
        }

    }
}
