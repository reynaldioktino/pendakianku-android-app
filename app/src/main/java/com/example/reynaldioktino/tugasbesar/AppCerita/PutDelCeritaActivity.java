package com.example.reynaldioktino.tugasbesar.AppCerita;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.reynaldioktino.tugasbesar.Cerita;
import com.example.reynaldioktino.tugasbesar.R;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.example.reynaldioktino.tugasbesar.Rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PutDelCeritaActivity extends AppCompatActivity {

    ImageView mPhotoid;
    EditText edtIdCerita, edtNamaGunung, edtCerita;
    TextView tvMessage;
    Context mContext;
    Button btUpdate, btDelete, btBack, btPhotoId;
    String pathImage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_del_cerita);

        mContext = getApplicationContext();
        mPhotoid = (ImageView) findViewById(R.id.imgPhotoId);
        edtIdCerita = (EditText) findViewById(R.id.edtIdCerita);
        edtNamaGunung = (EditText) findViewById(R.id.edtNamaGunung);
        edtCerita = (EditText) findViewById(R.id.edtCerita);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btUpdate = (Button) findViewById(R.id.btUpdateDataCerita);
        btDelete = (Button) findViewById(R.id.btDeleteDataCerita);
        btBack = (Button) findViewById(R.id.btBackDataCerita);
        btPhotoId = (Button) findViewById(R.id.btPhotoId);
        Intent mIntent = getIntent();
        edtIdCerita.setText(mIntent.getStringExtra("id_cerita"));
        edtNamaGunung.setText(mIntent.getStringExtra("nama_gunung"));
        edtCerita.setText(mIntent.getStringExtra("cerita"));
        // if (mIntent.getStringExtra("photo_id").length()>0)
        Picasso.with(mContext).load(ApiClient.BASE_URL +"application/"+ mIntent.getStringExtra("photo_id")).into(mPhotoid);
        // else Picasso.with(mContext).load(R.drawable.photoid).into(mPhotoid);
        if (mIntent.getStringExtra("photo_id").length()>0)
            Glide.with(mContext).load(ApiClient.BASE_URL +"application/"+
                    mIntent.getStringExtra("photo_id")).into(mPhotoid);
        else Glide.with(mContext).load(R.drawable.ic_launcher_background).into(mPhotoid);
        pathImage = mIntent.getStringExtra("photo_id");
        setListener();
    }

    private void setListener() {
        final ApiInterface mApiInterface =
                ApiClient.getClient().create(ApiInterface.class);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultipartBody.Part body = null;
                //dicek apakah image sama dengan yang ada di server atau berubah
                //jika sama dikirim lagi jika berbeda akan dikirim ke server
                if
                        ((pathImage.contains("upload/"+edtIdCerita.getText().toString())==false)&&(pathImage.length()>0)){
                    //File creating from selected URL
                    File file = new File(pathImage);
                    // create RequestBody instance from file
                    RequestBody requestFile =
                            RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    // MultipartBody.Part is used to send also the actual file name
                    body = MultipartBody.Part.createFormData("photo_id", file.getName(),
                            requestFile);
                }
                RequestBody reqIdCerita =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),

                                (edtIdCerita.getText().toString().isEmpty()==true)?"":edtIdCerita.getText().toString());
                RequestBody reqNamaGunung =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),

                                (edtNamaGunung.getText().toString().isEmpty()==true)?"":edtNamaGunung.getText().toString());
                RequestBody reqCerita =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),

                                (edtCerita.getText().toString().isEmpty()==true)?"":edtCerita.getText().toString());
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                "put");
                Call<ResultCerita> callUpdate = mApiInterface.putCerita(body, reqIdCerita, reqNamaGunung, reqCerita, reqAction);
                callUpdate.enqueue(new Callback<ResultCerita>() {
                    @Override
                    public void onResponse(Call<ResultCerita> call, Response<ResultCerita>
                            response) {
                        //Log.d("Update Retrofit ", response.body().getStatus());
//                        if (response.body().getStatus().equals("failed")){
//                            tvMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()+"\n"+
//                                    "Message = "+response.body().getMessage()+"\n");
//                        }else{
//                            String detail = "\n"+ "id_pembeli = "+response.body().getResult().get(0).getIdPembeli()+"\n"+ "agama = "+response.body().getResult().get(0).getNama()+"\n"+ "alamat = "+response.body().getResult().get(0).getAlamat()+"\n"+ "telpn = "+response.body().getResult().get(0).getTelpn()+"\n"+ "photo_id = "+response.body().getResult().get(0).getPhotoId()+"\n";
//                            tvMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()+"\n"+
//                                    "Message = "+response.body().getMessage()+detail);
//                        }
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ResultCerita> call, Throwable t) {
                        //Log.d("Update Retrofit ", t.getMessage());
                        tvMessage.setText("Retrofit Update \n Status = "+ t.getMessage());
                    }
                });
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody reqIdCerita =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),

                                (edtIdCerita.getText().toString().isEmpty()==true)?"":edtIdCerita.getText().toString())
                        ;
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                "delete");
                Call<ResultCerita> callDelete =
                        mApiInterface.deleteCerita(reqIdCerita,reqAction);
                callDelete.enqueue(new Callback<ResultCerita>() {
                    @Override
                    public void onResponse(Call<ResultCerita> call, Response<ResultCerita> response) {
                        tvMessage.setText("Retrofit Delete \n Status = "+response.body().getStatus()+"\n"+ "Message = "+response.body().getMessage()+"\n");
                    }
                    @Override
                    public void onFailure(Call<ResultCerita> call, Throwable t) {
                        tvMessage.setText("Retrofit Delete \n Status = "+ t.getMessage());
                    }
                });
            }
        });
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempIntent = new Intent(mContext, Cerita.class);
                startActivity(tempIntent);
            }
        });
        btPhotoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih Gambar Untuk Di upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode ==10) {
            if (data == null) {
                Toast.makeText(mContext, "Gambar Gagal Di load",
                        Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn,
                    null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                pathImage = cursor.getString(columnIndex);
                //Picasso.with(mContext).load(new File(pathImage)).fit().into(mPhotoid);
                Glide.with(mContext).load(new File(pathImage)).into(mPhotoid);
                cursor.close();
            } else {
                Toast.makeText(mContext, "Gambar Gagal Di load",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
