package com.example.reynaldioktino.tugasbesar;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.reynaldioktino.tugasbesar.AppPendakian.AdapterPendakian;
import com.example.reynaldioktino.tugasbesar.AppPendakian.AddPendakian;
import com.example.reynaldioktino.tugasbesar.AppPendakian.ModelPendakian;

import java.util.List;

public class Pendakian extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Button addPendakian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendakian);

        recyclerView = findViewById(R.id.recycler_view_pendakian);
        addPendakian = findViewById(R.id.btnAddPendakian);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "pendakian")
                .allowMainThreadQueries()
                .build();

        List<ModelPendakian> modelsPendakian = db.pendakianDao().getAllUsers();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterPendakian(this, modelsPendakian);
        recyclerView.setAdapter(adapter);

        addPendakian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddPendakian.class);
                v.getContext().startActivity(i);
            }
        });
    }
}
