package com.example.uts_progmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

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
}
