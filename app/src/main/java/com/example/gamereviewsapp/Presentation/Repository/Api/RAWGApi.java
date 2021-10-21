package com.example.gamereviewsapp.Presentation.Repository.Api;

import com.example.gamereviewsapp.Presentation.Repository.Api.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RAWGApi {
    @GET("/api/games")
    Call<Example> getGames(@Query("key") String token);
}
