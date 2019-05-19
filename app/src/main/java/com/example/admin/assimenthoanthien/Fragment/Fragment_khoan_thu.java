package com.example.admin.assimenthoanthien.Fragment;



import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.assimenthoanthien.Adapter.AdapterRecyView;
import com.example.admin.assimenthoanthien.Class.ThuChi;
import com.example.admin.assimenthoanthien.DatabaseManager.DatabaseManager;
import com.example.admin.assimenthoanthien.MainActivity;
import com.example.admin.assimenthoanthien.R;

import java.util.ArrayList;


public class Fragment_khoan_thu extends Fragment {

    private RecyclerView recyclerViewKhoan_thu;
    private Cursor cursor;
    private SimpleCursorAdapter adapter;
    private ItemTouchHelper.SimpleCallback callback;


    private ArrayList<ThuChi> thuChis;
    private DatabaseManager db;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framelayput_khoan_thu, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
          //  re(view);
        fab = view.findViewById(R.id.fab_khoan_thu);
        db = new DatabaseManager(getActivity());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View v = getLayoutInflater().inflate(R.layout.dialog_add,null);
                final EditText editThem = v.findViewById(R.id.editThem);
                TextView btThem = v.findViewById(R.id.btthem);
                TextView btHuy = v.findViewById(R.id. bthuy);
                builder.setView(v);
                AlertDialog dialog = builder.create();
                dialog.show();

                btThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = editThem.getText().toString();
                        if (name.equals("")){
                            Toast.makeText(getContext(), "Nhập đầy đủ để thêm", Toast.LENGTH_SHORT).show();
                        }else {
                            db.insertKhoanThu(name);
                            getKhoanThu();
                        }
                    }
                });
                getKhoanThu();
                btHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editThem.setText("");
                    }
                });
            }
        });
    }
    public void getKhoanThu(){
            cursor = db.getKhoanThu();

    }

    public void re(View view){

        thuChis = new ArrayList<>();
        thuChis.add(new ThuChi("Vũ Quốc Toàn"));
        thuChis.add(new ThuChi("Vũ Việt Kiều"));
        thuChis.add(new ThuChi("Nguyễn Quang Hiệp"));
        thuChis.add(new ThuChi("Nguyễn Trọng Chuyển"));

        recyclerViewKhoan_thu = view.findViewById(R.id.recyclerKhoan_thu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewKhoan_thu.setLayoutManager(linearLayoutManager);
        AdapterRecyView adapter = new AdapterRecyView(thuChis, getActivity());
        recyclerViewKhoan_thu.setAdapter(adapter);
    }

   public void FloatButton(View view){
        fab = view.findViewById(R.id.fab_khoan_thu);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View v = getLayoutInflater().inflate(R.layout.dialog_add,null);
                final EditText editThem = v.findViewById(R.id.editThem);
                TextView btThem = v.findViewById(R.id.btthem);
                TextView btHuy = v.findViewById(R.id. bthuy);
                builder.setView(v);
                AlertDialog dialog = builder.create();
                dialog.show();

                btThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(), "Thêm", Toast.LENGTH_SHORT).show();
                    }
                });
                btHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editThem.setText("");
                        Toast.makeText(getActivity(),"Hủy",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
