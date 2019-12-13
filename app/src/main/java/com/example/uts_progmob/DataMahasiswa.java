package com.example.uts_progmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataMahasiswa extends AppCompatActivity {
    DataMahasiswaService dataMahasiswaService;
    DataMahasiswaService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);
        dataMahasiswaService = RetrofitClient.getRetrofitInstance()
                .create(DataMahasiswaService.class);

        final EditText nama, nim, alamat, email, gelar, foto;

        Button simpanButton = (Button) findViewById(R.id.simpan);
        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DataMahasiswa.this);
                builder.setMessage("Apakah ingin menyimpan data?").setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(DataMahasiswa.this, "Tidak jadi menyimpan", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent intent = new Intent(DataMahasiswa.this, MenuMahasiswa.class);
                        startActivity(intent);
                        Toast.makeText(DataMahasiswa.this,"Berhasil menyimpan", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        nama = (EditText) findViewById(R.id.etxNama);
        nim = (EditText) findViewById(R.id.etxNim);
        alamat = (EditText) findViewById(R.id.etxAlamat);
        email = (EditText) findViewById(R.id.etxEmail);
        foto = (EditText) findViewById(R.id.etxFoto);
        simpanButton = (Button)findViewById(R.id.simpan);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama.getText().toString().length()==0){
                    //jika form Email belum di isi / masih kosong
                    nama.setError("Silahkan mengisi Nama anda!");
                }else if(nim.getText().toString().length()==0){
                    //jika form Username belum di isi / masih kosong
                    nim.setError("Silahkan mengisi NIDN anda!");
                }else if(alamat.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    alamat.setError("Silahkan mengisi Alamat anda!!");
                }else if(email.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    email.setError("Silahkan isi Email anda!!");
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
    private void insertMhs(){
        Call<DefaultResult> call = dataMahasiswaService.insertMhs("Reinald","72150001","Babarsari",
                "reinald@si.ukdw.ac.id","Yes","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataMahasiswa.this,
                        "Something wnet wrong... Please try ;ater!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void updateMhs(){
        Call<DefaultResult> call = dataMahasiswaService.updateMhs("Salsa","72150002","Babarsari",
                "salsa@si.ukdw.ac.id","yes","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataMahasiswa.this,
                        "Data diubah!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteMhs(){
        Call<DefaultResult> call = dataMahasiswaService.deleteMhs("2","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataMahasiswa.this,
                        "Data dihapus!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(DataMahasiswa.this,
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

        Call<DefaultResult> call = dataMahasiswaService.insertMhsnWithFoto("Salsa","72150002","Babarsari",
                "salsa@si.ukdw.ac.id","YES","72140020");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message :"+t.getMessage());
                Toast.makeText(DataMahasiswa.this,
                        "Something wnet wrong... Please try ;ater!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
