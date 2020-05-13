package com.example.reynaldioktino.tugasbesar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.reynaldioktino.tugasbesar.AppGunung.AdapterGunung;
import com.example.reynaldioktino.tugasbesar.AppGunung.ModelGunung;
import com.example.reynaldioktino.tugasbesar.AppGunung.ResultGunung;
import com.example.reynaldioktino.tugasbesar.AppPendakian.AdapterPendakian;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.example.reynaldioktino.tugasbesar.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Gunung extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;
    List<ModelGunung> listGunung;
    Button btAddData, btGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunung);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_gunung);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //btAddData = (Button) findViewById(R.id.btAddData);
        //btGet = (Button) findViewById(R.id.btGet);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultGunung> mGunungCall = mApiInterface.getGunung();
        mGunungCall.enqueue(new Callback<ResultGunung>() {
            @Override
            public void onResponse(Call<ResultGunung> call,
                                   Response<ResultGunung> response) {
                Log.d("Get Gunung",response.body().getStatus());
                listGunung = response.body().getResult();
                mAdapter = new AdapterGunung(listGunung);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<ResultGunung> call, Throwable t) {
                Log.d("Get Gunung",t.getMessage());
            }
        });
    }
}
