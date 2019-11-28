package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uts_progmob.Adapter.DataMatkulAdapter;
import com.example.uts_progmob.Model.DataMatkul;

import java.util.ArrayList;

public class LihatMatkul extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataMatkulAdapter dataMatkulAdapter;
    private ArrayList<DataMatkul> dataMatkulArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_matkul);

        setTitle("Lihat Data MataKuliah");

        addDate();

        recyclerView = findViewById(R.id.rvMatkul);
        dataMatkulAdapter = new DataMatkulAdapter(dataMatkulArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatMatkul.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataMatkulAdapter);
    }

    private void addDate(){
        dataMatkulArrayList = new ArrayList<>();
        dataMatkulArrayList.add(new DataMatkul("SI0123-Progmob", "2", "Rabu", "3"));
        dataMatkulArrayList.add(new DataMatkul("SI1234", "3","Senin","3"));
    }

}
