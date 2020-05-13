package com.example.reynaldioktino.tugasbesar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linear;

    List<Menu> menu;
    AdapterMenu adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        linear = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);

        menu = new ArrayList<>();
        menu.add(new Menu(R.drawable.profil, "Profil"));
        menu.add(new Menu(R.drawable.story, "Cerita Mendaki"));
        menu.add(new Menu(R.drawable.gunung, "Daftar Gunung"));
        menu.add(new Menu(R.drawable.pendakian, "Daftar Pendakian"));
        menu.add(new Menu(R.drawable.camera, "Ambil Foto"));
        menu.add(new Menu(R.drawable.info, "Tentang Kami"));
        menu.add(new Menu(R.drawable.logout, "Logout"));

        adapter = new AdapterMenu(this, menu);
        recyclerView.setAdapter(adapter);
    }
}
