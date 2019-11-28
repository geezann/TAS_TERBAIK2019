package com.example.uts_progmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_progmob.Model.DataDosen;
import com.example.uts_progmob.Model.DataKelas;
import com.example.uts_progmob.R;

import java.util.ArrayList;

public class DataDosenAdapter extends RecyclerView.Adapter<DataDosenAdapter.ViewHolder> {
    ArrayList <DataDosen> dataDosenArrayList;

    public DataDosenAdapter (ArrayList<DataDosen> dataDosenArrayList){
        this.dataDosenArrayList = dataDosenArrayList;
    }

    @NonNull
    @Override
    public DataDosenAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_dosen,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataDosenAdapter.ViewHolder holder, int position){
        holder.txtNidnNama.setText(dataDosenArrayList.get(position).getNidnNama());
        holder.txtGelar.setText(dataDosenArrayList.get(position).getGelar());
        holder.txtAlamat.setText(dataDosenArrayList.get(position).getAlamat());
        holder.txtEmail.setText(dataDosenArrayList.get(position).getEmail());
    }

    @Override
    public int getItemCount(){
        return(dataDosenArrayList != null) ? dataDosenArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNidnNama, txtGelar, txtAlamat, txtEmail;

        public ViewHolder (View view) {
            super(view);
            txtNidnNama = view.findViewById(R.id.txtNidnNama);
            txtGelar = view.findViewById(R.id.txtGelar);
            txtEmail = view.findViewById(R.id.txtEmailD);
            txtAlamat = view.findViewById(R.id.txtAlamatD);
        }
    }



}
