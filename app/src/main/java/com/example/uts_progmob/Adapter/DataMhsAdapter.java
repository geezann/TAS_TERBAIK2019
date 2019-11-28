package com.example.uts_progmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_progmob.Model.DataMatkul;
import com.example.uts_progmob.Model.DataMhs;
import com.example.uts_progmob.R;

import java.util.ArrayList;

public class DataMhsAdapter extends RecyclerView.Adapter<DataMhsAdapter.ViewHolder> {
    ArrayList <DataMhs> dataMhsArrayList;

    public DataMhsAdapter (ArrayList<DataMhs> dataMatkulArrayList) {
        this.dataMhsArrayList = dataMatkulArrayList;
    }

    @NonNull
    @Override
    public DataMhsAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_mahasiswa,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataMhsAdapter.ViewHolder holder, int position){
        holder.txtNimNama.setText(dataMhsArrayList.get(position).getNimNama());
        holder.txtAlamat.setText(dataMhsArrayList.get(position).getAlamat());
        holder.txtEmail.setText(dataMhsArrayList.get(position).getEmail());
    }

    @Override
    public int getItemCount(){
        return(dataMhsArrayList != null) ? dataMhsArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNimNama, txtAlamat, txtEmail;

        public ViewHolder (View view) {
            super(view);
            txtNimNama = view.findViewById(R.id.txtNimNama);
            txtEmail = view.findViewById(R.id.txtEmail);
            txtAlamat = view.findViewById(R.id.txtAlamat);
        }
    }
}
