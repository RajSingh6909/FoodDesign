package com.example.fooddesign.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    String JSONURL = "http://togglebits.in/food_gospel/";
//    @FormUrlEncoded
//    @Headers({"email:demo@demo.com", "password:demo"})
    @POST("json_parsing.php")
    Call<String> getJSONString();
}
