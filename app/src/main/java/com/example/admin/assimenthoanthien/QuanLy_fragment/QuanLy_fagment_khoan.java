package com.example.admin.assimenthoanthien.QuanLy_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.assimenthoanthien.R;
import com.example.admin.assimenthoanthien.adapter_fragment.Fragment_Khoan;

public class QuanLy_fagment_khoan extends Fragment {
    private TabLayout tabKhoan;
    private ViewPager viewPagerKhoan;
    private Fragment_Khoan fragment_khoan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_viewpager_khoan,null);
        tabKhoan = view.findViewById(R.id.tab_Khoan);
        viewPagerKhoan = view.findViewById(R.id.viewPager_Khoan);
        fragment_khoan = new Fragment_Khoan(getChildFragmentManager());
        viewPagerKhoan.setAdapter(fragment_khoan);

        tabKhoan.post(new Runnable() {
            @Override
            public void run() {
                tabKhoan.setupWithViewPager(viewPagerKhoan);
            }
        });

        tabKhoan.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}
