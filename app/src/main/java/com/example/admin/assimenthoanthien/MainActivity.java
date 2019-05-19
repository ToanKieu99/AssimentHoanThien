package com.example.admin.assimenthoanthien;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.assimenthoanthien.Fragment.fargment_thongke;
import com.example.admin.assimenthoanthien.QuanLy_fragment.QuanLy_fagment_khoan;
import com.example.admin.assimenthoanthien.QuanLy_fragment.QuanLy_fragment_loai;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        QuanLyFragment(new fargment_thongke());


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemKhoanThu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new QuanLy_fagment_khoan()).commit();
                Toast.makeText(this, "Khoản", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemLoaiThu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new QuanLy_fragment_loai()).commit();
                    Toast.makeText(this, "Loại", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemThongKe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, new fargment_thongke()).commit();
                Toast.makeText(this, "Thông kê", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemGioiThieu:
                Toast.makeText(this, "giới thiệu", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemThoat:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Bạn có chắc chắn muốn thoát không?");
                builder.setIcon(R.drawable.iconthoat);
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.show();

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void QuanLyFragment(Fragment fragment) {
        if (fragment != null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentLayout, fragment);
            fragmentTransaction.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
