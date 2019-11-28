package com.example.uts_progmob.Model;

import com.google.gson.annotations.SerializedName;

public class DataMhs {
    @SerializedName("nimNama")
    private String nimNama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("email")
    private String email;
    //public String nimNama;
    //public String Alamat;
    //public String email;

    public DataMhs(String nimNama, String alamat, String email) {
        this.setNimNama(nimNama);
        this.setAlamat(alamat);
        this.setEmail(email);
    }

    public String getNimNama() {
        return nimNama;
    }

    public void setNimNama(String nimNama) {
        this.nimNama = nimNama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
