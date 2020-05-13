package com.example.reynaldioktino.tugasbesar.AppGunung;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reynaldioktino.tugasbesar.MapsActivity;
import com.example.reynaldioktino.tugasbesar.R;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.squareup.picasso.Picasso;

public class Detail_gunung extends AppCompatActivity {

    ImageView imageViewGunung;
    TextView txtNamaGunung, txtLokasi, txtDeskripsi;
    String latitude_gunung, longitude_gunung;
    Context mContext;
    String pathImage="";

    Button btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gunung);

        imageViewGunung = (ImageView) findViewById(R.id.imageViewGunung);
        txtNamaGunung = (TextView) findViewById(R.id.textViewNamaGunung);
        txtLokasi = (TextView) findViewById(R.id.textViewLokasi);
        txtDeskripsi = (TextView) findViewById(R.id.textViewDeskripsi);

        btnMaps = findViewById(R.id.buttonMaps);

        getData();

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("latitude_gunung",latitude_gunung);
                intent.putExtra("longitude_gunung",longitude_gunung);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        txtNamaGunung.setText(getIntent().getStringExtra("nama"));
        txtLokasi.setText(getIntent().getStringExtra("lokasi"));
        txtDeskripsi.setText(getIntent().getStringExtra("deskripsi"));

        Picasso.with(mContext).load(ApiClient.BASE_URL +"application/"+ getIntent().getStringExtra("foto")).into(imageViewGunung);
        // else Picasso.with(mContext).load(R.drawable.photoid).into(mPhotoid);
//        if (getIntent().getStringExtra("foto").length()>0)
//            Glide.with(mContext).load(ApiClient.BASE_URL +"application/"+
//                    getIntent().getStringExtra("foto")).into(imageViewGunung);
//        else Glide.with(mContext).load(R.drawable.ic_launcher_background).into(imageViewGunung);
//        pathImage = getIntent().getStringExtra("foto");

        latitude_gunung = getIntent().getStringExtra("latitude_gunung");
        longitude_gunung = getIntent().getStringExtra("longitude_gunung");
    }
}
