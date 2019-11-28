package com.example.uts_progmob.Model;

import com.google.gson.annotations.SerializedName;

public class DataDosen {
    @SerializedName("nidnNama")
    private String nidnNama;
    @SerializedName("gelar")
    private String gelar;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("email")
    private String email;
    //public String nidnNama;
    //public String gelar;
    //public String alamat;
    //public String email;

    public DataDosen(String nidnNama, String gelar, String alamat, String email) {
        this.setNidnNama(nidnNama);
        this.setGelar(gelar);
        this.setAlamat(alamat);
        this.setEmail(email);
    }

    public String getNidnNama() {
        return nidnNama;
    }

    public void setNidnNama(String nidnNama) {
        this.nidnNama = nidnNama;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
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

    public void setEmail(String email) { this.email = email; }
}
