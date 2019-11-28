package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.uts_progmob.Model.DataMhs;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    DataDosenService dataDosenService;
    DataMahasiswaService dataMahasiswaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        dataMahasiswaService = RetrofitClient.getRetrofitInstance()
                .create(DataMahasiswaService.class);
        getAllDataDosen();
        getAllDataMHS();
    }
    private void getAllDataDosen()
    {
        Call<List<com.example.uts_progmob.Model.DataDosen>> call = DataDosenService.getDosenAll("1");
        call.enqueue(new Callback<List<com.example.uts_progmob.Model.DataDosen>>() {
            @Override
            public void onResponse(Call<List<com.example.uts_progmob.Model.DataDosen>> call, Response<List<com.example.uts_progmob.Model.DataDosen>> response) {
                for(com.example.uts_progmob.Model.DataDosen dosen:response.body())
                {
                    System.out.println("NidnNama : " +dosen.getNidnNama());
                    System.out.println("Gelar : " +dosen.getGelar());
                }

            }

            @Override
            public void onFailure(Call<List<com.example.uts_progmob.Model.DataDosen>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "somethig wrong.... ", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getAllDataMHS()
    {
        Call<List<DataMhs>> call = DataMahasiswaService.getMhsAll("1");
        call.enqueue(new Callback<List<DataMhs>>() {
            @Override
            public void onResponse(Call<List<DataMhs>> call, Response<List<DataMhs>> response) {
                for(DataMhs mahasiswa:response.body())
                {
                    System.out.println("nimNama : " +mahasiswa.getNimNama());
                    System.out.println("Alamat : " +mahasiswa.getAlamat());
                }

            }

            @Override
            public void onFailure(Call<List<DataMhs>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "somethig wrong.... ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
