package com.example.reynaldioktino.tugasbesar.Rest;

import com.example.reynaldioktino.tugasbesar.AppCerita.ResultCerita;
import com.example.reynaldioktino.tugasbesar.AppGunung.ResultGunung;
import com.example.reynaldioktino.tugasbesar.LoginUser.ResultUser;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @GET("Gunung/gunung")
    Call<ResultGunung> getGunung();

    @GET("Cerita/cerita")
    Call<ResultCerita> getCerita();

    @Multipart
    @POST("Cerita/cerita")
    Call<ResultCerita> postCerita(@Part MultipartBody.Part file,
                                  @Part("id_cerita") RequestBody id_cerita,
                                  @Part("namagunung") RequestBody namagunung,
                                  @Part("cerita") RequestBody cerita,
                                  @Part("action") RequestBody action);
    @Multipart
    @POST("Cerita/cerita")
    Call<ResultCerita> putCerita(@Part MultipartBody.Part file,
                                  @Part("id_cerita") RequestBody id_cerita,
                                  @Part("namagunung") RequestBody namagunung,
                                  @Part("cerita") RequestBody cerita,
                                  @Part("action") RequestBody action);
    @Multipart
    @POST("Cerita/cerita")
    Call<ResultCerita> deleteCerita(@Part("id_cerita") RequestBody id_cerita,
                                      @Part("action") RequestBody action);

    @FormUrlEncoded
    @POST("Login/login")
    Call<ResultUser> getLogin(@Field("username") String username,
                                @Field("password") String password);
}
