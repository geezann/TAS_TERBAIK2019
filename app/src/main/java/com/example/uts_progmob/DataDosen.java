package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.widget.Toast;

import com.example.uts_progmob.Model.DataMhs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataDosen extends AppCompatActivity {
    DataDosenService dataDosenService;
    DataDosenService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_dosen);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);

        final EditText nama, nidn, alamat, email, gelar, foto;


        nama = (EditText) findViewById(R.id.etxNama);
        nidn = (EditText) findViewById(R.id.etxNidn);
        alamat = (EditText) findViewById(R.id.etxAlamat);
        email = (EditText) findViewById(R.id.etxEmail);
        gelar = (EditText) findViewById(R.id.etxGelar);
        foto = (EditText) findViewById(R.id.etxFoto);
        Button simpanButton = (Button) findViewById(R.id.simpan);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama.getText().toString().length()==0){
                    //jika form Email belum di isi / masih kosong
                    nama.setError("Silahkan mengisi Nama anda!");
                }else if(nidn.getText().toString().length()==0){
                    //jika form Username belum di isi / masih kosong
                    nidn.setError("Silahkan mengisi NIDN anda!");
                }else if(alamat.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    alamat.setError("Silahkan mengisi Alamat anda!!");
                }else if(email.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    email.setError("Silahkan isi Email anda!!");
                }else if(gelar.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    gelar.setError("Silahkan isi Email anda!!");
                }else if(foto.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    foto.setError("Silahkan mengisi Alamat anda!!");
                }else {
                    //jika form sudah terisi semua
                    Toast.makeText(getApplicationContext(), "Simpan Berhasil!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void insertDosen(){
        Call<DefaultResult> call = dataDosenService.insertDosen("Argo","0516118902","Godean",
                "argo@staff.ukdw.ac.id","S.T., M.Eng","7216002-2019-11-02.jpg","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataDosen.this,
                        "Something wnet wrong... Please try ;ater!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateDosen(){
        Call<DefaultResult> call = dataDosenService.updateDosen("Argo","0516118902","Godean",
                "argo@staff.ukdw.ac.id","S.T., M.Eng","7216002-2019-11-02.jpg","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataDosen.this,
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
                Toast.makeText(DataDosen.this,
                        "Data dihapus!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(DataDosen.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void insertDosenWithFoto(){
        File sdcard = Environment.getExternalStorageDirectory();
        String imageToSend = null;

        File file = new File(sdcard,"/Download/image.jpg");

        if(file.exists()){
            if(!checkPermission()){
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
            Bitmap imageBitMap = BitmapFactory.decodeFile(file.getAbsolutePath());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitMap.compress(Bitmap.CompressFormat.JPEG,100,baos);
            byte[] bytes = baos.toByteArray();
            String base64 = Base64.encodeToString(bytes,Base64.DEFAULT);

        }

        Call<DefaultResult> call = dataDosenService.insertDosenWithFoto("Argo","0516118902","Godean",
                "argo@staff.ukdw.ac.id","S.T., M.Eng",imageToSend,"72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataDosen.this,
                        "Something wnet wrong... Please try ;ater!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

