package com.example.reynaldioktino.tugasbesar.AppCerita;

import com.google.gson.annotations.SerializedName;

public class ModelCerita {
    @SerializedName("id_cerita")
    private String id_cerita;

    @SerializedName("namagunung")
    private String namagunung;

    @SerializedName("cerita")
    private String cerita;

    @SerializedName("photo_id")
    private String photo_id;

    public ModelCerita(String id_cerita, String namagunung, String cerita, String photo_id) {
        this.id_cerita = id_cerita;
        this.namagunung = namagunung;
        this.cerita = cerita;
        this.photo_id = photo_id;
    }

    public String getId_cerita() {
        return id_cerita;
    }

    public void setId_cerita(String id_cerita) {
        this.id_cerita = id_cerita;
    }

    public String getNamagunung() {
        return namagunung;
    }

    public void setNamagunung(String namagunung) {
        this.namagunung = namagunung;
    }

    public String getCerita() {
        return cerita;
    }

    public void setCerita(String cerita) {
        this.cerita = cerita;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }
}
