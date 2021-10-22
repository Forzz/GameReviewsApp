package com.example.gamereviewsapp.Presentation.Repository.Api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gamereviewsapp.BuildConfig;
import com.example.gamereviewsapp.Domain.Model.Game;
import com.example.gamereviewsapp.Presentation.Repository.Api.Models.Example;
import com.google.gson.Gson;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RAWGApiProvider {
    private RAWGApi api;
    private MutableLiveData<List<Game>> games;
//    private Bitmap img;

    public RAWGApiProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.rawg.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(RAWGApi.class);
        games = new MutableLiveData<>();
        getGames();
    }

    public LiveData<List<Game>> getApiGames() {
        return games;
    }

    private void getGames() {
        api.getGames(BuildConfig.RAWG_API_KEY).enqueue(new Callback<Example>() {
            private List<Game> gamesTemp = new ArrayList<>();

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getResults().size(); i++) {
//                        new DownloadImageTask().execute(response.body().getResults().get(i).getBackgroundImage());
                        Game game = new Game(
                                i,
                                response.body().getResults().get(i).getName(),
//                                img,
                                response.body().getResults().get(i).getMetacritic(),
                                response.body().getResults().get(i).getRating());
                        gamesTemp.add(game);
                    }
                    games.setValue(gamesTemp);
                } else {
                    System.out.println(response);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

//    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
//
//        protected Bitmap doInBackground(String... urls) {
//            String urldisplay = urls[0];
//            Bitmap mIcon11 = null;
//            try {
//                InputStream in = new java.net.URL(urldisplay).openStream();
//                mIcon11 = BitmapFactory.decodeStream(in);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            img = mIcon11;
//            return mIcon11;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            ;
//        }
//    }
}
