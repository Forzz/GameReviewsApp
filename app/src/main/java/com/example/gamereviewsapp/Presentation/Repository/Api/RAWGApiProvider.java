package com.example.gamereviewsapp.Presentation.Repository.Api;

import com.example.gamereviewsapp.BuildConfig;
import com.example.gamereviewsapp.Domain.Model.Game;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RAWGApiProvider {
    private RAWGApi api;

    public RAWGApiProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.rawg.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(RAWGApi.class);
        getGames();
    }

    private void getGames() {
        api.getGames(BuildConfig.RAWG_API_KEY).enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.toString());
                } else {
                    System.out.println("Response dead");
                    System.out.println(response);
                }
            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {

            }
        });
    }
}
