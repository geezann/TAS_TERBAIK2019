package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uts_progmob.Adapter.DataDosenAdapter;
import com.example.uts_progmob.Model.DataDosen;
import com.example.uts_progmob.Adapter.DataKelasAdapter;

import java.util.ArrayList;

public class LihatDosen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataDosenAdapter dataDosenAdapter;
    private ArrayList<DataDosen> dataDosenArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_dosen);

        addData();

        recyclerView = findViewById(R.id.rvDosen);
        dataDosenAdapter = new DataDosenAdapter(dataDosenArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDosen.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataDosenAdapter);
    }

    private void addData(){
        dataDosenArrayList = new ArrayList<>();
        dataDosenArrayList.add(new DataDosen("00000001-Yetli", "S.Kom","Jl.Godean","yetli@gmail.com"));
        dataDosenArrayList.add(new DataDosen("00000002-Katon","S.Kom","Jl.Seturan Raya", "katon@gmail.com"));
    }


}
