package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uts_progmob.Adapter.DataKelasAdapter;
import com.example.uts_progmob.Model.DataKelas;

import java.util.ArrayList;

public class LihatKelas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataKelasAdapter dataKelasAdapter;
    private ArrayList<DataKelas> dataKelasArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_kelas);

        setTitle("Lihat Data Kelas");

        addData();

        recyclerView = findViewById(R.id.rvKelas);
        dataKelasAdapter = new DataKelasAdapter(dataKelasArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatKelas.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataKelasAdapter);
    }

    private void addData(){
        dataKelasArrayList = new ArrayList<>();
        dataKelasArrayList.add(new DataKelas("SI0123-Progmob","Sesi : 2", "Hari : Rabu", "Dosen : Argo Wibowo", "Jumlah Mahasiswa : 32"));
        dataKelasArrayList.add(new DataKelas("SI1234-Progweb","Sesi : 3","Hari : Senin","Dosen : Erick Kurniawan","Jumlah Mahasiswa : 30"));

    }
}
