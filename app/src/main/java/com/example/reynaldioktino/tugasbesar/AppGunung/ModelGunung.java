package com.example.reynaldioktino.tugasbesar.AppGunung;

import com.google.gson.annotations.SerializedName;

public class ModelGunung {
    @SerializedName("id_gunung")
    private String id_gunung;

    @SerializedName("nama")
    private String nama;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("foto")
    private String foto;

    @SerializedName("lokasi")
    private String lokasi;

    @SerializedName("latitude_gunung")
    private String latitude_gunung;

    @SerializedName("longitude_gunung")
    private String longitude_gunung;

    public ModelGunung(String id_gunung, String nama, String deskripsi, String foto, String lokasi, String latitude_gunung, String longitude_gunung) {
        this.id_gunung = id_gunung;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.lokasi = lokasi;
        this.latitude_gunung = latitude_gunung;
        this.longitude_gunung = longitude_gunung;
    }

    public String getId_gunung() {
        return id_gunung;
    }

    public void setId_gunung(String id_gunung) {
        this.id_gunung = id_gunung;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getLatitude_gunung() {
        return latitude_gunung;
    }

    public void setLatitude_gunung(String latitude_gunung) {
        this.latitude_gunung = latitude_gunung;
    }

    public String getLongitude_gunung() {
        return longitude_gunung;
    }

    public void setLongitude_gunung(String longitude_gunung) {
        this.longitude_gunung = longitude_gunung;
    }
}