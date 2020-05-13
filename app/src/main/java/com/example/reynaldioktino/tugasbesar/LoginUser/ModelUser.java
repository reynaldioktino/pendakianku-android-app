package com.example.reynaldioktino.tugasbesar.LoginUser;

import com.google.gson.annotations.SerializedName;

public class ModelUser {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("no_hp")
    private String no_hp;

    public ModelUser(String username, String password, String nama, String email, String no_hp) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}
