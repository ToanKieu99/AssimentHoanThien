package com.example.admin.assimenthoanthien.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.admin.assimenthoanthien.Class.ThuChi;
import com.example.admin.assimenthoanthien.Fragment.Fragment_khoan_thu;
import com.example.admin.assimenthoanthien.R;
import java.util.ArrayList;
import java.util.List;

public class AdapterRecyView extends RecyclerView.Adapter<AdapterRecyView.ViewHolder> {
    ArrayList<ThuChi> thuChis;
    Context context;
    LayoutInflater inflater;

    public AdapterRecyView(ArrayList<ThuChi> thuChis, Context context) {
        this.thuChis = thuChis;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public AdapterRecyView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.item_qltc,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyView.ViewHolder holder, int position) {
        ThuChi thuChi = thuChis.get(position);
        holder.tvnameLuong.setText(thuChi.getName());

    }

    @Override
    public int getItemCount() {
        return thuChis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvnameLuong;
        ImageView imgDelete;
        ImageView imgSua;

        public ViewHolder(View itemView) {
            super(itemView);
            tvnameLuong = itemView.findViewById(R.id.tvnameLuong);
            imgSua = itemView.findViewById(R.id.itemSua);
            imgDelete = itemView.findViewById(R.id.itemDelete);
        }
    }
}
