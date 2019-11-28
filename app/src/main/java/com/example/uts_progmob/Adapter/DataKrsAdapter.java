package com.example.uts_progmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_progmob.Model.DataKrs;
import com.example.uts_progmob.R;
import com.example.uts_progmob.RecycleView;

import java.util.ArrayList;

public class DataKrsAdapter extends RecyclerView.Adapter<DataKrsAdapter.ViewHolder> {
    ArrayList <DataKrs> dataKrsArrayList;

    public DataKrsAdapter (ArrayList<DataKrs> dataKrsArrayList) {
        this.dataKrsArrayList = dataKrsArrayList;
    }

    @NonNull
    @Override
    public DataKrsAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_krs,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataKrsAdapter.ViewHolder holder, int position){
        holder.txtHariKrs.setText(dataKrsArrayList.get(position).getHariKrs());
        holder.txtSesiKrs.setText(dataKrsArrayList.get(position).getSesiKrs());
        holder.txtKodeMatkulKrs.setText(dataKrsArrayList.get(position).getKodeMatkulKrs());
        holder.txtJlhSksKrs.setText(dataKrsArrayList.get(position).getJlhSksKrs());
        holder.txtDosenPengampuKrs.setText(dataKrsArrayList.get(position).getDosenPengampuKrs());
        holder.txtJlhMhsKrs.setText(dataKrsArrayList.get(position).getJlhMhsKrs());
    }

    @Override
    public int getItemCount(){
        return(dataKrsArrayList != null) ? dataKrsArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtHariKrs, txtSesiKrs, txtKodeMatkulKrs, txtJlhSksKrs, txtDosenPengampuKrs, txtJlhMhsKrs;

        public ViewHolder (View view) {
            super(view);
            txtHariKrs = view.findViewById(R.id.txtHariKrs);
            txtJlhSksKrs = view.findViewById(R.id.txtJlhSksKrs);
            txtKodeMatkulKrs = view.findViewById(R.id.txtKodeMatkulKrs);
            txtSesiKrs = view.findViewById(R.id.txtSesiKrs);
            txtDosenPengampuKrs = view.findViewById(R.id.txtDosenPengampu);
            txtJlhMhsKrs = view.findViewById(R.id.txtJlhMhsKrs);

        }
    }
}
