package com.example.reynaldioktino.tugasbesar.AppPendakian;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reynaldioktino.tugasbesar.AppDatabase;
import com.example.reynaldioktino.tugasbesar.R;

public class AddPendakian extends AppCompatActivity {

    EditText namaGunung, tanggal, kota;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pendakian);

        namaGunung = findViewById(R.id.edtGunung);
        tanggal = findViewById(R.id.edtTanggal);
        kota = findViewById(R.id.edtKota);
        btnSimpan = findViewById(R.id.btnSimpanPendakian);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "pendakian")
                .allowMainThreadQueries()
                .build();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelPendakian modelPendakian = new ModelPendakian(namaGunung.getText().toString(), tanggal.getText().toString(), kota.getText().toString());
                db.pendakianDao().insertAll(modelPendakian);
                //Toast.makeText(CreateUser.this,"Data Berhasil Ditambahkan");
                namaGunung.setText("");
                tanggal.setText("");
                kota.setText("");
                Toast.makeText(AddPendakian.this,"Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
            }
        });
    }
}
