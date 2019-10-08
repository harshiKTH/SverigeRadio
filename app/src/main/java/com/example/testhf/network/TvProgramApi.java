package com.example.testhf.network;

import com.example.testhf.model.TvProgram;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TvProgramApi {
    @GET("programs?format=json&size=20")
    Call<TvProgram> getProgrames();


}