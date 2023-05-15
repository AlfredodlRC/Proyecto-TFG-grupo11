package com.example.ticktask.IO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApiService {

    @GET("login")
    Call<Boolean> getLogin(
            @Query("username") String username,
            @Query("password") String password
    );


}
