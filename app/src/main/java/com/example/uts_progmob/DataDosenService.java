package com.example.uts_progmob;

import com.example.uts_progmob.Model.DataDosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataDosenService {
    @GET("/api/progmob/dosen/{nim_progmob}")
    Call<List<DataDosen>> getDosenAll(@Path("nim_progmob") String nimProgmob);

    @FormUrlEncoded
    @POST("/api/progmob/dosen/create")
    Call<DefaultResult> insertDosen(@Field("nama") String nama,
                                  @Field("nidn") String nidn,
                                  @Field("alamat") String alamat,
                                  @Field("email") String email,
                                  @Field("gelar") String gelar,
                                  @Field("foto") String foto,
                                  @Field("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("/api/progmob/dosen/createfoto")
    Call<DefaultResult> createDosen(@Field("nama") String nama,
                                    @Field("nidn") String nidn,
                                    @Field("alamat") String alamat,
                                    @Field("email") String email,
                                    @Field("gelar") String gelar,
                                    @Field("foto") String foto,
                                    @Field("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("/api/progmob/dosen/update")
    Call<DefaultResult> updateDosen(@Field("nama") String nama,
                                    @Field("nidn") String nidn,
                                    @Field("alamat") String alamat,
                                    @Field("email") String email,
                                    @Field("gelar") String gelar,
                                    @Field("foto") String foto,
                                    @Field("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("/api/progmob/dosen/delete")
    Call<DefaultResult> deleteDosen(@Field("id") String id,
                                    @Field("nim_progmob") String nim_progmob);
}
