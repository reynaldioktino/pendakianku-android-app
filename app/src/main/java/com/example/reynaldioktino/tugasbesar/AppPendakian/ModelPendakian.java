package com.example.reynaldioktino.tugasbesar.AppPendakian;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ModelPendakian {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nama_gunung")
    private String namaGunung;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    @ColumnInfo(name = "kota")
    private String kota;

    public ModelPendakian(String namaGunung, String tanggal, String kota) {
        this.namaGunung = namaGunung;
        this.tanggal = tanggal;
        this.kota = kota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaGunung() {
        return namaGunung;
    }

    public void setNamaGunung(String namaGunung) {
        this.namaGunung = namaGunung;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
