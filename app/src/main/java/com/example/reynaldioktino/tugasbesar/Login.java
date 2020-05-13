package com.example.reynaldioktino.tugasbesar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reynaldioktino.tugasbesar.LoginUser.ModelUser;
import com.example.reynaldioktino.tugasbesar.LoginUser.ResultUser;
import com.example.reynaldioktino.tugasbesar.Rest.ApiClient;
import com.example.reynaldioktino.tugasbesar.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button btnLogin, btnRegister;


    EditText edtPassword, edtUsername;
    //
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApiInterface= ApiClient.getClient().create(ApiInterface.class);
                Call<ResultUser> mgetLogin = mApiInterface.getLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
                mgetLogin.enqueue(new Callback<ResultUser>() {
                    @Override
                    public void onResponse(Call<ResultUser> call, Response<ResultUser> response) {
//                        Log.e("Stats",response.body().getStatus());
                        String status = response.body().getStatus();
                        if (status.equals("success")){
                            ModelUser user = response.body().getUser();
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            Toast.makeText(getApplicationContext(), "User :"+user.getUsername(), Toast.LENGTH_LONG).show();
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResultUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Server Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
