package com.example.reynaldioktino.tugasbesar;

public class Menu {
    private int img;
    private String judul;

    public Menu(int img, String judul) {
        this.img = img;
        this.judul = judul;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
