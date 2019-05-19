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
import com.example.admin.assimenthoanthien.adapter_fragment.Fragment_loai;

public class QuanLy_fragment_loai extends Fragment {
    private TabLayout tabLayoutLoai;
    private ViewPager viewPagerLoai;
    private Fragment_loai fragment_loai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.tab_viewpager_loai,null);
       tabLayoutLoai = view.findViewById(R.id.tab_Loai);
       viewPagerLoai = view.findViewById(R.id.viewPager_Loai);
       fragment_loai = new Fragment_loai(getChildFragmentManager());
       viewPagerLoai.setAdapter(fragment_loai);

       tabLayoutLoai.post(new Runnable() {
           @Override
           public void run() {
               tabLayoutLoai.setupWithViewPager(viewPagerLoai);
           }
       });
       tabLayoutLoai.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
