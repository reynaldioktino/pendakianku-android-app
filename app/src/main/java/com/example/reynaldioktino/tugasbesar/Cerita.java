package com.example.reynaldioktino.tugasbesar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.reynaldioktino.tugasbesar.AppCerita.AdapterCerita;
import com.example.reynaldioktino.tugasbesar.AppCerita.AddCerita;
import com.example.reynaldioktino.tugasbesar.AppCerita.ModelCerita;
import com.example.reynaldioktino.tugasbesar.AppCerita.ResultCerita;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.example.reynaldioktino.tugasbesar.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cerita extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;
    List<ModelCerita> listCerita;
    Button btAddData, btGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerita);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_cerita);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btAddData = (Button) findViewById(R.id.buttonTambahData);

        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCerita.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultCerita> mCeritaCall = mApiInterface.getCerita();
        mCeritaCall.enqueue(new Callback<ResultCerita>() {
            @Override
            public void onResponse(Call<ResultCerita> call,
                                   Response<ResultCerita> response) {
                Log.d("Get Cerita",response.body().getStatus());
                listCerita = response.body().getResult();
                mAdapter = new AdapterCerita(listCerita);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<ResultCerita> call, Throwable t) {
                Log.d("Get Cerita",t.getMessage());
            }
        });
    }
}
