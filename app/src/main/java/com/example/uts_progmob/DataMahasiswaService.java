package com.example.uts_progmob;

import com.example.uts_progmob.Model.DataDosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataMahasiswaService {
    @GET("/api/progmob/mahasiswa/{nim_progmob}")
    Call<List<DataDosen>> getMhsAll(@Path("nim_progmob") String nimProgmob);
}