package com.example.gamereviewsapp.Presentation.Repository.Api;

import com.example.gamereviewsapp.Domain.Model.Game;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RAWGApi {
    @GET("api/games")
    Call<Game> getGames(@Header("Authorization") String token);
}
