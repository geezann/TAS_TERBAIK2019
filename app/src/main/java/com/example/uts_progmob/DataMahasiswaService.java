package com.example.uts_progmob;

import com.example.uts_progmob.Model.DataDosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataMahasiswaService {
    @GET("/api/progmob/mhs/{nim_progmob}")
    Call<List<DataMahasiswa>> getMhsAll(@Path("nim_progmob") String nimProgmob);

    @FormUrlEncoded
    @POST("/api/progmob/mhs/create")
    Call<DefaultResult> insertMhs(@Field("nama") String nama,
                                    @Field("nim") String nim,
                                    @Field("alamat") String alamat,
                                    @Field("email") String email,
                                    @Field("foto") String foto,
                                    @Field("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("/api/progmob/mhs/createfoto")
    Call<DefaultResult> insertMhsnWithFoto(@Field("nama") String nama,
                                            @Field("nim") String nim,
                                            @Field("alamat") String alamat,
                                            @Field("email") String email,
                                            @Field("foto") String foto,
                                            @Field("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("/api/progmob/mhs/update")
    Call<DefaultResult> updateMhs(@Field("nama") String nama,
                                    @Field("nim") String nim,
                                    @Field("alamat") String alamat,
                                    @Field("email") String email,
                                    @Field("foto") String foto,
                                    @Field("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("/api/progmob/mhs/delete")
    Call<DefaultResult> deleteMhs(@Field("id") String id,
                                    @Field("nim_progmob") String nim_progmob);
}