package com.example.uts_progmob;

import com.example.uts_progmob.Model.DataDosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataDosenService {
    @GET("/api/progmob/dosen/{nim_progmob}")
    Call<List<DataDosen>> getDosenAll(@Path("nim_progmob") String nimProgmob);
}
