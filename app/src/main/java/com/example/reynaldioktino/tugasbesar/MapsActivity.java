package com.example.reynaldioktino.tugasbesar;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double latitude, longitude;
    MarkerOptions lokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent i = getIntent();
        latitude =  i.getDoubleExtra("latitude_gunung",0);
        longitude =  i.getDoubleExtra("longitude_gunung",0);

        lokasi = new MarkerOptions().position(new LatLng(latitude, longitude)).title("lokasi");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Menambahkan marker untuk kota Malang, memindahkan camera, dan melakukan zoom in
        LatLng malang = new LatLng(-8.135015, 112.8858181);
        mMap.addMarker(new MarkerOptions().position(malang).title("Marker in Semeru"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(malang,14.0f));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
}
