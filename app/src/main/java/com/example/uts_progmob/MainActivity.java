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
    DataDosenService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        insertDosen();
        createDosen();
        updateDosen();
        deleteDosen();

    }

    private void insertDosen(){
        Call<DefaultResult> call = dataDosenService.insertDosen("Dendy","011","Yogyakarta",
                "dendy@dendy.com","SKUYLIVING","dendy.jpg","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(MainActivity.this,
                        "Something wnet wrong... Please try ;ater!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createDosen(){
        Call<DefaultResult> call = dataDosenService.createDosen("Dendy","011","Yogyakarta",
                "dendy@dendy.com","SKUYLIVING","dendy.jpg","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(MainActivity.this,
                        "Something wnet wrong... Please try ;ater!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateDosen(){
        Call<DefaultResult> call = dataDosenService.updateDosen("Dendy","011","Yogyakarta",
                "dendy@dendy.com","SKUYLIVING","dendy.jpg","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(MainActivity.this,
                        "Data diubah!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteDosen(){
        Call<DefaultResult> call = dataDosenService.deleteDosen("18","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(MainActivity.this,
                        "Data dihapus!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
